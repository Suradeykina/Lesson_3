package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PractiseFormTest {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    String subject = faker.name().title();
    String currentAddress = faker.address().fullAddress();
    File file = new File("src/test/resources/autumn-2789234.jpg");

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void checkName(){
        open("/automation-practice-form");

        //filed "Name"
      $("#userName-label").shouldHave(text("Name"));
        //$("#firstName").shouldHave(attribute(String.valueOf($("[placeholder=First Name]")), "First Name"));
        //$("#lastName").shouldHave(attribute("[placeholder=Last Name]", "Last Name"));
        $("#firstName").setValue(firstName);
        $("#firstName").setValue(lastName);

        //field "Email"
        $("#userEmail-label").shouldHave(text("Email"));
        $("#userEmail").setValue(email);

        //field "Gender"
        $x("//*[@id=\"genterWrapper\"]/div[1]").shouldHave(text("Gender"));
        $("#gender-radio-1").click();

        //field "Mobile phone"
        $("#userNumber-label").shouldHave(text("Mobile(10 Digits)"));
        $("#userNumber").setValue(mobilePhone);

        //field "Date of Birth"
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day react-datepicker__day--020").click();

        //field "Subjects"
        $("#subjectsWrapper").shouldHave(text("Subject"));
        $("#subjectsInput").setValue(subject);

        //field "Hobbies"
        $("#hobbiesWrapper").shouldHave(text("Hobbies"));
        $("#hobbies-checkbox-3").click();


        //field "Picture"
        $("#uploadPicture").uploadFile(file);

        //field "Current Address"
        $("#currentAddress-label").shouldHave(text("Current Address"));
        $("#currentAddress").setValue(currentAddress);

        //field "State and Sity"
        $("#stateCity-label").shouldHave(text("State and City"));
        $("#react-select-3-input").click();
        $("#react-select-3-input").selectOption("NCR");


        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text("Music"));

    }
}
