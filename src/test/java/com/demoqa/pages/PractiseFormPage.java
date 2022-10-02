package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;
import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PractiseFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    nameLabel = $("#userName-label"),
    emailLabel = $("#userEmail-label"),
    emailInput = $("#userEmail"),
    genderLabel = $x("//*[@id='genterWrapper']/div[1]"),
    genderRadiobutton = $("#genterWrapper"),
    mobilePhoneLabel = $("#userNumber-label"),
    mobilePhoneInput = $("#userNumber"),
    subjectLabel = $("#subjectsWrapper"),
    subjectInput = $("#subjectsInput"),
    hobbiesLabel = $("#hobbiesWrapper"),
    hobbiesCheckbox = $("#hobbiesWrapper"),
    currentAddressLabel = $("#currentAddress-label"),
    currentAddressInput = $("#currentAddress"),
    stateCityLabel = $("#stateCity-label"),
    stateList = $("#react-select-3-input"),
    cityList = $("#react-select-4-input"),
    uploadForm = $("#uploadPicture"),
    birthDateInput = $("#dateOfBirthInput"),
    submitButton = $("#submit");

    public PractiseFormPage openForm() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PractiseFormPage setName(String firstName, String lastName) {
        nameLabel.shouldHave(text("Name"));
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }

    public PractiseFormPage setEmail(String value) {
        emailLabel.shouldHave(text("Email"));
        emailInput.setValue(value);
        return this;
    }

    public PractiseFormPage setGender(String value) {
        genderLabel.shouldHave(text("Gender"));
        genderRadiobutton.$(byText(value)).click();
        return this;
    }

    public PractiseFormPage setMobilePhone(String value) {
        mobilePhoneLabel.shouldHave(text("Mobile(10 Digits)"));
        mobilePhoneInput.setValue(value);
        return this;
    }

    public PractiseFormPage setSubjects(String value) {
       subjectLabel.shouldHave(text("Subject"));
       subjectInput.setValue(value).pressEnter();
        return this;
    }

    public PractiseFormPage setHobbies(String value) {
        hobbiesLabel.shouldHave(text("Hobbies"));
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public PractiseFormPage setCurrentAddress(String value) {
        currentAddressLabel.shouldHave(text("Current Address"));
        currentAddressInput.setValue(value);
        return this;
    }

    public PractiseFormPage uploadPicture(File file) {
        uploadForm.uploadFile(file);
        return this;
    }

    public PractiseFormPage setState(String value) {
        stateCityLabel.shouldHave(text("State and City"));
        stateList.setValue(value).pressEnter();
        return this;
    }

    public PractiseFormPage setCity(String value) {
        stateCityLabel.shouldHave(text("State and City"));
        cityList.setValue(value).pressEnter();
        return this;
    }

    public PractiseFormPage setDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PractiseFormPage clickSubmit (){
        submitButton.shouldBe(visible).click();
        return this;
    }

    public PractiseFormPage checkResults(String label, String value){
        resultsTableComponent.checkResultsTable(label, value);
        return this;
    }


}
