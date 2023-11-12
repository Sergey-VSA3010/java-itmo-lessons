package com.company.project.lesson14.task14;

import java.io.Serializable;

public class PairContainer <T> {

private T key;
private T value;

    public PairContainer(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        User user = new User(123);
        PairContainer pairContainer1 = new PairContainer(123,"sddd");
        PairContainer pairContainer2 = new PairContainer("123",user );
        PairContainer pairContainer3 = new PairContainer(234,user );
        PairContainer pairContainer4 = new PairContainer("werr",pairContainer3 );


    }


   /* interface Eatable extends Serializable{}
    interface Runnable {}

    class Animal implements Runnable{}

    class Cat extends Animal implements Eatable{}
    class Kitten extends Cat{}

    class Dog extends Animal implements Serializable {}


    class Task {
        public static  <T extends Cat & Eatable> void void01(T object){
            // ВОПРОС: методы каких типов можно вызвать у object ???
                         !!Cat Animal
        }
        public static  <T extends Animal & Serializable> void void02(T object){
            // ВОПРОС: методы каких типов можно вызвать у object ???
                         !!Animal
        }
        public static  <T extends Serializable & Runnable> void void03(T object){
            // ВОПРОС: методы каких типов можно вызвать у object ???
                        !!Dog Animal
        }
        public static void main(String[] args) {
            //Task.</* ОТВЕТ: Cat *///>void01(/* Cat,kitten */);
           //Task.</* ОТВЕТ: Dog */>void02(/* Dog */);
            //Task.ОТВЕТ:<Dog>void03(/* Dog */);

}
