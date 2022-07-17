package locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    // кнопка "Заказать" в шапке
    public static final By ORDER_BUTTON_NAV =
            By.xpath(".//div/div[1]/div[2]/button[1]");
    // кнопка "Заказать" в блоке 3 "Как это работает"
    public static final By ORDER_BUTTON_IN_BLOCK =
            By.xpath(".//div/div[4]/div[2]/div[5]/button");
}
