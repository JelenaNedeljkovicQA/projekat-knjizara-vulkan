package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    WebDriver driver = null;

    @FindBy(className = "item item-logout")
    WebElement logoutLink;

    @FindBy(xpath = "//div[@class = 'block mini-cart mini-cart-simple']/a[@title = 'Kora']")
    WebElement shoppingCartIcon;

    @FindBy(className = "header-carthor-total")
    WebElement shoppingCartNumberBadge;



//metode



    public BasePage clickLogoutLink () {
        print("clickLogoutLink");
        logoutLink.click();
        return new LoginPage(driver);

    }

    public void print(String text) {
        System.out.println(text);

    }



    public boolean isElementPresent(WebElement element) {
        print("isCartNumberBadgePresent");
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        } catch (Exception e) {
            print(e.getMessage());
            print("Element is not present on page");
            return  false;
        }
    }

    public boolean isCartNumberBadgePresent() {
        print("isCartNumberBadgePresent");
        try {
            boolean isPresent = shoppingCartNumberBadge.isDisplayed();
            return true;
        } catch (Exception e) {
            print(e.getMessage());
            return  false;
        }

    }

    public String getNumberOfItemsInCartFromBadge() {
        print("getNumberOfItemsInCartFromBadge");
        return shoppingCartNumberBadge.getText();
    }

    public ShoppingCartPage clickShoppingCartIcon() {
        shoppingCartIcon.click();
        return new ShoppingCartPage(driver);
    }



   }
