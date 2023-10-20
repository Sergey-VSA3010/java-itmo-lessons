package com.company.project.lesson08;

public class RepairShop {
    private Transport[] transports = new Transport[5];
    private String[] colors = {"красный", "жёлтый", "оранжевый", "чёрный"};

    public void addToTransport(Transport transport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports == null) {
                transports[i] = transport;
                if (i == transports.length - 1) {
                    System.out.println("Массив заполнен!");
                    // break ???
                }
            }

        }
    }
        public void repairAll ()
        {
            for (Transport transport : transports) {
                transport.stop(); // реализация у каждого класса своя!!!
                transport.repair();
                transport = null;
                if (transport instanceof Car car) {
                    car.setColor(randomColor());
                }
                transport = null;

            }
        }



    public String randomColor() {
        int rndNum = (int) (Math.random() * colors.length);
        return colors[rndNum];
    }
}
