package com.company.project.lesson12.record.exeptions;

public class User implements Cloneable{
    private int age;
    @Override
    public User clone() throws CloneNotSupportedException{
        return (User) super.clone();
    }


}
