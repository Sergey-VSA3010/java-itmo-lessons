package com.company.project.lesson08;

public  class Car extends Transport implements changeColor{
    private String color;

    public String getColor() {
        return color;
    }

    public Car(String number, int levelOfWare, int maxSpeed, String color) {
        super(number, levelOfWare,  240);
        this.color = "Белый";
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public Car(String number, int maxSpeed, String color) {
        super(number,  240);
        this.color = "Белый";

    }
    @Override
    public void repair(){   //if(levelOfWare > 0);
                            //  levelOfWare--;
         super.repair();
    }

    @Override
    public void stop() {

    }



    @Override
    public void defColor() {

    }
}
