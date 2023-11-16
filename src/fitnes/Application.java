package fitnes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.of(2023, 11, 15);
        LocalTime currentTime = LocalTime.of(8, 0, 0);

        Client client1 = new Client("Иван", "Иванов", "1980-01-10");
        Client client2 = new Client("Андрей", "Андреев", "1986-01-25");
        Client client3 = new Client("Сергей", "Сергеев", "1999-03-08");
        Client client4 = new Client("Антон", "Иванов", "2000-11-01");
        Client client5 = new Client("Алексей", "Иванов", "2001-02-01");
        Client client6 = new Client("Алексей", "Перов", "2003-05-01");

        Abonement abonement1 = new Abonement(1, "2023-10-25", "2024-11-20", client1);
        Abonement abonement2 = new Abonement(3, "2023-10-23", "2023-12-10", client3);
        Abonement abonement3 = new Abonement(2, "2023-10-28", "2023-11-23", client2);
        Abonement abonement4 = new Abonement(3, "2023-10-11", "2023-12-02", client4);
        Abonement abonement5 = new Abonement(1, "2023-10-02", "2024-01-01", client6);
        Abonement abonement6 = new Abonement(2, "2023-11-02", "2024-05-01", client5);


        Areas area = new Areas();


        area.abonementVerification(Fitness.Pool, abonement1, currentDate, currentTime);
        area.abonementVerification(Fitness.Group, abonement3, currentDate, currentTime);
        area.abonementVerification(Fitness.Pool, abonement4, currentDate, currentTime);
        area.abonementVerification(Fitness.Workout, abonement2, currentDate, currentTime);
        area.abonementVerification(Fitness.Group, abonement5, currentDate, currentTime);
        area.abonementVerification(Fitness.Workout, abonement6, currentDate, currentTime);

        //System.out.println(client1.getName());
        //System.out.println(LocalDateTime.now());

        //System.out.println(abonement2.getClient());
        area.infoFitness();
        area.clearAreas();
}
}
