package ru.voronkov.HomeWork003.models;

public class User {
    // поля
    private String name;
    private int age;
    private String email;

    // методы get и set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}