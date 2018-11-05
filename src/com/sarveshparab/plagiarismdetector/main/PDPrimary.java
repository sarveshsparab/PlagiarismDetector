package com.sarveshparab.plagiarismdetector.main;

public class PDPrimary {

    private String file1;
    private String file2;
    private String synonymFile;
    private int tupleSize;

    public PDPrimary(String file1, String file2, String synonymFile, int tupleSize) {
        this.file1 = file1;
        this.file2 = file2;
        this.synonymFile = synonymFile;
        this.tupleSize = tupleSize;
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    public String getSynonymFile() {
        return synonymFile;
    }

    public void setSynonymFile(String synonymFile) {
        this.synonymFile = synonymFile;
    }

    public int getTupleSize() {
        return tupleSize;
    }

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
