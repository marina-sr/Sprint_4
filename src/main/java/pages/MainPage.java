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

public class MainPage extends BasePage {
    private WebElement question;
    private WebElement answer;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE_URL);
    }

    public void clickOrderButtonToGoToOrderPage(By locator) {
        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();", element);

        element.click();
    }

    public void findQuestion(int serialNumber) {
        WebElement element = driver.findElement(By.cssSelector(
                QUESTION + serialNumber));

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();", element);

        question = element;
    }

    public void clickQuestionToGetAnswer(int serialNumber) {
        question.click();
        By locator = By.cssSelector(ANSWER_1 + serialNumber + ANSWER_2);
        WebElement element = driver.findElement(locator);

        new WebDriverWait(driver, Duration.ofSeconds(WAITING))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        answer = element;
    }

    public void shouldBeCorrectText(String expectedAnswer) {
        String actual = answer.getText();
        Assert.assertEquals("Текст ответа не соответствует ожидаемому.",
                expectedAnswer, actual);
    }
}
