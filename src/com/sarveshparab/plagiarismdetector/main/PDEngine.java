package com.sarveshparab.plagiarismdetector.main;

import com.sarveshparab.plagiarismdetector.filehandler.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDEngine {

    private Map<String, String> synonymsMap = new HashMap<>();

    private FileReader fileReader = new FileReader();
    private Tuplizer tuplizer = new Tuplizer();

    double detect(PDPrimary pdp) {
        List<String> file1Tuples = generateInputTuples(pdp.getFile1(), pdp.getTupleSize());
        List<String> file2Tuples = generateInputTuples(pdp.getFile2(), pdp.getTupleSize());

        synonymsMap = Synonymizer.generateMappings(fileReader.readFromFile(pdp.getSynonymFile()));

        return calcPlagiarismMatch(file1Tuples, file2Tuples);
    }

    private List<String> generateInputTuples(String fileLocation, int tupleSize) {
        List<String> fileLines = fileReader.readFromFile(fileLocation);

        System.out.println("=========== Replaced contents of the file =========");
        List<String> substitutedFileContents = substituteWordsWithSynonyms(fileLines);
        System.out.println(substitutedFileContents);

        System.out.println("========= Tuples for the file ========");
        List<String> generatedTuples = tuplizer.tuplize(substitutedFileContents, tupleSize);
        System.out.println(generatedTuples+"\n");

        return generatedTuples;
    }

    private double calcPlagiarismMatch(List<String> file1Contents, List<String> file2Contents) {
        return file1Contents
                .stream()
                .filter(file2Contents::contains)
                .count() * 100.0 / file1Contents.size();
    }

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
