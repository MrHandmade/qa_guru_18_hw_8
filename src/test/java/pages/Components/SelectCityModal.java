package pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SelectCityModal {

    public void setCity(String testData) {

        $x("//div[text()=" + "'" + testData + "'" + "]").click();
    }


}
