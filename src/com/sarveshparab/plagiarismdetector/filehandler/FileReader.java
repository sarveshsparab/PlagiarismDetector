package com.sarveshparab.plagiarismdetector.filehandler;

import com.sarveshparab.plagiarismdetector.exceptions.ErrorCode;
import com.sarveshparab.plagiarismdetector.exceptions.PDException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * This class handles file reading operations
 */
public class FileReader {

    private final static Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    /**
     * This method reads contents of the file line by line
     * Throws PDException if any error in reading file
     * @param fileName The filename / filepath to read from
     * @return A List of strings of lines from the file
     */
    public List<String> readFromFile(String fileName){

        LOGGER.info("Reading input from file : " + fileName);

        Path path = Paths.get(fileName);
        List<String> fileLines;

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
