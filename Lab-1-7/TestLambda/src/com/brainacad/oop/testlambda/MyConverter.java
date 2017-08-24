package com.brainacad.oop.testlambda;

@FunctionalInterface
public interface MyConverter {
    public String convertStr(String str);

    static boolean isNull(String str) {
        return str == null;
    }
}
