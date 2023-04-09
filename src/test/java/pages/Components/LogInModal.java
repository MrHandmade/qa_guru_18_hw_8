package pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogInModal {

    public void logInMethod(String loginMethod) {
        $x("//button[text()=" + "'" + loginMethod + "'" + "]").click();

    }

    public void closeLoginModal() {
        $x("//i[@data-test='close']").click();
    }
}
