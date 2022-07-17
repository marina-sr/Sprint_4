package locators;

import org.openqa.selenium.By;

public class OrderPageLocators {
    // надпись "Для кого самокат"
    public static final By ORDER_FORM_HEADER = By.cssSelector(".Order_Header__BZXOb");
    // кнопка "Далее"
    public static final By GO_TO_FORM2_BUTTON = By.xpath(".//div/div[2]/div[3]/button");
    // поле "Когда привезти самокат"
    public static final By DELIVERY_DATE_FIELD =
            By.xpath(".//div/div[2]/div[2]/div[1]/div[1]/div/input");
    // значение в календаре
    public static final By DELIVERY_DATE = By.cssSelector(".react-datepicker__day--016");
    // поле "Срок аренды"
    public static final By RENTAL_PERIOD_FIELD = By.cssSelector(".Dropdown-placeholder");
    // значение из списка
    public static final By RENTAL_PERIOD = By.cssSelector("div.Dropdown-option:nth-child(3)");
    // кнопка "Заказать"
    public static final By ORDER_BUTTON =
            By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");
    // надпись "Хотите оформить заказ"
    public static final By CONFIRM_HEADER = By.cssSelector(".Order_ModalHeader__3FDaJ");
    // кнопка "Да"
    public static final By YES_BUTTON =
            By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");
    // надпись "Хотите оформить заказ"
    public static final By SUCCESS_HEADER = By.cssSelector(".Order_ModalHeader__3FDaJ");
}
