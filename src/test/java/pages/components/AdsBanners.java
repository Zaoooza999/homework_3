package pages.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AdsBanners {
    public static void hideBanners() {
        executeJavaScript("document.querySelector('footer').remove();");
        executeJavaScript("document.querySelector('#fixedban').remove();");
    }
}
