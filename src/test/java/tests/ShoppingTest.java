package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.InventoryPage;


import java.util.concurrent.TimeUnit;

public class ShoppingTest extends BaseTest{

    @Test
    public void addAndRemoveItemToShoppingCart() {
        driver = openChromeDriver();

        try {

           InventoryPage inventoryPage = logIntoInventoryPage();

            assert !inventoryPage.isCartNumberBadgePresent() : "Cart Icon Badge should be empty, but it is NOT";

            inventoryPage.clickfindItemAndAddToCart();

            String actualTitle = driver.findElement(By.xpath("//div[@class='product-item-category text-left']/a[@title='CENTRAL PARK ']")).getText();
            assert "LJUBAVNI ROMAN ".contains(actualTitle) : "Error. Expected title to be: " + "LJUBAVNI ROMAN " + ".Actual: " + actualTitle;


            inventoryPage.clickRemoveItemFromCart();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            String messageTitle = driver.findElement(By.xpath("//div[@class='empty-cart-alert-wrapper']/div[@class='alert alert-danger']")).getText();
            assert "  Vaša korpa je prazna! ".contains(messageTitle) : "Error. Expected title to be: " + "  Vaša korpa je prazna! " + ".Actual: " + messageTitle;


        }finally {
            driver.quit();

        }
    }
}
