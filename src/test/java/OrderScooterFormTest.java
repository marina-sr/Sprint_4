import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OrderPage;

@OrderWith(Alphanumeric.class)
public class OrderScooterFormTest {
    private static WebDriver driver;
    private static OrderPage objOrderPage;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        objOrderPage = new OrderPage(driver);
        objOrderPage.open();
    }

    @Test
    public void clickButtonNextCompletedForm1GoToForm2() {
        objOrderPage.inputDataToFieldsForm1();
        objOrderPage.isClickNextButtonGoToOrderForm2True();
    }

    @Test
    public void clickButtonOrderCompletedForm2ShowsConfirmWindow() {
        objOrderPage.selectDeliveryDate();
        objOrderPage.chooseRentalPeriod();
        objOrderPage.isClickOrderButtonGoToConfirmWindowTrue();
    }

    @Test
    public void clickButtonYesConfirmWindowShowsSuccessWindow() {
        objOrderPage.isClickYesConfirmWindowShowsSuccessWindowTrue();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
}
