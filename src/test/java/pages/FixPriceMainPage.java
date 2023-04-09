package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Components.AlertModal;
import pages.Components.LogInModal;
import pages.Components.SelectCityModal;

import static com.codeborne.selenide.Selenide.$x;

public class FixPriceMainPage {

    AlertModal alertModal = new AlertModal();
    SelectCityModal selectCityModal = new SelectCityModal();
    LogInModal logInModal = new LogInModal();
    public static SelenideElement GEO_BUTTON = $x("//span[@class='geo']"),
            ADDRESS_STORE_BUTTON = $x("//a[@href='/stores']");

    public FixPriceMainPage clickGeo() {
        GEO_BUTTON.click();
        return this;
    }

    public FixPriceMainPage selectCity(String testData) {
        selectCityModal.setCity(testData);
        return this;

    }

    public FixPriceMainPage changeGeo() {
        alertModal.changeGeo();
        return this;
    }

    public FixPriceMainPage clickAddressStore() {
        ADDRESS_STORE_BUTTON.click();
        return this;
    }

    public FixPriceMainPage selectMethodLogIn(String logInMethod) {
        logInModal.logInMethod(logInMethod);
        return this;
    }

    public FixPriceMainPage closeLogInModal() {
        logInModal.closeLoginModal();
        return this;
    }
}
