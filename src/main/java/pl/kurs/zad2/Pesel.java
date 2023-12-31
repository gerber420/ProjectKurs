package pl.kurs.zad2;

import java.time.LocalDate;
import java.util.Optional;

public class Pesel {
    public static String peselToDate(String pesel) {
        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));

        if (month > 20) {
            year += 2000;
            month -= 20;
        } else if (month > 12) {
            year += 1900;
            month -= 10;
        } else {
            year += 1900;
        }
        String date = day + "." + month + "." + year;
        return date;

    }

    public static LocalDate birthDay(String pesel) {
        return Optional.ofNullable(pesel)
                .filter(x -> x.length() == 11)
                .map(PeselValidator::dateOfBirth)
                .orElseThrow();
    }

    public static boolean isValid(String pesel) {
        return pesel.length() == 11;
    }
}
