package ThreadSafeInMemoryFileSystem;

abstract class FileNode {
    protected String name;
    protected Directory parent;

    protected final java.util.concurrent.locks.ReentrantReadWriteLock lock =
            new java.util.concurrent.locks.ReentrantReadWriteLock(true); // fair lock

    public FileNode(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }
}