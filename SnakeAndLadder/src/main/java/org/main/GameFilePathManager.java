package org.main;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter(AccessLevel.PRIVATE)
public class GameFilePathManager {
    private Path filePath;

    public GameFilePathManager() {
        filePath = null;
    }

    public Boolean fileExists(Path path) {
        if (Files.exists(path)) {
            return true;
        }
        return false;
    }

    public Boolean validateAndSetFilePath(String path) {
        if (path == null || path.isEmpty()) {
            System.out.println("The File path provided for the game " +path+ " is not valid");
        } else {
            Path tempFilePath = Paths.get(path);
            if (fileExists(tempFilePath)) {
                filePath = tempFilePath;
                return true;
            }
        }
        return false;
    }

}
