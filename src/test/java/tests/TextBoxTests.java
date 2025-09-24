package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setFullName("Alex")
                .setEmail("alex@egorov.com")
                .setCurentAddres("Some street 1")
                .setPermanentAddres("Another street 1")
                .clickSubmit()
                .checkResult("Name:","Alex")
                .checkResult("Email:","alex@egorov.com")
                .checkResult("Current Address :","Some street 1")
                .checkResult("Permananet Address :","Another street 1");
    }
}
