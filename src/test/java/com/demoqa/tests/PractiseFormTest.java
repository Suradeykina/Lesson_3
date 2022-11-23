package com.demoqa.tests;

import com.demoqa.helpers.Attach;
import com.demoqa.pages.PractiseFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PractiseFormTest extends TestData {
    PractiseFormPage practiseFormPage = new PractiseFormPage();

    @AfterEach
    void addAttachments(){
        //       Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//      //  Attach.addVideo();
    }

    @Test
    void practiceForm() {
        step("Open registration form", () -> {
            practiseFormPage.OpenForm();
        });

        step("Fill the form", () -> {
            practiseFormPage.setName(firstName, lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setMobilePhone(mobilePhone)
                    .setSubjects(subject)
                    .setHobbies()
                    .setCurrentAddress(currentAddress)
                    .uploadPicture(file)
                    .setState(state)
                    .setCity(city)
                    .setDate(day, month, year)
                    .clickSubmit();
        });

        step("Check results on the table", () -> {
            practiseFormPage.checkResults("Student Name", firstName)
                    .checkResults("Student Name", lastName)
                    .checkResults("Student Email", email)
                    .checkResults("Gender", gender)
                    .checkResults("Mobile", mobilePhone)
                    .checkResults("Date of Birth", day + " " + month + "," + year)
                    .checkResults("Subjects", subject)
                    .checkResults("Hobbies", hobbies)
                    .checkResults("Picture", file.getName())
                    .checkResults("Address", currentAddress)
                    .checkResults("State and City", state + " " + city);
        });
    }
}
