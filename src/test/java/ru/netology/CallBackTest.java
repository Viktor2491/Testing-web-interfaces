package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallBackTest {
    SelenideElement form = $(".form");

    @BeforeEach
    public void setup() {
        open("http://localhost:9999/");
    }

    @Test
    //отправка запроса
    public void shouldSubmitRequest() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    //Ваалидация поля Фамилия Имя
    public void shouldValidName1() {
        form.$("[data-test-id=name] input").setValue("Ёжов Семён");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    //Ваалидация поля Фамилия Имя
    public void shouldValidName2() {
        form.$("[data-test-id=name] input").setValue("Римский-Корсаков Руслан");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    //Ваалидация поля Фамилия Имя
    public void shouldValidName3() {
        form.$("[data-test-id=name] input").setValue("Ахмед ибн Хатаб");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName1() {
        form.$("[data-test-id=name] input").setValue("Petrov Roman");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName2() {
        form.$("[data-test-id=name] input").setValue("Роман");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName3() {
        form.$("[data-test-id=name] input").setValue("1551516");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName4() {
        form.$("[data-test-id=name] input").setValue("@#%$*&&");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    //невалидный телефон
    public void shouldInvalidPhone1() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("89211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }


    @Test
    //невалидный телефон
    public void shouldInvalidPhone2() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+7921123456725");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }


    @Test
    //невалидный телефон
    public void shouldInvalidPhone3() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+7921123456");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }


    @Test
    //невалидный телефон
    public void shouldInvalidPhone4() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("Xiaomi");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }


    @Test
    //пустое поле
    public void shouldNotAcceptAnEmptyField1() {
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    //пустое поле
    public void shouldNotAcceptAnEmptyField2() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        form.$("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    //пустое поле
    public void shouldNotAcceptAnEmptyField3() {
        form.$("[data-test-id=name] input").setValue("Гагарин Юрий");
        form.$("[data-test-id=phone] input").setValue("+79211234567");
        form.$("button.button").click();
        form.$("[data-test-id=agreement]").should(cssClass("input_invalid"));
    }
}
