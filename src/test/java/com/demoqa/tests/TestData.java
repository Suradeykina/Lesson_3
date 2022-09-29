package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.io.File;

public class TestData {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String gender = "Male";
    String email = faker.internet().emailAddress();
    String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    String subject = "Computer Science";
    String hobbies = "Music";
    String currentAddress = faker.address().fullAddress();
    File file = new File("src/test/resources/autumn-2789234.jpg");
    String day = "20";
    String month = "May";
    String year = "1996";
    String state = "NCR";
    String city = "Noida";
}
