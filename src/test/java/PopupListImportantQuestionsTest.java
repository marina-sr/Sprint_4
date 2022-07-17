import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

import java.util.Arrays;
import java.util.Collection;

import static constants.MainPageQuestionsConstants.*;

@RunWith(value = Parameterized.class)
public class PopupListImportantQuestionsTest {
    private static WebDriver driver;
    private static MainPage objMainPage;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.acceptCookies();
    }

    @Parameter
    public int serialNumber;

    @Parameter(1)
    public String expectedAnswer;

    @Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {QUESTION1.ordinal(), QUESTION1.getAnswer()},
                {QUESTION2.ordinal(), QUESTION2.getAnswer()},
                {QUESTION3.ordinal(), QUESTION3.getAnswer()},
                {QUESTION4.ordinal(), QUESTION4.getAnswer()},
                {QUESTION5.ordinal(), QUESTION5.getAnswer()},
                {QUESTION6.ordinal(), QUESTION6.getAnswer()},
                {QUESTION7.ordinal(), QUESTION7.getAnswer()},
                {QUESTION8.ordinal(), QUESTION8.getAnswer()},

        });
    }

    @Test
    public void clickQuestionShowsRightAnswer() {
        objMainPage.findQuestion(serialNumber);
        objMainPage.clickQuestionToGetAnswer(serialNumber);
        objMainPage.shouldBeCorrectText(expectedAnswer);
    }

    @AfterClass
    public static void tearDownClass() {
    driver.quit();
}
}
