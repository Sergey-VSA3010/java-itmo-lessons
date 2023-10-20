package com.company.project.lesson07;

public class Cat {
    private String name = "Мурзик";
    private int weight;
    private int wins;

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Cat(int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.replaceAll("\\s", "").length() < 3) {
            throw new IllegalArgumentException("Name не менее 3 символов");

        }
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        //или через Math.random()???
        if (weight >= 1 && weight < 9)
            this.weight = weight;
        else
            throw new IllegalArgumentException("weight должен быть в диапазоне");
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public boolean attack(Cat enemy) {

        if (weight > enemy.weight) {
            wins++;
            System.out.println(getName()+ " Победил " + wins + " раз!");
            return true;
        }
        else enemy.wins++;
        System.out.println(enemy.name + " Победил " + enemy.wins + " раз!");
        return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat(3);
        Cat cat2 = new Cat("Боря",5);
        Cat cat3 = new Cat("Кузя",7);
        System.out.println(cat3.attack(cat1));
        System.out.println(cat3.attack(cat2));
        System.out.println(cat2.attack(cat1));
        System.out.println(cat1.attack(cat3));
        System.out.println(cat3.wins);

    }
}
