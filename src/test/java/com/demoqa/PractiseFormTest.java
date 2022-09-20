package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PractiseFormTest {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String gender = "Male";
    String email = faker.internet().emailAddress();
    String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    String subject = "Computer Science";
    String currentAddress = faker.address().fullAddress();
    File file = new File("src/test/resources/autumn-2789234.jpg");
    String month = "May";
    String year = "1996";
    String state = "NCR";
    String city = "Noida";


    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "390x844";
    }

    @Test
    void practiceForm(){
        open("/automation-practice-form");

        //filed "Name"
        $("#userName-label").shouldHave(text("Name"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //field "Email"
        $("#userEmail-label").shouldHave(text("Email"));
        $("#userEmail").setValue(email);

        //field "Gender"
        $x("//*[@id='genterWrapper']/div[1]").shouldHave(text("Gender"));
        $("#genterWrapper").$(byText(gender)).click();

        //field "Mobile phone"
        $("#userNumber-label").shouldHave(text("Mobile(10 Digits)"));
        $("#userNumber").setValue(mobilePhone);

        //field "Date of Birth"
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[class*='react-datepicker__day--020']").click();

        //field "Subjects"
        $("#subjectsWrapper").shouldHave(text("Subject"));
        $("#subjectsInput").setValue(subject).pressEnter();

        //field "Hobbies"
        $("#hobbiesWrapper").shouldHave(text("Hobbies"));
        $("#hobbies-checkbox-3").parent().click();

        //field "Picture"
        $("#uploadPicture").uploadFile(file);

        //field "Current Address"
        $("#currentAddress-label").shouldHave(text("Current Address"));
        $("#currentAddress").setValue(currentAddress);

        //field "State and Sity"
        $("#stateCity-label").shouldHave(text("State and City"));
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        //button "submit"
        $("#submit").shouldBe(visible).click();

        // check results on the table
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(mobilePhone));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("20 " + month + "," + year));
        $(".table-responsive").shouldHave(text("autumn-2789234.jpg"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state + " " + city));
    }
}
