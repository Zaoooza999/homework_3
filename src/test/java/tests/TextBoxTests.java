package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.Downloads;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
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
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@ivan.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1995");
        $(byText("28")).shouldBe(visible).click(); //насколько знаю про эту команду ничего не говорили, - нет ли способа лучше не через текст, и про shouldbe(visible) мы по моему не проходили, я сомневаюсь, что я сделал это правильно
        $("#subjectsInput").setValue("a");
        $(byText("Arts")).click();
        $(".custom-control.custom-checkbox.custom-control-inline [for=hobbies-checkbox-1]").click();
        $(".custom-control.custom-checkbox.custom-control-inline [for=hobbies-checkbox-2]").click();
        $("#uploadPicture").sendKeys("C:/Users/Max/Downloads/Telegram Desktop/image_2025-03-12_22-11-45.png");
        $("#currentAddress").setValue("California");
        $(".col-md-4.col-sm-12").click();//Не понимаю работу выпадающих списков, почти никогда не могу нажать на нижнеуровневый элемент почти всегда только верхний уровень
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                text("Ivan Ivanov"),
                text("Ivan@ivan.com"),
                text("Male"),
                text("1234567890"),
                text("28 January,1995"),
                text("Arts"),
                text("Sports, Reading"),
                text("image_2025-03-12_22-11-45.png"),
                text("California"),
                text("Haryana Panipat"),
                text("Ivan Ivanov"));
    }
    }