package com.sarveshparab.plagiarismdetector.main;

import com.sarveshparab.plagiarismdetector.filehandler.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * The primary class that does the plagiarism detection
 */
public class PDEngine {

    /**
     * Logger instance created
     */
    private final static Logger LOGGER = Logger.getLogger(PDEngine.class.getName());

    private Map<String, String> synonymsMap = new HashMap<>();

    private FileReader fileReader = new FileReader();
    private Tuplizer tuplizer = new Tuplizer();

    /**
     * This is the core method to start the plagiarism detection method
     * @param pdp Takes the java POJO
     * @return The net calculated the plagiarism matching percent values
     */
    double detect(PDPrimary pdp) {
        List<String> file1Tuples = generateInputTuples(pdp.getFile1(), pdp.getTupleSize());
        List<String> file2Tuples = generateInputTuples(pdp.getFile2(), pdp.getTupleSize());

        synonymsMap = Synonymizer.generateMappings(fileReader.readFromFile(pdp.getSynonymFile()));

        return calcPlagiarismMatch(file1Tuples, file2Tuples);
    }

    /**
     * This method calls to reads the contents of the input files and eventually create the tuples for further
     * processing
     * @param fileLocation The input file name / path
     * @param tupleSize The tuple size provided
     * @return The list of strings as tuples
     */
    private List<String> generateInputTuples(String fileLocation, int tupleSize) {
        List<String> fileLines = fileReader.readFromFile(fileLocation);

        List<String> substitutedFileContents = substituteWordsWithSynonyms(fileLines);
        LOGGER.info(substitutedFileContents.toString());

        List<String> generatedTuples = tuplizer.tuplize(substitutedFileContents, tupleSize);
        LOGGER.info(generatedTuples+"\n");

        return generatedTuples;
    }

    /**
     * This method calculates the plagiarism matching
     * @param file1Contents Contents of input file 1 as list
     * @param file2Contents Contents of input file 2 as list
     * @return Double value of the percent matching
     */
    private double calcPlagiarismMatch(List<String> file1Contents, List<String> file2Contents) {
        return file1Contents
                .stream()
                .filter(file2Contents::contains)
                .count() * 100.0 / file1Contents.size();
    }

    /**
     * This method substitutes the words with base word from the synonyms mappings
     * @param fileContents Contents of the input file as list
     * @return Modified list of file contents
     */
    private List<String> substituteWordsWithSynonyms(List<String> fileContents){
        List<String> substitutedLines = new ArrayList<>();
        for (String fcLine : fileContents) {
            String fcWords[] = fcLine.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String fcWord : fcWords) {
                sb.append(synonymsMap.getOrDefault(fcWord, fcWord));
                sb.append(" ");
            }
            substitutedLines.add(sb.toString().trim());
        }
        return substitutedLines;
    }

}
