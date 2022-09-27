package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    public ResultsTableComponent checkResultsTable(String label, String value) {
        $(".table-responsive").$(byText(label))
                .parent().shouldHave(text(value));
        return this;
    }

}
