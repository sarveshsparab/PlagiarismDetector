package com.sarveshparab.plagiarismdetector.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * This class helps us map the multiple synonmys of the same word thus enabling easier access
 */
public class Synonymizer {

    /**
     * This core method
     * @param fileContents The contents of the synonyms files supplied as list of strings
     * @return A map of the synonyms , all one-to-one mappings
     */
    public static Map<String, String> generateMappings(List<String> fileContents) {

        Map<String, String> mappings = new HashMap<>();

        for (String line : fileContents) {

            String[] words = line.split(" ");
            String baseWord = words[0];

            for (int i = 1; i < words.length; i++) {
                if (Objects.isNull(words[i]) || words[i].length() == 0)
                    continue;

                if (mappings.containsKey(baseWord))
                    mappings.put(words[i], mappings.get(baseWord));

                else if (!mappings.containsKey(words[i]))
                    mappings.put(words[i], baseWord);

                else
                    mappings.put(words[i], mappings.get(baseWord));
            }
        }
        return mappings;
    }
}
