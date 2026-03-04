package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    private final SelenideElement monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");
    String daysOfCurrentMonth = ".react-datepicker__day--0";
    String ignoringDaysOutOfCurrentMonth = ":not(.react-datepicker__day--outside-month)";

    public void setDate(String day, String month, String year) {
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(daysOfCurrentMonth+day+ignoringDaysOutOfCurrentMonth).click();
    }
}