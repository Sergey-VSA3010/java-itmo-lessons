package fitnes;

import java.time.LocalTime;

abstract public class Fitness {
    public static final String Pool = "Бассейн";
    public static final String Workout = "Тренажерный зал";
    public static final String Group = "Групповые занятия";

    public static final int max = 20;

    public static final int fullAbonement = 1;
    public static final int dayAbonement = 2;
    public static final int singleAbonement = 3;

    public static String[] setAreas(int typeTicket) {
        String[] areas = new String[3];
        switch (typeTicket) {
            case fullAbonement:
                areas = new String[3];
                areas[0] = Pool;
                areas[1] = Workout;
                areas[2] = Group;
                break;
            case dayAbonement:
                areas = new String[2];
                areas[0] = Workout;
                areas[1] = Group;
                break;
            case singleAbonement:
                areas = new String[2];
                areas[0] = Workout;
                areas[1] = Pool;
                break;
            default:
                System.out.println("Не правильно указан тип абонемента!");
                break;
        }
        return areas;

    }

    public static LocalTime setTimeStart(int typeTicket) {
        LocalTime time = LocalTime.of(0, 0, 0);
        switch (typeTicket) {
            case fullAbonement:
                time = LocalTime.of(8, 0, 0);
                break;
            case dayAbonement:
                time = LocalTime.of(8, 0, 0);
                break;
            case singleAbonement:
                time = LocalTime.of(8, 0, 0);
                break;
            default:
                System.out.println("Не правильно указан тип абонемента!");
                break;
        }
        return time;
    }

    public static LocalTime setTimeEnd(int typeTicket) {
        LocalTime time = LocalTime.of(0, 0, 0);
        switch (typeTicket) {
            case fullAbonement:
                time = LocalTime.of(22, 0, 0);
                break;
            case dayAbonement:
                time = LocalTime.of(16, 0, 0);
                break;
            case singleAbonement:
                time = LocalTime.of(22, 0, 0);
                break;
            default:
                System.out.println("Не правильно указан тип абонемента!");

                break;

        }
        return time;
    }

}
