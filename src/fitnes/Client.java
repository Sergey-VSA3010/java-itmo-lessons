package fitnes;
import java.time.LocalDate;
import java.util.Objects;

public class Client {
    private final String name;
    private final String surname;
    private final LocalDate birthDate;

    public Client(String name, String surname, String birthDate) {
        if (name.trim().length() < 2 || name == null)
            throw new IllegalArgumentException("Имя должно быть больше 2 символов");
        if (surname.trim().length() < 2 || surname == null)
            throw new IllegalArgumentException("Фамилия должна быть больше 2-х символов");
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(birthDate, client.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

    @Override
    public String toString() {
        return "Client ---" +
                "  " + name +
                ",  " + surname +
                ", дата рождения " + birthDate +
                " ---";
    }
}

