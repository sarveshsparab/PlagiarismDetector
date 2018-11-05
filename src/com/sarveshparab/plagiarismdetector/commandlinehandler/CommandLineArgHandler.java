package com.sarveshparab.plagiarismdetector.commandlinehandler;

import com.sarveshparab.plagiarismdetector.util.PDUtilStrings;
import com.sarveshparab.plagiarismdetector.util.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * This class handles the command line arguments recieved
 * It parses the input arguments string array and stores the required input arguments in a map for easy future access
 */
public class CommandLineArgHandler {

    /**
     * Logger instance created
     */
    private final static Logger LOGGER = Logger.getLogger(CommandLineArgHandler.class.getName());

    /**
     * Map to hold the arguments supplied
     */
    private Map<String, String> argsMap = new HashMap<>();

    /**
     * This is the core function that interprets the input command line arguments and segregates into the corresponding
     * input file names, synonym files and tuple size
     * @param args The arguments array supplied
     */
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

    /**
     * Getter for the arguments map
     * @return Map of the arguments
     */
    public Optional<Map<String, String>> getArgs(){
        return Optional.of(this.argsMap);
    }

    /**
     * Getter for first file name
     * @return First file name string
     */
    public String getFirstFileName(){
        return argsMap.get(PDUtilStrings.FILE_1);
    }

    /**
     * Getter for the second file name
     * @return Second file name string
     */
    public String getSecondFileName(){
        return argsMap.get(PDUtilStrings.FILE_2);
    }

    /**
     * Getter for the synonym file
     * @return Synonym file name string
     */
    public String getSynonymFileName(){
        return argsMap.get(PDUtilStrings.SYNONYM_FILE);
    }

    /**
     * Getter for the tuple size
     * Checks of the supplied tuple size is valid integer or not
     * Also if not supplied, set the tuple size to the default value
     * @return
     */
    public int getTupleSize(){
        if(Validator.validateTupleSize(argsMap))
            return Integer.parseInt(argsMap.get(PDUtilStrings.TUPLE_SIZE));
        return Integer.parseInt(PDUtilStrings.DEFAULT_TUPLE_SIZE);
    }
}
