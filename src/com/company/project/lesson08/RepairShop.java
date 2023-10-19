package com.company.project.lesson08;

public class RepairShop {
    private Transport[] transports = new Transport[5];
    private String[] colors = {"красный", "жёлтый", "оранжевый", "чёрный"};

    public void addToTransport(Transport transport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports == null) {
                transports[i] = transport;

            }

        }

        public void repairAll ();
        {
            for (Transport transports : transports) {
                transport.stop(); // реализация у каждого класса своя!!!
                transport.repair();
                transport = null;
                if (transport instanceof Car) {
                    transport.changeColor(randomColor());
                }
                transport = null;

            }
        }

    }

    public String randomColor() {
        int rndNum = (int) (Math.random() * colors.length);
        return colors[rndNum];
    }
}
