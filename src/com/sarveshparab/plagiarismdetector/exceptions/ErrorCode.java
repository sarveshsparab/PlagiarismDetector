package com.sarveshparab.plagiarismdetector.exceptions;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
    INPUT_FILE_READING_ERROR(1),
    FILE_1_UNAVAILABLE(2),
    FILE_2_UNAVAILABLE(3),
    SYNONYM_FILE_UNAVAILABLE(4),
    TUPLE_SIZE_UNAVAILABLE(5),
    TUPLE_SIZE_INVALID(6);

    private int errorCode;
    private static Map<Integer, ErrorCode> errorCodeMeanings = new HashMap<>();

    static {
        for (ErrorCode code : ErrorCode.values()) {
            errorCodeMeanings.put(code.getErrorCode(), code);
        }
    }

    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ErrorCode getErrorCodeMeaning(Integer code){
        return errorCodeMeanings.get(code);
    }

    public ErrorCode getErrorCodeMeaning(ErrorCode code){
        return getErrorCodeMeaning(code.errorCode);
    }

}
