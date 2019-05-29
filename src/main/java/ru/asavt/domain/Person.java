package ru.asavt.domain;

public class Person {

    private String name;
    private int age;
    private int result;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
