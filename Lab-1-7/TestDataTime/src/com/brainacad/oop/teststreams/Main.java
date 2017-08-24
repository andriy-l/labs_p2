package com.brainacad.oop.teststreams;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1992, 9, 12);

        System.out.println(currentDate);
        System.out.println(birthDate);

        int mounth = currentDate.getMonthValue() - birthDate.getMonthValue();

        int year = mounth < 0 ? currentDate.getYear()- birthDate.getYear() -1 : currentDate.getYear()- birthDate.getYear();

        int month2 = mounth < 0 ? 12 + mounth : mounth;

        System.out.println(year + " years and " + month2 + " months");

        System.out.println(birthDate.getDayOfWeek());

        System.out.println(birthDate.withYear(currentDate.getYear()).getDayOfWeek());

        if (birthDate.withYear(currentDate.getYear()).isBefore(currentDate)) {
            System.out.println("День народження цього року вже був!!!");
        } else {
            System.out.println("День народження цього року ще не був!!!");
        }



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");

        Instant instant = Instant.now();

        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Paris"));
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Krasnoyarsk"));

        System.out.println(localDateTime1.format(formatter));
        System.out.println(localDateTime2.format(formatter));
        System.out.println(localDateTime3.format(formatter));

        //System.out.println(ZoneId.getAvailableZoneIds());

    }
}
