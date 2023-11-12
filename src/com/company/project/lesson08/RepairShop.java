package com.company.project.lesson08;

import java.util.Arrays;

public abstract class RepairShop implements changeColor{
    private Transport[] transports = new Transport[5];
    private String[] colors = {"красный", "жёлтый", "оранжевый", "чёрный"};

    public void addToTransport(Transport transport) {
        if (transports[transports.length - 1] != null) {
            System.out.println("Массив заполнен!");
            return;
        }
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] == null) {
                transports[i] = transport;
                return;
            }

        }
    }
        public void repairAll ()
        {
            for (Transport transport : transports) {
                transport.stop(); // реализация у каждого класса своя!!!
                transport.repair();

                if (transport instanceof Car car ) {
                    car.setColor(randomColor());
                }




            }
            Arrays.fill(transports,null);
        }

    public String randomColor() {
        int rndNum = (int) (Math.random() * colors.length);
        return colors[rndNum];
    }
   /* public void printInfo(){
        //Transport[] transports = new Transport[5];
        for (Transport transport : transports){
            switch (transport){
                case Train train -> System.out.println(train.getCountOfWagons());
                case Bicycle bicycle -> System.out.println(bicycle.getWheels());
                default -> System.out.println(transport.levelOfWare);
            }
        }
        for (Transport transport : transports){
            switch (transport) {
                case Train train -> {
                    if (train.isClimatControl()) {
                        System.out.println(train.getCountOfWagons());
                    }
                }
                case Bicycle bicycle when bicycle.getWheels()-> System.out.println(bicycle.getWheels());

            }
        }
    }*/
}
