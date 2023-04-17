package com.example.beanproject;

import java.io.Serializable;

public class BeanOne implements Serializable {
    private String name;
    private String surname;
    public BeanOne(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "BeanOne{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
