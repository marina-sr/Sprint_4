package pages;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.OrderPageConstants.*;
import static locators.OrderPageLocators.*;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void openOrderPage()  {
        driver.get(ORDER_PAGE_URL);
    }

    public void inputDataToFieldsForm1() {
        int dataLen = DATA.length;
        for (int i = 0; i < dataLen; i++) {
            int fieldIndex = i + 1;
            if (i != METRO_FIELD_INDEX) {
                WebElement element = driver.findElement(By.xpath(
                        FORM1_FIELD_PART1 + (fieldIndex) + FORM1_FIELD_PART2));
                element.sendKeys(DATA[i]);
            }
            else {
                WebElement element = driver.findElement(By.xpath(
                        FORM1_FIELD_PART1 + (fieldIndex) + FORM1_FIELD_PART3));
                element.sendKeys(
                        DATA[i] + Keys.ARROW_DOWN + Keys.ENTER);
            }
        }
    }

    public void clickNextButtonToGoToOrderForm2() {
        driver.findElement(GO_TO_FORM2_BUTTON).click();
        Assert.assertEquals(FORM2_HEADER,
                driver.findElement(ORDER_FORM_HEADER).getText());
    }

    public void selectDeliveryDate() {
        driver.findElement(DELIVERY_DATE_FIELD).click();
        WebElement element = driver.findElement(DELIVERY_DATE);
        element.click();
    };

    public void chooseRentalPeriod() {
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        WebElement elementDeliveryDate = driver.findElement(RENTAL_PERIOD);
        elementDeliveryDate.click();
    };

    public void clickOrderButtonToGoToConfirmWindow() {
        WebElement element = driver.findElement(ORDER_BUTTON);
        element.click();
        Assert.assertEquals(CONFIRM_QUESTION,
                driver.findElement(CONFIRM_HEADER).getText());
    }

    public void clickYesToConfirmOrder() {
        WebElement element = driver.findElement(YES_BUTTON);
        element.click();
    }

    public void shouldBeSuccessWindow() {
        String actual = driver.findElement(SUCCESS_HEADER).getText();
        MatcherAssert.assertThat(actual, CoreMatchers.containsString(SUCCESS_HEADER_TEXT));

    }
    public void shouldBeOrderPage() {
        Assert.assertEquals(FORM1_HEADER,
                driver.findElement(ORDER_FORM_HEADER).getText());
    }
}
