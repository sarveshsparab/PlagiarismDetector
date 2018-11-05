package com.sarveshparab.plagiarismdetector.main;

import com.sarveshparab.plagiarismdetector.commandlinehandler.CommandLineArgHandler;

public class PDMain {

    public static void main(String[] args){
        CommandLineArgHandler cmdLineArgHandler = new CommandLineArgHandler();
        cmdLineArgHandler.interpretArgs(args);

        String file1 = cmdLineArgHandler.getFirstFileName();
        String file2 = cmdLineArgHandler.getSecondFileName();
        String synonymFile = cmdLineArgHandler.getSynonymFileName();

        int tupleSize = cmdLineArgHandler.getTupleSize();

        PDPrimary pdp = new PDPrimary(file1, file2, synonymFile, tupleSize);
        System.out.println(pdp);

        PDEngine engine = new PDEngine();

        float plagiarismPercent = engine.detect(pdp);

        System.out.println("\n================= Plagiarism Percentage =================");
        System.out.println(plagiarismPercent+"%");

    }

}
