package com.fungaimutezo;

public final class UIDGenerator {
    private static int counter = 0;

    private UIDGenerator() {}

    public static int generateUID() {
        return counter++;
    }
}
