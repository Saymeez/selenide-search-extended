package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsForStudentRegistrationForm {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
        open("/automation-practice-form");
    }



    @Test
    void firstNameField(){
        $("#firstName").setValue("Ivan");
    }

    @Test
    void lastNameField(){
        $("#lastName").setValue("Ivanov");
    }

    @Test
    void userEmailField() {
        $("#userEmail").setValue("Ivan.Ivanov@gmail.com");
    }

    @Test
    void chooseGender(){
        $(byText("Male")).click();
    }

    @Test
    void userNumberField(){
        $("#userNumber").setValue("8900000000");
    }

    @Test
    void chooseDateOfBirth(){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("October")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2010")).click();
        $(".react-datepicker__day react-datepicker__day--019");
        $(byText("19")).click();

        $("#userEmail").setValue("Ivan.Ivanov@gmail.com");
    }


}
