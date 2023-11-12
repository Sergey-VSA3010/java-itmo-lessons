package com.company.project.lesson10.staticmodifier;


public class Bouquet {
    public int numberOfFlowers;
    public String type;

    // íå ÿâëÿþòñÿ ñâîéñòâàìè îáúåêòîâ
    public static int numberOfFlowersStatic;
    public static String typeStatic;

    static { // static áëîê
        // èíñòðóêöèè âûïîëíÿþòñÿ îäèí ðàç ïðè çàãðóçêå êëàññà
        // â ïðîãðàììó
        // èñïîëüçóåòñÿ äëÿ èíèöèàëèçàöèè static ñâîéñòâ,
        // âîçìîæåí âûçîâ static ìåòîäîâ
        typeStatic = getType();
    }

    public double getPrice(){
        double price = Math.random() * 300 * numberOfFlowers;
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    // íå îïðåäåëÿþò ôóíêöèîíàë îáúåêòîâ
    public /* final ïî óìîë÷àíèþ */ static double getPriceStatic(){
        // èç static ìåòîäîâ íåëüçÿ:
        // 1. îáðàùàòüñÿ ê íå static ñâîéñòâàì
        // 2. âûçûâàòü íå static ìåòîäû
        // double price = Math.random() * 300 * this.numberOfFlowers; - îøèáêà
        // double price = getPrice(); - îøèáêà
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    private static String getType(){
        String[] types = {"Êðóãëûé", "Êàñêàäíûé", "Ñïèðàëüíûé"};
        return types[(int) (Math.random()*types.length)];
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "numberOfFlowers= " + numberOfFlowers +
                ", numberOfFlowersStatic= " + numberOfFlowersStatic +
                ", type='" + type + '\'' +
                ", typeStatic='" + typeStatic + '\'' +
                '}';
    }
}
