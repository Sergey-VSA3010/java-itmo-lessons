package com.company.project.lesson28;

public record Product // аналог класса с final св-ми без сеттеров!!!
        (String name, int price,int count) {


    public void add(Product product) {
    }
}
