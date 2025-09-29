package pages.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AdsBanners {
    public static void hideBanners() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
    }
}
