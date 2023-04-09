package pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AlertModal {
    public static SelenideElement CHANGE_CITY = $x("//button[@data-test='save']");

    public void changeGeo() {
        CHANGE_CITY.click();

    }
}
