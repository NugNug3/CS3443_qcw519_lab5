package edu.utsa.cs3443.qcw519_lab5.model;

public class Role implements java.io.Serializable{
    public String name;

    public Role(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
