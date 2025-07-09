package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {System.out.println("\n### beforeAll()\n");}

    @Test
    void successfulSearchTest() {
        open("https://www.bing.com/");
        $("[name=q").setValue("selenide").pressEnter();
        $("[id=b_content]").shouldHave(text("https://selenideorg"));

    }
    
}
