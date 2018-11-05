package com.sarveshparab.plagiarismdetector.exceptions;

public class PDException extends RuntimeException {

    private static final long serialVersionUID = -6530096872564225733L;

    private final ErrorCode code;

    public PDException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public PDException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ErrorCode getErrorCode(){
        return this.code;
    }
}
