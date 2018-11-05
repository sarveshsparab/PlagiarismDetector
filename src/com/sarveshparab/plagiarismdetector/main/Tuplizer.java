package com.sarveshparab.plagiarismdetector.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * This class build the tuples from the input file contents based on the tuple size
 */
public class Tuplizer {

    /**
     * This core method generates the tuples of the required size from the input file
     * @param lines Input file contents in form of a list of strings
     * @param tupleSize The size of the tuples to be generated
     * @return A list of strings of the tuples
     */
    List<String> tuplize(List<String> lines, int tupleSize) {
        List<String> generatedTuples = new ArrayList<>();

        for (String line : lines) {
            String[] words = line.split(" ");
            List<String> tuples = new ArrayList<>();

            if(words.length < tupleSize) {
                tuples.add(line);
                return tuples;
            }

            for (int i = 0; i < words.length - tupleSize + 1; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < tupleSize; j++)
                    sb.append(words[i + j]).append(" ");
                tuples.add(sb.toString().trim());
            }

            generatedTuples.addAll(tuples);
        }

        return generatedTuples;
    }
}
