package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.Strings;

import java.net.URL;
import java.util.ArrayList;

public class LogInFbInTwTest extends BaseTest{


    @Test

    public void logInFacebookPage(){

        driver = new ChromeDriver();

        try {
            InventoryPage inventoryPage = logIntoInventoryPage();

            assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;

            inventoryPage.clicklogToFacebookButton();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));

            assert CurrentURLEqualTo(Strings.FACEBOOK_URL) : "Expected url:" + Strings.FACEBOOK_URL;


        }finally {
//            driver.quit();
        }
    }


    @Test

    public void logToInstagramPage(){

        driver = new ChromeDriver();

        try {
            InventoryPage inventoryPage = logIntoInventoryPage();

            assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;

            inventoryPage.clicklogToInstagramButton();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));

            assert CurrentURLEqualTo(Strings.INSTAGRAM_URL) : "Expected url:" + Strings.INSTAGRAM_URL;


        }finally {
//            driver.quit();
        }
    }

    @Test

    public void logInTwitterPage(){

        driver = new ChromeDriver();

        try {
            InventoryPage inventoryPage = logIntoInventoryPage();

            assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;

            inventoryPage.clicklogToTwitterButton();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));

            assert CurrentURLEqualTo(Strings.TWITTER_URL) : "Expected url:" + Strings.TWITTER_URL;


        }finally {
//            driver.quit();
        }
    }


}
