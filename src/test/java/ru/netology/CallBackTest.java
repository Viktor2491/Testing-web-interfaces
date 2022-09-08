package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CallBackTest {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearsDown() {
        driver.quit();
        driver = null;
    }
    @Test
    //отправка запроса
    public void shouldSubmitRequest() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79211234567");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    //Ваалидация поля Фамилия Имя
    public void shouldValidName1() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Ёжов Семён");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79211234567");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    //Ваалидация поля Фамилия Имя
    public void shouldValidName2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Римский-Корсаков Руслан");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79211234567");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    //Ваалидация поля Фамилия Имя
    public void shouldValidName3() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Ахмед ибн Хатаб");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79211234567");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=\"order-success\"]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName1() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Petrov Roman");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79876543210");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Роман");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79876543210");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName3() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("1551516");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79876543210");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    //невалидное Фамилия Имя
    public void shouldInvalidName4() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("@#%$*&&");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79876543210");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    //невалидный телефон
    public void shouldInvalidPhone1() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("89211234567");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }


    @Test
    //невалидный телефон
    public void shouldInvalidPhone2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+7921123456725");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }


    @Test
    //невалидный телефон
    public void shouldInvalidPhone3() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+7921123456");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }


    @Test
    //невалидный телефон
    public void shouldInvalidPhone4() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("Xiaomi");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }


    @Test
    //пустое поле
    public void shouldNotAcceptAnEmptyField1() {
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79211234567");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());
    }

    @Test
    //пустое поле
    public void shouldNotAcceptAnEmptyField2() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());
    }

    @Test
    //пустое поле
    public void shouldNotAcceptAnEmptyField3() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гагарин Юрий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79211234567");
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=agreement].input_invalid")).getText();
        assertEquals("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй", text.trim());
    }

}

