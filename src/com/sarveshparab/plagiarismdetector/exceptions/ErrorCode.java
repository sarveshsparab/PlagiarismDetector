package com.sarveshparab.plagiarismdetector.exceptions;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
    INPUT_FILE_READING_ERROR(1);

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
