package com.company.project.lesson08;

public class Lesson8 {
    public static void main(String[] args) {
        Bicycle bike1 = new Bicycle("23",54,2);
        bike1.incLevelOfWare(3);
        bike1.repair();

        System.out.println(bike1.levelOfWare);
        System.out.println();

        Train train01 = new Train("123",130,8,true);
        train01.incLevelOfWare(3);
        train01.repair();
        Transport transport1 = new Bicycle("13",45);
        //Train transp = (Train) transport1;
        Car car1 = new Car("110",4,"erer");
        car1.repair();
        Samokat samokat1 = new Samokat("22",32,4,true);
        System.out.println(samokat1.getWheels());
    }
}
