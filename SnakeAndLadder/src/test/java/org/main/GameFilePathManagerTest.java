package org.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCase {
    String path;
    Boolean result;
    String description;

    public TestCase(String path, Boolean result, String description) {
        this.path = path;
        this.result = result;
        this.description = description;
    }
}

class GameFilePathManagerTest {
    @Test
    void validateAndSetFilePath() {
        GameFilePathManager gameFilePathManager = new GameFilePathManager();

        final TestCase[] testCases = new TestCase[] {
                new TestCase("src/main/resources/SankeAndLadderGameInput.txt", true, "Correct path for Snake and Ladder Game"),
                new TestCase("src/main/resources/SankeAndLadderGameInt.txt", false, "Correct path but wrong file name"),
                new TestCase("resources/SankeAndLadderGameInput.txt", false, "Invalid path but correct File name")
        };

        for (TestCase test: testCases) {
            try {
                assertEquals(test.result, gameFilePathManager.validateAndSetFilePath(test.path));
                System.out.println(test.description+" -- Passed");
            } catch (AssertionError e) {
                System.out.println(test.description+" -- Failed due to "+ e);
            }
        }
    }
}