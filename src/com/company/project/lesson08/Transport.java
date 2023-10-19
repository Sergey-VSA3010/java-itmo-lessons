package com.company.project.lesson08;
 // Транспортное ср-во
 // нельзя создать экземпляр абстрак класса (вызвать констр)
// можно
abstract public class Transport  {
    protected String number;// null
    protected int levelOfWare;// 0
    protected int maxSpeed = 120;// 120

    public Transport(String number) {
        this.number = number;//
    }

    public Transport(String number, int maxSpeed) {
        this(number);
        this.maxSpeed = maxSpeed;
    }

    public Transport(String number, int levelOfWare, int maxSpeed) {
        this.number = number;
        this.levelOfWare = levelOfWare;
        this.maxSpeed = maxSpeed;
    }

    public String getNumber() {
        return number;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getLevelOfWare() {
        return levelOfWare;
    }

    public void incLevelOfWare(int value){
        if(value < 0) return;
        levelOfWare += value;
    }
    public void repair(){
        if(levelOfWare > 0)
            levelOfWare--;

    }
    // абстрактные методы - методы без реализации
    public abstract void stop();


 }
