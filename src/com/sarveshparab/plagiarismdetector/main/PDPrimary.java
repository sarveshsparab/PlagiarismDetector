package com.sarveshparab.plagiarismdetector.main;

/**
 * @author Sarvesh Parab [www.sarveshparab.com]
 *
 * Simple Java POJO class to hold all the attributes required for detection purposes
 */
public class PDPrimary {

    private String file1;
    private String file2;
    private String synonymFile;
    private int tupleSize;

    /**
     * Simple POJO Constructor
     * @param file1 Input file 1
     * @param file2 Input file 2
     * @param synonymFile Synonym file
     * @param tupleSize Tuple size
     */
    public PDPrimary(String file1, String file2, String synonymFile, int tupleSize) {
        this.file1 = file1;
        this.file2 = file2;
        this.synonymFile = synonymFile;
        this.tupleSize = tupleSize;
    }

    /**
     * Getter for the input file 1
     * @return Input file 1 string
     */
    public String getFile1() {
        return file1;
    }

    /**
     * Setter for the input file 1
     * @param file1 Input file 1 String
     */
    public void setFile1(String file1) {
        this.file1 = file1;
    }

    /**
     * Getter for the input file 2
     * @return Input file 2 string
     */
    public String getFile2() {
        return file2;
    }

    /**
     * Setter for the input file 2
     * @param file2 Input file 2 String
     */
    public void setFile2(String file2) {
        this.file2 = file2;
    }

    /**
     * Getter for the synonym file
     * @return Input synonym string
     */
    public String getSynonymFile() {
        return synonymFile;
    }

    /**
     * Setter for the input synonym file
     * @param synonymFile Synonym file String
     */
    public void setSynonymFile(String synonymFile) {
        this.synonymFile = synonymFile;
    }

    /**
     * Getter for the tuple size
     * @return Tuple size integer
     */
    public int getTupleSize() {
        return tupleSize;
    }

    /**
     * Setter for the integer value of tuple size
     * @param tupleSize Tuple size integer
     */
    public void setTupleSize(int tupleSize) {
        this.tupleSize = tupleSize;
    }

    @Override
    public String toString() {
        return "PDPrimary{" +
                "file1='" + file1 + '\'' +
                ", file2='" + file2 + '\'' +
                ", synonymFile='" + synonymFile + '\'' +
                ", tupleSize=" + tupleSize +
                '}';
    }
}
