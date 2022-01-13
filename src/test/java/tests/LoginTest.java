package tests;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;
import pages.Strings;

public class LoginTest extends BaseTest{




    @Test
    public void loginWithValidUsernameAndPassword() {
        driver = openChromeDriver();

        try {
            LoginPage loginPage =  new LoginPage (driver);
            loginPage.clickButtonSingUp();
            loginPage.enterUserNameField (Strings.VALID_USERNAME);
            loginPage.enterPasswordField (Strings.VALID_PASSWORD);

            InventoryPage inventoryPage = loginPage.clickinLoginButtonSuccess();


            assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;

        } finally {
//            driver.quit();
        }

    }


    @Test
    public void loginWithInvalidUsernameAndValidPassword() {
        driver = openChromeDriver();

        try {
        LoginPage loginPage =  new LoginPage (driver);
        loginPage.clickButtonSingUp();
        loginPage.enterUserNameField (Strings.INVALID_USERNAME);
        loginPage.enterPasswordField (Strings.VALID_PASSWORD);
        loginPage.clickinLoginButtonAndExpectError();

        assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;
        String currentErrorText = loginPage.getErrorMessageText();
        assert currentErrorText.equals(Strings.LOGIN_ERROR_MESSAGE) : "Expected error message : " + Strings.LOGIN_ERROR_MESSAGE + " . Actual: " + currentErrorText;

    } finally {
        driver.quit();
    }

}

}
