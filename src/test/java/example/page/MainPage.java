package example.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.data.DataGenerator;
import org.example.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static final SelenideElement buyWithDebitCardButton = $(byText("Купить"));
    private static final SelenideElement buyWithCreditCardButton = $(byText("Купить в кредит"));
    private static final SelenideElement continueButton = $(byText("Продолжить"));

    public void payWithDebitCard() {
        buyWithDebitCardButton.click();
    }

    public void payWithCreditCard() {
        buyWithCreditCardButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement inputCardNumber = $("[placeholder=\"0000 0000 0000 0000\"]");
    private final SelenideElement inputMonth = $("[placeholder=\"08\"]");
    private final SelenideElement inputYear = $("[placeholder=\"22\"]");
    private final SelenideElement inputOwner = fields.get(3);
    private final SelenideElement inputCVV = $("[placeholder=\"999\"]");
    private final SelenideElement errorNotification = $(".notification_status_error .icon_name_close");
    private final SelenideElement successNotification = $(".notification_status_ok");

    public void findSuccessNotification() {
        $(byText("Операция одобрена Банком.")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void findErrorNotification() {
        $(byText("Ошибка! Банк отказал в проведении операции.")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void findWrongFormat() {
        $(byText("Неверный формат")).shouldBe(Condition.visible);
    }

    public void findRequiredField() {
        $(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible);
    }

    public void findWrongDate() {
        $(byText("Неверно указан срок действия карты")).shouldBe(Condition.visible);
    }

    public void findOutdatedCard() {
        $(byText("Истёк срок действия карты")).shouldBe(Condition.visible);
    }

    public void findContinue() {
        $(byText("Продолжить")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void findBothNotifications() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
        errorNotification.click();
        successNotification.shouldNotBe(Condition.visible);
    }

    public void fillDateOwnerCVV() {
        inputMonth.setValue(DataGenerator.generateCurrentMonth());
        inputYear.setValue(DataGenerator.generateCurrentYear());
        inputOwner.setValue(DataGenerator.generateValidName());
        inputCVV.setValue(DataGenerator.generateCVC());
        clickContinueButton();
    }

    public void fillNumberYearOwnerCVV() {
        inputCardNumber.setValue(DataHelper.getCardNumber1());
        inputYear.setValue(DataGenerator.generateCurrentYear());
        inputOwner.setValue(DataGenerator.generateValidName());
        inputCVV.setValue(DataGenerator.generateCVC());
        clickContinueButton();
    }

    public void fillNumberMonthOwnerCVV() {
        inputCardNumber.setValue(DataHelper.getCardNumber1());
        inputMonth.setValue(DataGenerator.generateCurrentMonth());
        inputOwner.setValue(DataGenerator.generateValidName());
        inputCVV.setValue(DataGenerator.generateCVC());
        clickContinueButton();
    }

    public void fillNumberDateCVV() {
        inputCardNumber.setValue(DataHelper.getCardNumber1());
        inputMonth.setValue(DataGenerator.generateCurrentMonth());
        inputYear.setValue(DataGenerator.generateCurrentYear());
        inputCVV.setValue(DataGenerator.generateCVC());
        clickContinueButton();
    }

    public void fillNumberDateOwner() {
        inputCardNumber.setValue(DataHelper.getCardNumber1());
        inputMonth.setValue(DataGenerator.generateCurrentMonth());
        inputYear.setValue(DataGenerator.generateCurrentYear());
        inputOwner.setValue(DataGenerator.generateValidName());
        clickContinueButton();
    }

    public void fillNumberOwnerCVV() {
        inputCardNumber.setValue(DataHelper.getCardNumber1());
        inputOwner.setValue(DataGenerator.generateValidName());
        inputCVV.setValue(DataGenerator.generateCVC());
        clickContinueButton();
    }

    public void fillCardNumber1() {
        inputCardNumber.setValue(DataHelper.getCardNumber1());
    }

    public void fillCardNumber2() {
        inputCardNumber.setValue(DataHelper.getCardNumber2());
    }

    public void fillCardNumberRandomValid() {
        inputCardNumber.setValue(DataGenerator.generateCreditCard());
    }

    public void fillCardNumberShort() {
        inputCardNumber.setValue(DataGenerator.generateShortCardNumber());
    }

    public void fillCardNumberTextAndSymbol() {
        inputCardNumber.setValue(DataGenerator.generateRandomText());
    }

    public void fillMonthPrevious() {
        inputMonth.setValue(DataGenerator.generatePreviousMonth());
    }

    public void fillMonthGreaterThanTwelve() {
        inputMonth.setValue(DataGenerator.generateMonthNumberGreaterThanTwelve());
    }

    public void fillMonthZero() {
        inputMonth.setValue("00");
    }

    public void fillMonthTextAndSymbol() {
        inputMonth.setValue(DataGenerator.generateRandomText());
    }

    public void fillYearCurrent() {
        inputYear.setValue(DataGenerator.generateCurrentYear());
    }

    public void fillYearPrevious() {
        inputYear.setValue(DataGenerator.generatePreviousYear());
    }

    public void fillYearInvalidFuture() {
        inputYear.setValue(DataGenerator.generateInvalidYearFuture());
    }

    public void fillYearTextAndSymbol() {
        inputYear.setValue(DataGenerator.generateRandomText());
    }

    public void fillOwnerLastName() {
        inputOwner.setValue(DataGenerator.generateLastName());
    }

    public void fillOwnerCyrillic() {
        inputOwner.setValue(DataGenerator.generateCyrillicName("ru"));
    }

    public void fillOwnerUpperCase() {
        inputOwner.setValue(DataGenerator.generateToUpperCaseName());
    }

    public void fillOwnerLowerCase() {
        inputOwner.setValue(DataGenerator.generateToLowerCaseName());
    }

    public void fillOwnerTextAndSymbol() {
        inputOwner.setValue(DataGenerator.generateRandomText());
    }

    public void fillOwnerNumber() {
        inputOwner.setValue(DataGenerator.generateShortCardNumber());
    }

    public void fillCVVInvalid() {
        inputOwner.setValue(DataGenerator.generateInvalidCVC());
    }

    public void fillCVVTextAndSymbol() {
        inputOwner.setValue(DataGenerator.generateRandomText());
    }


}
