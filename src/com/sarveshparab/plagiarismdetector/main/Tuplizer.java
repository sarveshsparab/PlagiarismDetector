package com.sarveshparab.plagiarismdetector.main;

import java.util.ArrayList;
import java.util.List;

public class Tuplizer {
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
