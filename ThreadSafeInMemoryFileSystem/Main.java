package ThreadSafeInMemoryFileSystem;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FileSystem fs = new FileSystem();

        fs.mkdir("/", "A");
        fs.mkdir("/", "B");

        fs.createFile("/A", "file1");
        fs.createFile("/B", "file2");

        // 🧵 Thread A: move A → B
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                fs.move("/A", "/B", "file1");
                fs.move("/B", "/A", "file1");
            }
        });

        // 🧵 Thread B: reverse move
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                fs.move("/B", "/A", "file2");
                fs.move("/A", "/B", "file2");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final /A: " + fs.ls("/A"));
        System.out.println("Final /B: " + fs.ls("/B"));
    }
}