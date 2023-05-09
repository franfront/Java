package org.ffernandez.datetime.ej;

import java.time.LocalDate;
import java.time.Period;

public class EjPeriod {
    public static void main(String[] args) {

        LocalDate ld1 = LocalDate.of(2017, 8, 3);
        LocalDate ld2 = LocalDate.of(2023, 5, 8);
        LocalDate ld3 = ld2.withMonth(8);
        ld3 = ld3.withDayOfMonth(3);



        Period p = Period.between(ld1, ld3);

        System.out.println(p);

        System.out.printf("Periodo entre %s y %s hay %d años, %d meses y %d días", ld1, ld3, p.getYears(), p.getMonths(), p.getDays());





    }
}
