package fitnes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Areas extends Fitness{
    private Abonement[] areaPool ;
    private Abonement[] areaWorkout;
    private Abonement[] areaGroup;
    String[] areas = new String[3];




    public Areas() {
        areaPool = new Abonement[max];
        areaWorkout = new Abonement[max];
        areaGroup = new Abonement[max];

        areas[0] = Pool;
        areas[1] = Group;
        areas[2] = Workout;
    }

    public static void clearAreas() {
    }


    public void abonementVerification(String areas, Abonement abonement, LocalDate currentDate, LocalTime currentTime) {
        boolean areaAccess = false;


        if (!validityDate(abonement, currentDate)) {
            System.out.println("Абонемент недействителен!");
            return;
        }

        for (String z : abonement.allowedZones) {
            if (z.equals(areas)) {
                areaAccess = true;
                break;
            }
        }
        if (!areaAccess) {
            System.out.println("Данная зона недоступна по данному абонементу!");
            return;
        }

        if (searchAbonementInAreas(abonement)) {
            System.out.println("Данный абонемент уже зарегистрирован!");
            return;
        }

        if (!validityTime(abonement, currentTime)) {
            System.out.println("Данный абонемент уже зарегистрирован!");
            return;
        }

        if (areas.equals(Pool)) {
            for (int i = 0; i < areaPool.length; i++) {
                if (areaPool[i] == null) {
                    areaPool[i] = abonement;
                    PrintInfo.abonementInfo(abonement, currentDate, currentTime, areas);                    return;
                }
            }
        }
        if (areas.equals(Workout)) {
            for (int i = 0; i < areaWorkout.length; i++) {
                if (areaWorkout[i] == null) {
                    areaWorkout[i] = abonement;
                    PrintInfo.abonementInfo(abonement, currentDate, currentTime, areas);                    return;
                }
            }
        }
        if (areas.equals(Group)) {
            for (int i = 0; i < areaGroup.length; i++) {
                if (areaGroup[i] == null) {
                    areaGroup[i] = abonement;
                    PrintInfo.abonementInfo(abonement, currentDate, currentTime, areas);
                    return;
                }
            }
        }
        PrintInfo.areaIsFull();
    }
    private boolean searchAbonementInAreas(Abonement abonement) {
        for (Abonement a : areaPool) {
            if (a == abonement) return true;
        }
        for (Abonement a : areaWorkout) {
            if (a == abonement) return true;
        }
        for (Abonement a : areaGroup) {
            if (a == abonement) return true;
        }
        return false;
    }
    private static boolean validityDate(Abonement abonement, LocalDate currentDate) {
        if ((abonement.registrStart.isBefore(currentDate) || abonement.registrStart.isEqual(currentDate))
                && (abonement.dateEnd.isAfter(currentDate) || abonement.dateEnd.isEqual(currentDate)))
            return true;
        else return false;
    }
    private static boolean validityTime(Abonement abonement, LocalTime currentTime) {
        if ((abonement.timeStart.isBefore(currentTime) || abonement.timeStart.equals(currentTime))
                && (currentTime.isBefore(abonement.timeEnd)))
            return true;
        else return false;
    }
    public void infoFitness() {

        System.out.println("\nТренажерный зал:");
        for (Abonement a : areaWorkout) {
            if (a != null) PrintInfo.finnessZoneInfo(a);
        }

        System.out.println("\nБассейн:");
        for (Abonement a : areaPool) {
            if (a != null) PrintInfo.finnessZoneInfo(a);
        }

        System.out.println("\nГрупповые занятия:");
        for (Abonement a : areaGroup) {
            if (a != null) PrintInfo.finnessZoneInfo(a);
        }
    }
    public  void clearAreas(LocalTime currentTime) {
        for (int i = 0; i < areaPool.length; i++) {
            if (areaPool[i] != null && !validityTime(areaPool[i], currentTime)) {
                areaPool[i] = null;
            }
        }
        for (int i = 0; i < areaWorkout.length; i++) {
            if (areaWorkout[i] != null && !validityTime(areaWorkout[i], currentTime)) {
                areaWorkout[i] = null;
            }
        }
        for (int i = 0; i < areaGroup.length; i++) {
            if (areaGroup[i] != null && !validityTime(areaGroup[i], currentTime)) {
                areaGroup[i] = null;
            }
        }
    }
}
