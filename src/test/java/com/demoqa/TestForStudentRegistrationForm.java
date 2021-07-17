package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForStudentRegistrationForm {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void fillStudentRegistrationForm() {
        open("/automation-practice-form");


        $("#firstName").setValue("Ivan");

        $("#lastName").setValue("Ivanov");

        $("#userEmail").setValue("Ivan.Ivanov@gmail.com");

        $("[name=gender][value=Male]").parent().click();

        $("#userNumber").setValue("8900000000");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2010");
        $(".react-datepicker__day react-datepicker__day--019");
        $(byText("19")).click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("./img/screenshot.png");

        $("#currentAddress").setValue("Lenina 51");

        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();

        $("#state").scrollTo().click();


        $x("//td[text()='Student Name']").parent().shouldHave(text("Ivan"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("Ivan.Ivanov@gmail.com"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("8900000000"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("19 October,2010"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Math"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text("screenshot.png"));
        $x("//td[text()='Address']").parent().shouldHave(text("Lenina 51"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Haryana Panipat"));
    }
}
