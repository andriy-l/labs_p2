package com.brainacad.oop.teststreams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        int x = 10;
        List<Integer> integerList = Stream.iterate(x, y -> y + 10).limit(10).map(z -> z/2).collect(Collectors.toList());

        integerList.forEach(System.out::println);


        String[] strings = {"one", "two", "three", "four", "five", "six", "seven", "eighth", "nine", "ten"};

        Stream<String> stringStream = Stream.of(strings).filter(s -> s.startsWith("t")).sorted((r, y) -> r.compareToIgnoreCase(y));
        stringStream.forEach(System.out::println);


        Person[] persons = {new Person("Pavlo", 34, true),
                            new Person("Mykola", 23, true),
                            new Person("Matyana", 19, false),
                            new Person("Orest", 26, true),
                            new Person("Natalia", 37, false),
                            new Person("Oksana", 45, false),
                            new Person("Vasyl", 21, true),
                            new Person("Petro", 48, true)};
        List<Person> people = Arrays.asList(persons);

        Stream<Person> personStream = Stream.of(persons).filter(person -> person.isGender()).
                filter(person -> person.getAge() > 18 && person.getAge() < 27);

        personStream.forEach(System.out::println);

        double avgAgeWoman = Stream.of(persons).filter(person -> !person.isGender()).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("Середній вік жінок: " + avgAgeWoman);
    }
}
