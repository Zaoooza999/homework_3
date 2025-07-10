package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpath() {
        // Информация об элементе (При наличии рекомендуется обращаться к неизменному атрибуту например data-testid
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid=email">
        $("[data-testid=email]").setValue("1");//1 способ обращения через Css
        $(by("data-testid", "email")).setValue("1");//2 способ обращения через Css
        $x("//*[@data-testid='email']").setValue("1");// Способ обращения через Xpath

        //Когда нет data-testid обращаемся к id
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email"
        $("[id=email]").setValue("1");//1 способ обращения через Css
        $(by("id", "email")).setValue("1");//2 способ обращения через Css
        $(byId("email")).setValue("1");//3 способ обращения через Css
        $("#email").setValue("1");//Лучший способ обращения через Css
        $x("//*[@id='email']").setValue("1");// Способ обращения через Xpath

        //Когда нет id обращаемся к name
        // <input type="email" class="inputtext login_form_input_box" name="email"
        $("[name=email]").setValue("1");//1 способ обращения через Css
        $(by("name", "email")).setValue("1");//2 способ обращения через Css
        $(byName("email")).setValue("1");//Возможно лучший способ обращения через Css
        $x("//*[@name='email']").setValue("1");// Способ обращения через Xpath

        //Когда нет name обращаемся к class
        // <input type="email" class="inputtext login_form_input_box"
        $("[class=inputtext][class=login_form_input_box]").setValue("1");//1 способ обращения через Css
        $("[.login_form_input_box]").setValue("1");//лучший способ обращения через Css
        $("[.inputtext.login_form_input_box]").setValue("1");//2 способ обращения через Css
        $x("//[input@class='inputtext'][@class='login_form_input_box']").setValue("1");// способ обращения через Xpath

        //В случае использования двух элементов, между ними добавляется пробел
        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $("[.inputtext .login_form_input_box]").setValue("1");

        //Обращение к объекту содержащему текст
        // <div>Hello, qa.guru!</div>
        $(byText("Hello, qa.guru!"));// По тексту
        $(withText("llo, qa.g"));// По наличию текста
        $x("//*[text()='Hello, qa.guru!']");//считается неправильным вариантом
        $x("//*[contains(text(),'Hello, qa.guru!')]");//считается правильным вариантом


    }
}
