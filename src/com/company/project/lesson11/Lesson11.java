package com.company.project.lesson11;

import java.util.Arrays;

public class Lesson11 {
    public static void main(String[] args) {
        Country france = Country.FRANCE;
        Article article = new Article(Country.ITALY);
        // сравнивать перечисления можно через ==
        System.out.println(france == article.getCountry());
        // реализация аналогична сравнению через ==
        System.out.println(france.equals(article.getCountry()));

           // методы перечисления
        Country[] countries = Country.values();
        Planets[] planets = Planets.values();
        System.out.print(Arrays.toString(countries));
        System.out.println(Country.USA.ordinal());//  1 вернет индекс элемента в массиве

        System.out.println(france.name());
        Country.ITALY.setName("Италия");
        Country.FRANCE.setName("Франция");
        System.out.println();


    }
}
