package pages.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AdsBanners {
    public static void hideBanners() {
        executeJavaScript("document.querySelector('footer').remove();");
        executeJavaScript(
                "const banner = document.querySelector('#fixedban');"
        +
                "if (banner) {banner.remove}");
    }
}
