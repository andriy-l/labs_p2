package com.brainacad.oop.testpredefannotation;

public class Main {

    @Deprecated
    static int findMax(int...elem) {

        int max = elem[0];

        for (int i = 1; i < elem.length ; i++) {
            max = elem[i] > max ? elem[i] : max;
        }
        return max;
    }

    @SafeVarargs
    static <T extends Comparable> T findMax(T...elem) {

        T max = elem[0];

        for (int i = 1; i < elem.length ; i++) {
            if(elem[i].compareTo(max) == 1) {
                max = elem[i];
            }
        }
        return max;
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Integer[] arrgGen = {5, 1, 3, 7, 5, 9, 6, 2, 5 ,7, 2};
        int[] arrg = {5, 1, 3, 7, 5, 9, 6, 2, 5 ,7, 2};
        System.out.println("int max: " +  findMax(arrg));
        System.out.println("Generic max: " + findMax(arrgGen));

    }
}
