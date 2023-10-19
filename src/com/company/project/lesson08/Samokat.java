package com.company.project.lesson08;

public class Samokat extends Bicycle implements changeColor{
    private boolean isElectric;

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public Samokat(String number, int maxSpeed, int wheels, boolean isElectric) {
        super("Городской", maxSpeed, 2);
        this.isElectric = isElectric;

    }
        @Override
        public void repair() {
        if (isElectric){
            if (levelOfWare >=2)
            levelOfWare = levelOfWare - 2;
        }else
            if (levelOfWare >0)
                levelOfWare = levelOfWare -3;

        }

    @Override
    public void setColor(String color) {

    }

    @Override
    public void defColor() {

    }
}
