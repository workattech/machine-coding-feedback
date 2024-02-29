package in_memory_cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(
                new File("/Users/vedangkarwa/machine-coding-feedback/src/in_memory_cache/Input.txt"))) {
            Cache cache = new Cache();
            while (scanner.hasNextLine()) {
                String[] inputs = scanner.nextLine().split(" ");
                List<String> arguments = new ArrayList<String>();
                for (int i = 2; i < inputs.length; ++i) {
                    arguments.add(inputs[i]);
                }
                if (inputs[0].equals("put")) {
                    try {
                        cache.put(inputs[1], new Value(arguments));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else if (inputs[0].equals("get")) {
                    try {
                        System.out.println(cache.get(inputs[1]));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else if (inputs[0].equals("keys")) {
                    try {
                        List<String> keys = cache.keys();
                        for (String key : keys) {
                            System.out.print(String.format("%s,", key));
                        }
                        System.out.println();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else if (inputs[0].equals("delete")) {
                    try {
                        cache.delete(inputs[1]);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else if (inputs[0].equals("search")) {
                    try {
                        List<String> keys = cache.search(inputs[1], inputs[2]);
                        for (String key : keys) {
                            System.out.print(String.format("%s,", key));
                        }
                        System.out.println();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else if (inputs[0].equals("exit")) {
                    break;
                }
            }
            scanner.close();
        }
    }
}
