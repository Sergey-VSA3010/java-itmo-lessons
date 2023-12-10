package com.company.project.lesson18;

import com.company.project.lesson14.task14.properties.vehicle.*;

import java.util.List;

public class Less18 {
    List<Vehicle> vehicles = List.of(
            new Car(Repaintable.Color.GOLD, "001"),
            new Train("002", 10, true),
            new MiniCar(Repaintable.Color.ORANGE, "003"),
            new Bus("004"),
            new Train("005", 15, false),
            new Car(Repaintable.Color.BLACK, "006"),
            new MiniCar(Repaintable.Color.ORANGE, "007"));
}
