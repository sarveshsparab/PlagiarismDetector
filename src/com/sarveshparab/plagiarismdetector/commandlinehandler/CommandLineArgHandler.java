package com.sarveshparab.plagiarismdetector.commandlinehandler;

import com.sarveshparab.plagiarismdetector.util.PDUtilStrings;
import com.sarveshparab.plagiarismdetector.util.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class CommandLineArgHandler {

    private final static Logger LOGGER = Logger.getLogger(CommandLineArgHandler.class.getName());

    private Map<String, String> argsMap = new HashMap<>();

    public void interpretArgs(String[] args){
        for(int a = 0; a < args.length ; a = a + 2){
            String arg = args[a].trim().toLowerCase();

            switch (arg){
                case "-f1":
                case "-File1":
                    argsMap.put(PDUtilStrings.FILE_1, args[a+1]);
                    break;

                case "-f2":
                case "-File2":
                    argsMap.put(PDUtilStrings.FILE_2, args[a+1]);
                    break;

                case "-s":
                case "-Synonyms":
                    argsMap.put(PDUtilStrings.SYNONYM_FILE, args[a+1]);
                    break;

                case "-t":
                case "-Tuple":
                    argsMap.put(PDUtilStrings.TUPLE_SIZE, args[a+1]);
                    break;
            }
        }
    }

    public Optional<Map<String, String>> getArgs(){
        return Optional.of(this.argsMap);
    }

    public String getFirstFileName(){
        return argsMap.get(PDUtilStrings.FILE_1);
    }

    public String getSecondFileName(){
        return argsMap.get(PDUtilStrings.FILE_2);
    }

    public String getSynonymFileName(){
        return argsMap.get(PDUtilStrings.SYNONYM_FILE);
    }

    public int getTupleSize(){
        if(Validator.validateTupleSize(argsMap))
            return Integer.parseInt(argsMap.get(PDUtilStrings.TUPLE_SIZE));
        return Integer.parseInt(PDUtilStrings.DEFAULT_TUPLE_SIZE);
    }
}
