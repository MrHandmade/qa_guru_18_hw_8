package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayDeque;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddressStorePage {
    public static SelenideElement ADDRESS_STORE = $x("//div[@data-test='column']"),
            LOG_IN_BUTTON = $x("//button[contains(@class,'log-in')]"),
            COUNTRY_BUTTON = $x("//div[@class='input-container']");


    public AddressStorePage checkAddress(String address) {
        ADDRESS_STORE.shouldHave(Condition.text(address));
        return this;
    }

    public AddressStorePage clickLogIn() {
        LOG_IN_BUTTON.click();
        return this;
    }

    public AddressStorePage clickCountry(){
        COUNTRY_BUTTON.click();
        return this;
    }

    public AddressStorePage chooseCountry(String country){
        $x("//li[text()=" + "'" + country + "'" +"]").click();
        return this;
    }
}
