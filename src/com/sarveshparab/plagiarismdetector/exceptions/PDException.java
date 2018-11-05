package com.sarveshparab.plagiarismdetector.exceptions;

import java.util.logging.Logger;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 * Custom exception class to notify specific exceptions reagrding to the plagiarism detection business use case
 */
public class PDException extends RuntimeException {

    private final static Logger LOGGER = Logger.getLogger(PDException.class.getName());

    private static final long serialVersionUID = -6530096872564225733L;

    private final ErrorCode code;

    /**
     * Overridden exception constructor
     * @param message The exception error message
     * @param code The exception error code
     */
    public PDException(String message, ErrorCode code) {
        super(message);
        this.code = code;
        LOGGER.severe("Plagiarism Detector custom Exception raised : " + code.getErrorCodeMeaning(code));
    }

    /**
     * Overridden and overloaded exception constructor
     * @param message The exception error message
     * @param cause The exception underlying cause
     * @param code The exception error code
     */
    public PDException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
        LOGGER.severe("Plagiarism Detector custom Exception raised : " + code.getErrorCodeMeaning(code));
    }

    /**
     * Getter for the error code value
     * @return Integer value fo the error code
     */
    public ErrorCode getErrorCode(){
        return this.code;
    }
}
