package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.MainPageConstants.*;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public void goToOrderPage(By locator) {
        open();
        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();", element);

        element.click();
    }

    public WebElement getQuestion(int serialNumber) {
        WebElement element = driver.findElement(By.cssSelector(
                QUESTION + serialNumber));

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();", element);

        return element;
    }

    public String getAnswer(int serialNumber) {
        WebElement questionElement = getQuestion(serialNumber);
        questionElement.click();
        By locator = By.cssSelector(ANSWER_1 + serialNumber + ANSWER_2);
        WebElement element = driver.findElement(locator);

        new WebDriverWait(driver, Duration.ofSeconds(WAITING))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        return element.getText();
    }

    public void isAnswerTextCorrectTrue(int serialNumber, String expectedAnswer) {
        String actual = getAnswer(serialNumber);
        Assert.assertEquals("Текст ответа не соответствует ожидаемому.",
                expectedAnswer, actual);
    }
}
