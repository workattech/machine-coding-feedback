package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        InputService inputService = InputService.getInstance();

        inputService.takeInputs();
    }
}
