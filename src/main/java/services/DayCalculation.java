package services;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Locale;

public class DayCalculation {

    public String calculateDaySimple() {
        if(LocalDate.now().getDayOfWeek().name().equals("FRIDAY")) {
            return "Yes!";
        }
        return "No!" + " (it's " + LocalDate.now().getDayOfWeek().name().toLowerCase() + ")";
    }

    public String calculateDay() {

        int q = LocalDate.now().getDayOfMonth(); //day of the month (1-31)
        int m = LocalDate.now().getMonthValue(); //the month (1-12)
        int j = LocalDate.now().getYear() / 100; //the century
        int k = LocalDate.now().getYear() % 100; //the year of the century
        int h = (q + (13 * (m+1)/5) + k + (k/4) + (j/4) - 2 * j) % 7;

        int d = ((h + 5) % 7) + 1;

        if(d == 5) {
            return "Yes!";
        } else return "No!";
    }

    public String returnDayOfWeek() {
        return "It's " + LocalDate.now().getDayOfWeek().name().toLowerCase() + ", my dude!";
    }

}
