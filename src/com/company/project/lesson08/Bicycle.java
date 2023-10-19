package com.company.project.lesson08;

public class Bicycle extends Transport{     // Transport - супер класс или родительский
    protected int wheels = 2;
    private String type = "Городской";

    public Bicycle(String number, int maxSpeed, int wheels) {
        super(number, maxSpeed); //вызов конструктора родителя
        this.wheels = wheels;
    }

    public Bicycle(String number, String type){
        super(number);
        this.type = type;
    }




    public Bicycle(String number, int maxSpeed) {
        super(number, maxSpeed);
                              // Конструктор род класса. если в род классе нет дефолтного констр


    }
    public int getWheels() {
        return wheels;
    }

    public String getType() {
        return type;
    }

    @Override
    public void stop() {

    }
}
