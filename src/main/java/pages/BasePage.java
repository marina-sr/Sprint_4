package pages;

import org.openqa.selenium.WebDriver;

import static locators.BasePageLocators.CONFIRM_BUTTON;

public abstract class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(CONFIRM_BUTTON).click();
    };

}
