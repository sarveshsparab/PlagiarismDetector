package com.sarveshparab.plagiarismdetector.util;

import com.sarveshparab.plagiarismdetector.exceptions.ErrorCode;
import com.sarveshparab.plagiarismdetector.exceptions.PDException;

import java.util.Map;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * This class helps to validate the input from the command line
 */
public class Validator {

    /**
     * The command line input validation
     * @param argsMap The supplied arguments map
     * @return True if input supplied arguments are valid or all provided
     */
    public static boolean validateCmdInput(Map<String, String> argsMap){
        if (!argsMap.containsKey(PDUtilStrings.FILE_1))
            throw new PDException("Input file 1 unavailable", ErrorCode.FILE_1_UNAVAILABLE);

        if (!argsMap.containsKey(PDUtilStrings.FILE_2))
            throw new PDException("Input file 2 unavailable", ErrorCode.FILE_2_UNAVAILABLE);

        if (!argsMap.containsKey(PDUtilStrings.SYNONYM_FILE))
            throw new PDException("Synonyms unavailable", ErrorCode.SYNONYM_FILE_UNAVAILABLE);

        return true;
    }

    /**
     * Tuple size validation
     * @param argsMap The supplied arguments map
     * @return True if the tuple size is a valid integer
     */
    public static boolean validateTupleSize(Map<String, String> argsMap) {
        if (argsMap.containsKey(PDUtilStrings.TUPLE_SIZE)) {
            if (!validateInteger(argsMap.get(PDUtilStrings.TUPLE_SIZE).trim()))
                throw new PDException("Tuple Size not an Integer", ErrorCode.TUPLE_SIZE_INVALID);
            else return true;
        }
        return false;
    }

    /**
     * Helper function to check of the input string is a valid integer
     * @param intStr Input integer as string
     * @return True if input string is valid integer
     */
    private static boolean validateInteger(String intStr){
        try {
            Integer.parseInt(intStr);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

}
