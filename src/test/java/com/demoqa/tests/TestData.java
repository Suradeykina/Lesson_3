package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;

import java.io.File;

public class TestData {
    static Faker faker = new Faker();
    static File file = new File("src/test/resources/autumn-2789234.jpg");
    static String[] genderArray = new String[]{"Male", "Other", "Female"};
    static String[] subjectArray = new String[]{"Hindi", "English", "Physics", "Chemistry", "Biology", "Computer Science",
            "Accounting", "Economics", "Social Studies", "History", "Civics", "Art", "Math"};
    static String[] hobbiesArray = new String[]{"Sports", "Reading", "Music"};
    static String[] stateArray = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    static String[] monthArray = new String[]{"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"};
    static String[] cityArray = new String[0];

    static String[] randomCity(String value) {
        if (value.equals(stateArray[0])) {
            cityArray = new String[]{"Delhi", "Gurgaon", "Noida"};
        } else if (value.equals(stateArray[1])) {
            cityArray = new String[]{"Agra", "Lucknow", "Merrut"};
        } else if (value.equals(stateArray[2])) {
            cityArray = new String[]{"Karnal", "Panipat"};
        } else if (value.equals(stateArray[3])) {
            cityArray = new String[]{"Jaipur", "Jaiselmer"};
        }
        return cityArray;
    }

    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            gender = RandomUtils.getRandomArray(genderArray),
            email = faker.internet().emailAddress(),
            mobilePhone = faker.phoneNumber().subscriberNumber(10),
            subject = RandomUtils.getRandomArray(subjectArray),
            hobbies = RandomUtils.getRandomArray(hobbiesArray),
            currentAddress = faker.address().fullAddress(),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            month = RandomUtils.getRandomArray(monthArray),
            year = String.valueOf(faker.number().numberBetween(1910, 2015)),
            state = RandomUtils.getRandomArray(stateArray),
            city = RandomUtils.getRandomArray(randomCity(state));
}
