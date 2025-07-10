package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivanov");
        $("#lastName").setValue("Ivan");
        $("#userEmail").setValue("Ivan@ivan.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1995");
        $(byText("28")).shouldBe(visible).click();
        $("#subjectsInput").setValue("a");
        Thread.sleep(5000);
        //$$(".subjects-auto-complete__menu .subjects-auto-complete__option")
                //.first()
                //.shouldBe(visible);


        // Ожидание появления списка
        $$(".subjects-auto-complete__menu .subjects-auto-complete__option")
                .first()
                .shouldBe(visible);

        // Выбор значения из списка
        $$("div[class*='subjects-auto-complete__option']").find(text("Maths")).click();





        $("#currentAddress").setValue("Street");
        $("#submit").click();

        $("[id=b_content]").shouldHave(text("https://selenideorg"));
    }
}