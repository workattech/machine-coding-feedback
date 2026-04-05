package ThreadSafeInMemoryFileSystem;

class File extends FileNode {
    private String content = "";

    public File(String name, Directory parent) {
        super(name, parent);
    }

    public String read() {
        lock.readLock().lock();
        try {
            return content;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(String data) {
        lock.writeLock().lock();
        try {
            content = data;
        } finally {
            lock.writeLock().unlock();
        }
    }
}