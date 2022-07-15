import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;

import static locators.MainPageLocators.ORDER_BUTTON_IN_BLOCK;
import static locators.MainPageLocators.ORDER_BUTTON_NAV;

@RunWith(value = Parameterized.class)
public class GoFromMainPageToOrderPageTest {
    private static WebDriver driver;
    private static MainPage objMainPage;
    private static OrderPage objOrderPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objOrderPage = new OrderPage(driver);
        objMainPage.open();
    }

    @Parameter
    public By locator;

    @Parameters
    public static Object[] data() {
        return new Object[] { ORDER_BUTTON_NAV, ORDER_BUTTON_IN_BLOCK };
    }

    @Test
    public void clickOrderButtonGoToOrderPageTrue() {
        objMainPage.goToOrderPage(locator);
        objOrderPage.isOrderPageTrue();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
