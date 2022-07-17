import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import pages.OrderPage;

import static locators.MainPageLocators.ORDER_BUTTON_IN_BLOCK;
import static locators.MainPageLocators.ORDER_BUTTON_NAV;

@RunWith(value = Parameterized.class)
public class GoFromMainPageToOrderPageTest {
    private static WebDriver driver;
    private static MainPage objMainPage;
    private static OrderPage objOrderPage;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        objMainPage = new MainPage(driver);
        objOrderPage = new OrderPage(driver);
    }

    @Before
    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }

    @Parameter
    public By locator;

    @Parameters
    public static Object[] data() {
        return new Object[] { ORDER_BUTTON_NAV, ORDER_BUTTON_IN_BLOCK };
    }

    @Test
    public void clickOrderButtonToGoToOrderPage() {
        objMainPage.openMainPage();
        objMainPage.acceptCookies();
        objMainPage.clickOrderButtonToGoToOrderPage(locator);
        objOrderPage.shouldBeOrderPage();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
