package com.myblog5.myblog5;

public class Worker {
    private String name;
    private String designation;
    private int age;

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getAge() {
        return age;
    }

    public Worker(String name, String designation, int age) {
        this.name = name;
        this.designation = designation;
        this.age = age;
    }
}
