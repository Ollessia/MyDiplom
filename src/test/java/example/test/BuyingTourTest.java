package example.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.data.DataHelper;
import org.example.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BuyingTourTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void openPage() {
        DataHelper.openPage();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    MainPage mainPage = new MainPage();

    @Test
    void shouldDebitCardPayment1() {
        mainPage.payWithDebitCard();
        mainPage.fillCardNumber1();
        mainPage.fillDateOwnerCVV();
        mainPage.findSuccessNotification();
    }

    @Test
    void shouldDebitCardPayment2() {
        mainPage.payWithDebitCard();
        mainPage.fillCardNumber2();
        mainPage.fillDateOwnerCVV();
        mainPage.findErrorNotification();
    }

    @Test
    void shouldCreditCardPayment1() {
        mainPage.payWithCreditCard();
        mainPage.fillCardNumber1();
        mainPage.fillDateOwnerCVV();
        mainPage.findSuccessNotification();
    }

    @Test
    void shouldCreditCardPayment2() {
        mainPage.payWithCreditCard();
        mainPage.fillCardNumber2();
        mainPage.fillDateOwnerCVV();
        mainPage.findErrorNotification();
    }

    @Test
    void shouldCardNumberRandomValid() {
        mainPage.payWithDebitCard();
        mainPage.fillCardNumberRandomValid();
        mainPage.fillDateOwnerCVV();
        mainPage.findBothNotifications();
    }

    @Test
    void shouldCardNumberShort() {
        mainPage.payWithDebitCard();
        mainPage.fillCardNumberShort();
        mainPage.fillDateOwnerCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldCardNumberTextAndSymbol() {
        mainPage.payWithDebitCard();
        mainPage.fillCardNumberTextAndSymbol();
        mainPage.fillDateOwnerCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldCardNumberEmpty() {
        mainPage.payWithDebitCard();
        mainPage.fillDateOwnerCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldMonthEmpty() {
        mainPage.payWithDebitCard();
        mainPage.fillNumberYearOwnerCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldMonthGreaterThanTwelve() {
        mainPage.payWithDebitCard();
        mainPage.fillMonthGreaterThanTwelve();
        mainPage.fillNumberYearOwnerCVV();
        mainPage.findWrongDate();
    }

    @Test
    void shouldMonthZero() {
        mainPage.payWithDebitCard();
        mainPage.fillMonthZero();
        mainPage.fillNumberYearOwnerCVV();
        mainPage.findWrongDate();
    }

    @Test
    void shouldMontPreviousYearCurrent() {
        mainPage.payWithDebitCard();
        mainPage.fillMonthPrevious();
        mainPage.fillYearCurrent();
        mainPage.fillNumberOwnerCVV();
        mainPage.findOutdatedCard();
    }

    @Test
    void shouldMonthTextAndSymbol() {
        mainPage.payWithDebitCard();
        mainPage.fillMonthTextAndSymbol();
        mainPage.fillNumberYearOwnerCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldYearPrevious() {
        mainPage.payWithDebitCard();
        mainPage.fillYearPrevious();
        mainPage.fillNumberMonthOwnerCVV();
        mainPage.findOutdatedCard();
    }

    @Test
    void shouldYearInvalidFuture() {
        mainPage.payWithDebitCard();
        mainPage.fillYearInvalidFuture();
        mainPage.fillNumberMonthOwnerCVV();
        mainPage.findWrongDate();
    }

    @Test
    void shouldYearEmpty() {
        mainPage.payWithDebitCard();
        mainPage.fillNumberMonthOwnerCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldYearTextAndSymbol() {
        mainPage.payWithDebitCard();
        mainPage.fillYearTextAndSymbol();
        mainPage.fillNumberMonthOwnerCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldOwnerEmpty() {
        mainPage.payWithDebitCard();
        mainPage.fillNumberDateCVV();
        mainPage.findRequiredField();
    }

    @Test
    void shouldOwnerCyrillic() {
        mainPage.payWithDebitCard();
        mainPage.fillOwnerCyrillic();
        mainPage.fillNumberDateCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldOwnerUpperCase() {
        mainPage.payWithDebitCard();
        mainPage.fillOwnerUpperCase();
        mainPage.fillNumberDateCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldOwnerLowerCase() {
        mainPage.payWithDebitCard();
        mainPage.fillOwnerLowerCase();
        mainPage.fillNumberDateCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldOwnerLastName() {
        mainPage.payWithDebitCard();
        mainPage.fillOwnerLastName();
        mainPage.fillNumberDateCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldOwnerDigits() {
        mainPage.payWithDebitCard();
        mainPage.fillOwnerNumber();
        mainPage.fillNumberDateCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldOwnerRandomTextAndSymbol() {
        mainPage.payWithDebitCard();
        mainPage.fillOwnerTextAndSymbol();
        mainPage.fillNumberDateCVV();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldCVVTwoDigits() {
        mainPage.payWithDebitCard();
        mainPage.fillCVVInvalid();
        mainPage.fillNumberDateOwner();
        mainPage.findWrongFormat();
    }

    @Test
    void shouldCVVTextAndSymbol() {
        mainPage.payWithDebitCard();
        mainPage.fillCVVTextAndSymbol();
        mainPage.fillNumberDateOwner();
        mainPage.findRequiredField();
    }

    @Test
    void shouldCVVEmpty() {
        mainPage.payWithDebitCard();
        mainPage.fillNumberDateOwner();
        mainPage.findRequiredField();
    }

}
