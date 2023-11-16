package fitnes;

import java.time.LocalDate;


public class ValidDate {
    public static boolean validDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
