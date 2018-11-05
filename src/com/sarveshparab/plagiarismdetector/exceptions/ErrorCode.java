package com.sarveshparab.plagiarismdetector.exceptions;

public enum ErrorCode {
    INPUT_FILE_READING_ERROR(1);

    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
