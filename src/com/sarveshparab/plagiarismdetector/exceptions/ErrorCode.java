package com.sarveshparab.plagiarismdetector.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 * Enum to hold the error codes and thier mappings
 */
public enum ErrorCode {
    INPUT_FILE_READING_ERROR(1),
    FILE_1_UNAVAILABLE(2),
    FILE_2_UNAVAILABLE(3),
    SYNONYM_FILE_UNAVAILABLE(4),
    TUPLE_SIZE_UNAVAILABLE(5),
    TUPLE_SIZE_INVALID(6);

    private int errorCode;
    private static Map<Integer, ErrorCode> errorCodeMeanings = new HashMap<>();

    /**
     * Static block to initialize the error codes mappings
     */
    static {
        for (ErrorCode code : ErrorCode.values()) {
            errorCodeMeanings.put(code.getErrorCode(), code);
        }
    }

    /**
     * Initializes the error code enum
     * @param errorCode The integer value of the error code
     */
    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter for the error code
     * @return Errorcode integer value
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Getter of the verbose error code name
     * @param code Integer value of the error code
     * @return Error code string
     */
    public ErrorCode getErrorCodeMeaning(Integer code){
        return errorCodeMeanings.get(code);
    }

    /**
     * Getter of the verbose error code name
     * @param code Integer value of the error code
     * @return Error code string
     */
    public ErrorCode getErrorCodeMeaning(ErrorCode code){
        return getErrorCodeMeaning(code.errorCode);
    }

}
