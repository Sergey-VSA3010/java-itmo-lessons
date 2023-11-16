package fitnes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Abonement {
    protected LocalDate registrStart;
    protected LocalDate dateEnd;
    protected Client client;
    private int typeAbonement;
    protected LocalTime timeStart;
    protected LocalTime timeEnd;
    protected String[] allowedZones;


    public Abonement(int typeAbonement,String registrStart, String dateEnd, Client client) {

        if (typeAbonement < 1 || typeAbonement > 3)
            throw new IllegalArgumentException("Тип абонемента  1-3!");
        timeStart = Fitness.setTimeStart(typeAbonement);
        timeEnd = Fitness.setTimeEnd(typeAbonement);
        this.typeAbonement = typeAbonement;
        allowedZones = Fitness.setAreas(typeAbonement);
        this.registrStart =  LocalDate.parse(registrStart);
        this.dateEnd = LocalDate.parse(dateEnd);
        if (client == null)
            throw new IllegalArgumentException("Клиент должен быть не null!");
        this.client = client;
    }



    public LocalDate getRegistrStart() {
        return registrStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonement abonement = (Abonement) o;
        return typeAbonement == abonement.typeAbonement && Objects.equals(registrStart, abonement.registrStart) && Objects.equals(dateEnd, abonement.dateEnd) && Objects.equals(client, abonement.client);
    }



    @Override
    public String toString() {
        return "Abonement{" +
                "registrStart=" + registrStart +
                ", dateEnd=" + dateEnd +
                ", client=" + client +
                ", typeTicket=" + typeAbonement +
                '}';
    }
}
