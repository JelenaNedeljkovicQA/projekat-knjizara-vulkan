package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends  BasePage {

    @FindBy(className = "login-btn")
    WebElement buttonSingUp;

    @FindBy (id = "login_email")
    WebElement userNameField;

    @FindBy(id = "login_password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-success btn-login confirm-loader']")
    WebElement loginButton;

    @FindBy(xpath = "//li[@class='parsley-type']")
    WebElement errorMessage;




//    konstruktori


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(Strings.INVENTORY_PAGE_URL);

    }

//    metode

    public LoginPage clickButtonSingUp () {
       print("clickButtonSingUp");
       buttonSingUp.click();
       return this;
           }

    public void enterUserNameField ( String text) {
        print("Enter UserName");
        userNameField.sendKeys(text);
    }

    public void enterPasswordField (String text) {
        print("Enter Password");
        passwordField.sendKeys(text);

    }
    public InventoryPage clickinLoginButtonSuccess (){
        print("clickinLoginButton");
        loginButton.submit();
       return new InventoryPage(driver);
    }

    public LoginPage  clickinLoginButtonAndExpectError() {
        print("ClickinLoginButtonAndExpectError");
        loginButton.submit();
        return this;

    }
    public boolean isErrorMessagePresent() {
        print("isErrorMessagePresent");
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText() {
        assert isErrorMessagePresent() : "Error message is not present on Login page";
        String errorMessageText = errorMessage.getText();
        print("Error message is " + errorMessageText);
        return errorMessageText;
    }







}
