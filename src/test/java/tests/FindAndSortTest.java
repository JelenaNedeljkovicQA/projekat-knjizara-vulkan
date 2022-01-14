package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.InventoryPage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

public class FindAndSortTest extends BaseTest{


    @Test
    public void findAndSortItem () {

        driver = openChromeDriver();

        try {
            InventoryPage inventoryPage = logIntoInventoryPage();

            assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;

            inventoryPage.clickFindItems();

            assert CurrentURLEqualTo(Strings.URL_SORT_FOR_KIDS) : "Expected url:" + Strings.URL_SORT_FOR_KIDS;

            inventoryPage.clickToSortCheckboxItem();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            String actualTitle = driver.findElement(By.xpath("//div[@class='title']/a[@title='ROBIN HUD ']")).getText();
            assert " ROBIN HUD ".contains(actualTitle) : "Error. Expected title to be: " + " ROBIN HUD " + ".Actual: " + actualTitle;


        }finally {
            driver.quit();
        }
    }



}
