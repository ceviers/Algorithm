package com.cevier.algorithm.LinearSearch;

public class AnObject {

    private int id;
    private String name;
    private int size;

    public AnObject(int id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnObject anObject = (AnObject) o;
        return id == anObject.id;
    }

}
