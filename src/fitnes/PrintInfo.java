package fitnes;
import java.time.LocalDate;
import java.time.LocalTime;

public class PrintInfo {
    public static void areaIsFull() {
        System.out.println("В зоне нет свободных мест!");
    }



    public static void finnessZoneInfo(Abonement abonement) {
        StringBuilder string = new StringBuilder();
        string.append("Клиент: ").
                append(abonement.getClient().toString());
        System.out.println(string.toString());
    }




    public static void abonementInfo(Abonement abonement, LocalDate date, LocalTime time, String zone) {
        StringBuilder sb = new StringBuilder();
        sb.append("Клиент: ").
                append(abonement.getClient().toString()).
                append(" Дата посещения: ").
                append(date.toString()).
                append(" Время посещения: ").
                append(time.toString()).
                append(" Посещаемая зона: ").
                append(zone);

        System.out.println(sb.toString());
    }




}
