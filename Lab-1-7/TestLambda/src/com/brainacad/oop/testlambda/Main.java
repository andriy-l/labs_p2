package com.brainacad.oop.testlambda;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    static Integer sumEven(Integer[] argInt, Predicate<Integer> integerPredicate) {
        Integer res = 0;

        for (Integer i : argInt) {
            if (integerPredicate.test(i)) {
                res += i;
            }
        }
        return res;
    }

    static void printJStr(List<String> stringList, Predicate<String> stringPredicate) {


        for (String s : stringList) {
            //char firstChar = s.charAt(0);

            if (stringPredicate.test(s)) {
                System.out.println(s);
            }

        }

    }

    static void updateList(List<String> stringList, MyConverter myConverter) {

        //List<String> res = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            if (!MyConverter.isNull(stringList.get(i))) {
                stringList.set(i, myConverter.convertStr(stringList.get(i)));
            }
        }

        //return res;
    }

    public static void main(String[] args) {

        Integer[] integersArr = new Integer[15];

        Random random = new Random();

        for (int i = 0; i < integersArr.length ; i++) {
            integersArr[i] = random.nextInt(1000);
        }

        Arrays.sort(integersArr, (x, y) ->  x > y ? -1 : x == y ? 0 : 1);
        System.out.println(Arrays.toString(integersArr));


        List<String> strings = new ArrayList<>();
        strings.add("This");
        strings.add("list");
        strings.add("is");
        strings.add("sorted");
        strings.add("in");
        strings.add("reverse");
        strings.add("alphabetical");
        strings.add("order");

        System.out.println(strings);

        Collections.sort(strings, (x, y) -> y.compareToIgnoreCase(x));
        System.out.println(strings);

        System.out.println(sumEven(integersArr, x -> x >= 500));

        printJStr(strings, x -> x.charAt(0) == 'r' || x.charAt(0) == 'o' || x.charAt(0) =='i');

        updateList(strings, str -> str.toUpperCase());

        //System.out.println(updateList(strings, str -> str.toUpperCase()));
        System.out.println(strings);

    }
}
