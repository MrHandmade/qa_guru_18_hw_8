package tests;

import core.BaseTest;
import data.Country;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AddressStorePage;
import pages.FixPriceMainPage;

import java.util.List;
import java.util.stream.Stream;



public class FixPriceTest extends BaseTest {

    FixPriceMainPage fixPriceMainPage = new FixPriceMainPage();
    AddressStorePage addressStorePage = new AddressStorePage();


    @ParameterizedTest(name = "При выборе города {0}, на странице адресов первым в списке отображается адрес {1}")
    @CsvSource(value = {
            "Москва | г.Москва, ш.Варшавское, д.33, стр.12",
            "Санкт-Петербург | г.Санкт-Петербург, пр-т Стачек, д.21, литера А ",
            "Екатеринбург | г.Екатеринбург, ул.Комсомольская, д.4",
            "Нижний Новгород | г.Нижний Новгород, ул.Аркадия Гайдара, д.24",
            "Пермь | г.Пермь, ул.Техническая, д.13 ",
            "Новосибирск |г.Новосибирск, пл.Карла Маркса, 5 ",
            "Казань | г.Казань, ул.Кул Гали, зд.15В",
            "Челябинск | г.Челябинск, ул.Тухачевского, д.16/д.16, стр.1 ",
            "Краснодар | г.Краснодар, ул.Дзержинского, д.115/1 ",
            "Самара | г.Самара, ул.Водников, д.28-30 "
    },
            delimiter = '|'
    )
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    public void checkAddressStoreInCity(String city, String expectedAddress) {
        fixPriceMainPage.clickGeo()
                .selectCity(city)
                .changeGeo()
                .clickAddressStore();

        addressStorePage.checkAddress(expectedAddress);

    }

    @ValueSource(strings = {
            "По номеру телефона", "По email"
    })
    @ParameterizedTest(name = "Вход по {0} на экране авторизации")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    public void checkTwoMethodsOfLogin(String methodLogin) {
        addressStorePage.clickLogIn();
        fixPriceMainPage.selectMethodLogIn(methodLogin)
                .closeLogInModal();

    }
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(Country.Россия, "г.Хабаровск, ул.Ленинградская, д.28/2"),
                Arguments.of(Country.Казахстан, "г.Лисаковск, мкрн.1, стр.19А")
        );


    }
    @MethodSource("dataProvider")
    @ParameterizedTest(name = "При выборе страны {0} на странице адресов отображается город {1}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    public void checkLocationStoreInCountry(Country country,String addressCity){
        fixPriceMainPage.clickAddressStore();
        addressStorePage.clickCountry()
                .chooseCountry(String.valueOf(country))
                .checkAddress(addressCity);
    }
}
