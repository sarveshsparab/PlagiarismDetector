package com.sarveshparab.plagiarismdetector.filehandler;

import com.sarveshparab.plagiarismdetector.exceptions.ErrorCode;
import com.sarveshparab.plagiarismdetector.exceptions.PDException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> readFromFile(String fileName){
        Path path = Paths.get(fileName);
        List<String> fileLines = new ArrayList<>();

        try (Stream<String> fileStream = Files.lines(path)) {
            fileLines = fileStream
                    .map(fs -> fs.trim().toLowerCase())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new PDException(e.getMessage(), e.getCause(), ErrorCode.INPUT_FILE_READING_ERROR);
        }

        return fileLines;
    }

}
