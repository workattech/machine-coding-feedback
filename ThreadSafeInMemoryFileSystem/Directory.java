package ThreadSafeInMemoryFileSystem;

import java.util.*;

class Directory extends FileNode {

    private final Map<String, FileNode> children = new HashMap<>();

    public Directory(String name, Directory parent) {
        super(name, parent);
    }

    // Internal (caller must hold lock)
    public FileNode getChildUnsafe(String name) {
        return children.get(name);
    }

    public void addChild(FileNode node) {
        lock.writeLock().lock();
        try {
            children.put(node.getName(), node);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public FileNode removeChild(String name) {
        lock.writeLock().lock();
        try {
            return children.remove(name);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> list() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(children.keySet());
        } finally {
            lock.readLock().unlock();
        }
    }
}