package com.sarveshparab.plagiarismdetector.exceptions;

import java.util.logging.Logger;

public class PDException extends RuntimeException {

    private final static Logger LOGGER = Logger.getLogger(PDException.class.getName());

    private static final long serialVersionUID = -6530096872564225733L;

    private final ErrorCode code;

    public PDException(String message, ErrorCode code) {
        super(message);
        this.code = code;
        LOGGER.severe("Plagiarism Detector custom Exception raised : " + code.getErrorCodeMeaning(code));
    }

    public PDException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
        LOGGER.severe("Plagiarism Detector custom Exception raised : " + code.getErrorCodeMeaning(code));
    }

    public ErrorCode getErrorCode(){
        return this.code;
    }
}
