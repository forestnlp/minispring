package com.geek.minis.ioc01;

public class Geek implements SuperMan {
    private int id;
    private String name;

    public Geek() {
    }

    public Geek(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void bang() {
        System.out.println("I am trying every posibility");
        System.out.println("...");
        System.out.println("Done ! by " + name);
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
}
