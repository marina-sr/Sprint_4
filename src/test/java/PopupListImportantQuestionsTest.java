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
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objMainPage.open();
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
        objMainPage.getAnswer(serialNumber);
        objMainPage.isAnswerTextCorrectTrue(serialNumber, expectedAnswer);
    }

    @AfterClass
    public static void tearDownClass() {
    driver.quit();
}
}
