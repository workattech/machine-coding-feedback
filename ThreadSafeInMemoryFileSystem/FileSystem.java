package ThreadSafeInMemoryFileSystem;


import java.util.*;

class FileSystem {

    private final Directory root = new Directory("/", null);

    // 🔒 Lock Coupling Resolve
    private Directory resolveDir(String path) {
        String[] parts = path.split("/");
        Directory curr = root;

        curr.lock.readLock().lock();

        try {
            for (int i = 1; i < parts.length; i++) {

                FileNode next = curr.getChildUnsafe(parts[i]);
                if (next == null || !(next instanceof Directory)) {
                    return null;
                }

                Directory nextDir = (Directory) next;

                nextDir.lock.readLock().lock();
                curr.lock.readLock().unlock();

                curr = nextDir;
            }
            return curr;

        } finally {
            curr.lock.readLock().unlock();
        }
    }

    // 📁 mkdir
    public boolean mkdir(String path, String dirName) {
        Directory parent = resolveDir(path);
        if (parent == null) return false;

        parent.lock.writeLock().lock();
        try {
            if (parent.getChildUnsafe(dirName) != null) return false;

            parent.addChild(new Directory(dirName, parent));
            return true;

        } finally {
            parent.lock.writeLock().unlock();
        }
    }

    // 📄 create file
    public boolean createFile(String path, String fileName) {
        Directory parent = resolveDir(path);
        if (parent == null) return false;

        parent.lock.writeLock().lock();
        try {
            if (parent.getChildUnsafe(fileName) != null) return false;

            parent.addChild(new File(fileName, parent));
            return true;

        } finally {
            parent.lock.writeLock().unlock();
        }
    }

    // 📄 write
    public boolean write(String path, String fileName, String data) {
        Directory dir = resolveDir(path);
        if (dir == null) return false;

        FileNode node = dir.getChildUnsafe(fileName);
        if (!(node instanceof File)) return false;

        ((File) node).write(data);
        return true;
    }

    // 📄 read
    public String read(String path, String fileName) {
        Directory dir = resolveDir(path);
        if (dir == null) return null;

        FileNode node = dir.getChildUnsafe(fileName);
        if (!(node instanceof File)) return null;

        return ((File) node).read();
    }

    // 📂 ls
    public List<String> ls(String path) {
        Directory dir = resolveDir(path);
        if (dir == null) return List.of();

        return dir.list();
    }

    // 🔥 move (deadlock-free)
    public boolean move(String srcPath, String destPath, String name) {
        Directory src = resolveDir(srcPath);
        Directory dest = resolveDir(destPath);

        if (src == null || dest == null) return false;

        Directory first = src;
        Directory second = dest;

        // Deadlock avoidance
        if (System.identityHashCode(first) > System.identityHashCode(second)) {
            first = dest;
            second = src;
        }

        first.lock.writeLock().lock();
        second.lock.writeLock().lock();

        try {
            FileNode node = src.removeChild(name);
            if (node == null) return false;

            node.parent = dest; // important fix
            dest.addChild(node);

            return true;

        } finally {
            second.lock.writeLock().unlock();
            first.lock.writeLock().unlock();
        }
    }
}