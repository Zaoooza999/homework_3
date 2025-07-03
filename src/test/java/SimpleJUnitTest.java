import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    @Test
    void successfulSearchTest() {
        open("https://www.bing.com/");
        $("[name=q").setValue("selenide").pressEnter();
        $("[id=b_content]").shouldHave(text("https://selenideorg"));
    }
    
}
