package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AdsBanners {
    @Step("Скрыть баннеры")
    public static void hideBanners() {
        executeJavaScript("document.querySelector('footer').remove();");
        executeJavaScript(
                "const banner = document.querySelector('#fixedban');"
        +
                "if (banner) {banner.remove}");
    }
}
