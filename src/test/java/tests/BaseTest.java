package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InventoryPage;
import pages.LoginPage;
import pages.Strings;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    WebDriver driver = null;


    public WebDriver openChromeDriver() {
        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments(new String[]{"--start-maximized"})
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }


    public void print(String text) {

        System.out.println(text);
    }

    public boolean CurrentURLEqualTo(String expectedUrl) {
        print("currentURLEqualTo ( " + expectedUrl + " )");
        String currentUrl = driver.getCurrentUrl();
        print("User is on " + currentUrl);
        boolean b = currentUrl.equals(expectedUrl);
        return b;
    }

    public InventoryPage logIntoInventoryPage() {
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.clickButtonSingUp();
        loginPage.enterUserNameField(Strings.VALID_USERNAME);
        loginPage.enterPasswordField(Strings.VALID_PASSWORD);
        InventoryPage inventoryPage = loginPage.clickinLoginButtonSuccess();
        return inventoryPage;

    }

//    public boolean verifySearchItemIsShown(String search, WebDriver driver) {
//        List<WebElement> searchItems = driver.findElements(By.xpath("///html/body/div[4]/div[2]/div/div[2]/div[2]/div[3]/div/div[1]/div/div/div[3]/div[5]/a"));
//        ArrayList<String> searchItemText = new ArrayList<>();
//        for(WebElement item :  searchItems) {
//            String text = item.getText();
//            searchItemText.add(text);
//        }
//        return searchItemText.contains(search);
//    }

}



