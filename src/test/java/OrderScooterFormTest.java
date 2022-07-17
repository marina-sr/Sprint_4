import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OrderPage;

@OrderWith(Alphanumeric.class)
public class OrderScooterFormTest {
    private static WebDriver driver;
    private static OrderPage objOrderPage;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        objOrderPage = new OrderPage(driver);
        objOrderPage.openOrderPage();
        objOrderPage.acceptCookies();
    }

    @Test
    public void orderScooterWithCorrectDataGetOrderConfirmation(){
        objOrderPage.inputDataToFieldsForm1();
        objOrderPage.clickNextButtonToGoToOrderForm2();
        objOrderPage.selectDeliveryDate();
        objOrderPage.chooseRentalPeriod();
        objOrderPage.clickOrderButtonToGoToConfirmWindow();
        objOrderPage.clickYesToConfirmOrder();
        objOrderPage.shouldBeSuccessWindow();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
}
