package com.demoqa.utils;

import java.time.LocalDate;
import java.util.Random;

public class RandomUtils {

    public static String getRandomArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}

