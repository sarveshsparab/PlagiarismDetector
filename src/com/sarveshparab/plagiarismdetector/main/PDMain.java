package com.sarveshparab.plagiarismdetector.main;

import com.sarveshparab.plagiarismdetector.commandlinehandler.CommandLineArgHandler;

import java.util.logging.Logger;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * This is the main class where the plagiarism detector starts up
 */
public class PDMain {

    /**
     * Logger instance created
     */
    private final static Logger LOGGER = Logger.getLogger(PDMain.class.getName());

    /**
     * This is the point of the start of the project
     * @param args Arguments supplied
     */
    public static void main(String[] args){
        CommandLineArgHandler cmdLineArgHandler = new CommandLineArgHandler();
        cmdLineArgHandler.interpretArgs(args);

        String file1 = cmdLineArgHandler.getFirstFileName();
        String file2 = cmdLineArgHandler.getSecondFileName();
        String synonymFile = cmdLineArgHandler.getSynonymFileName();

        int tupleSize = cmdLineArgHandler.getTupleSize();

        PDPrimary pdp = new PDPrimary(file1, file2, synonymFile, tupleSize);
        LOGGER.info(pdp.toString());

        PDEngine engine = new PDEngine();

        double plagiarismPercent = engine.detect(pdp);

        LOGGER.info("Plagiarism Percentage : " + plagiarismPercent + "%");
    }

}
