package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputService {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public String readFromCommandLine() throws IOException {
        return bufferedReader.readLine();
    }
}
