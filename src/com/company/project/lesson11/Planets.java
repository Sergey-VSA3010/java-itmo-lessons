package com.company.project.lesson11;

public enum Planets {
    MERCURY("Меркурий",3.33E23,2.44E3),
    VENUS("Венера",4.76E24,6.051E3),
    EARTH("Земля",5.97E24,6.378E3),
    MARS("Марс",6.41E23,3.396E3),
    JUPITER("Юпитер",1.86E27,6.9911E4),
    SATURN("Сатурн",5.68E26,5.8232E4),
    URANUS("Уран",8.68E25,2.5362E4),
    NEPTUNE("Нептун",1.02E26,2.4622E4);
    private String name;
    private double weight;
    private double radius;

    Planets(String name, double weight, double radius) {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;

    }

    @Override
    public String toString() {
        return "Planets{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", radius=" + radius +
                '}';
    }
}
