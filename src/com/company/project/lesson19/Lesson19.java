package com.company.project.lesson19;

import com.company.project.lesson14.task14.properties.vehicle.*;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;
import java.util.*;


public class Lesson19 {



    public static void main(String[] args) {
        String[] str = {"wew", "cxx", "sdfd"};
        Stream<String> str2 = Stream.of(str);
        str2.map(s -> s + "12").forEach(s -> System.out.println(s));

        Predicate<Integer> negative = integer -> integer < 0;
        Function<Integer, String> deg = integer -> integer + " deg";
        String degRes = deg.apply(-560); //"-560deg"
        //Consumer<T> void accept(T t);
        Consumer<String> sout = g -> System.out.println(g);
        sout.accept("-560 deg");
        Stream<Integer> temps = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 2);
        temps.filter(negative)  //Stream<Integer> (-560,-55,-100,-20)
                .map(deg) // Stream<String> ("-560deg","-55deg","-100deg","-20deg")
                .forEach(sout);


        // Дан поток целых чисел
        // оставить только уникальные значения - distinct()
        // отрицательные значения заменить на 0 - map(Function fn)
        // отсортировать в порядке убывания - sorted(Comparator comp)
        // вывести элементы в консоль
        Stream<Integer> values = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        values.distinct().map(integer -> integer < 0 ? 0 : integer)
                .sorted((a, b) -> b - a).
                forEach(integer -> System.out.println(integer));

        //- создать строк - Arrays.stream(colors)
        // -оставить цвета, не содержащие жёлтый (yellow) оттенок - filter(Predicate p)
        // - вывести в консоль количество элементов потока - count()
        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        Arrays.stream(colors);
        long count = Arrays.stream(colors)
                .filter(color -> !color.contains("yellow"))
                .count();
        System.out.println(count);

        //получить список неповторяющихся цветов
        // получить список из потока можно методом toList()
        List<Repaintable> repaintables = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.BLACK, "002"),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new MiniCar(Repaintable.Color.BLUE, "005"),
                new Car(Repaintable.Color.BLACK, "006"),
                new Car(Repaintable.Color.ORANGE, "007"));

        List<Repaintable.Color> uniqueColors = repaintables.stream()
                .map(repaintable -> repaintable.getColor())
                .distinct().toList();// unmodifiableList
        System.out.println(uniqueColors);
        // repaintables.stream() стрим из коллекции
        // получить список неповторяющихся цветов
        // получить список из потока можно методом toList()

        // Дан список транспортных средств
        List<Vehicle> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new Train("002", 10, true),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Bus("004"),
                new Train("005", 15, false),
                new Car(Repaintable.Color.BLACK, "006"),
                new MiniCar(Repaintable.Color.ORANGE, "007")
        );

        vehicles.stream().peek(vehicle -> vehicle.repair())//промежуточная
                .map/*ToInt*/(vehicle -> {
            vehicle.repair();
            return vehicle.getLevelOfWare();
        })
                .forEach(integer -> System.out.println(integer));// Терминальная

        // преобразование stream в массив
        Object[] objectsArr = vehicles.stream().toArray();
        Vehicle[] vehiclesArr = vehicles.stream()
                .toArray(Vehicle[]::new); // ссылка на конструктор массива типа FVehicleruit
        // .toArray(size -> new Vehicle[size]); без ссылки на конструктор

        // преобразование stream в список
        List<Vehicle> vehiclesList = vehicles.stream()
                .toList(); // unmodifiableList

        //Optional<Vehicle>
        //vehicles.stream().findFirst();
        //vehicles.stream().parallel().map().findAny();


        //vehicles.stream().collect();
    }
}
