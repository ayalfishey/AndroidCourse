package com.androidclass.contactlist;

public class Person {
    private String firstN, lastN;
    private int age;

    public Person(String firstN, String lastN, int age) {
        this.firstN = firstN;
        this.lastN = lastN;
        this.age = age;
    }

    public String getFirstN() {
        return firstN;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public String getLastN() {
        return lastN;
    }

    public void setLastN(String lastN) {
        this.lastN = lastN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
