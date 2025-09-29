package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxPage {

    private static final SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddresInput = $("#currentAddress"),
            permanentAdressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultTextbox = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage setFullName(String value){
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurentAddres(String value){
        currentAddresInput.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddres(String value){
        permanentAdressInput.setValue(value);
        return this;
    }
    public TextBoxPage clickSubmit(){
        submitButton.click();
        return this;
    }
    public TextBoxPage checkResult(String key, String value){
        resultTextbox.$(byText(key)).shouldHave(text(value));
        return this;
    }
}