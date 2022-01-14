package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage{



    @FindBy(xpath = "//a[@title='Facebook']")
    WebElement logToFacebookButton;

    @FindBy(xpath = "//a[@title='Twitter']")
    WebElement logToTwitterButton;

    @FindBy(xpath = "//a[@title='Instagram']")
    WebElement logToInstagramButton;

    @FindBy(xpath = "//button[@class='btn confirm-loader']")
    WebElement newsletterButton;

    @FindBy(xpath = "//*[@id='newsletter_form']/div[3]/div")
    WebElement checkboxButton;

    @FindBy(id = "newsletter_form")
    WebElement messageFailed;

    @FindBy(name = "newsletter_email")
    WebElement newsletterEmail;

    @FindBy(xpath = "//div[@class='text-wrapper ']/div[@class='title']/a[@title='CENTRAL PARK ']")
    WebElement bookCentralPark;

    @FindBy (xpath = "//button[@class='cookie-agree 3']/span[@aria-hidden='true']")
    WebElement cookieButton;

    @FindBy(xpath = "//div[@class='block autocomplete-button  autocomplete-button-simple ']/span[@class='title']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='autocomplete']/input[@id='search-text']")
    WebElement enterSearchText;

    @FindBy (xpath = "//label[@for='2_3d']")
    WebElement filterByLetter;

    @FindBy(id = "nb_addToCartButton")
    WebElement addToCartBookCentralPark;

    @FindBy(xpath = "//a[@class='btn  btn-sm btn-default product-item-remove']")
    WebElement removeItemFromCartButton;

    @FindBy(xpath = "//button[@data-bb-handler='confirm']")
    WebElement confirmRemoveButton;



  //    konstruktor

    public InventoryPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    metode

    public InventoryPage clickFindItems () {
        print("clickFindItems");
        print("searchButton");
        waitForElement(searchButton);
        searchButton.click();
        print("enterSearchText");
        waitForElement(enterSearchText);
        enterSearchText.sendKeys(Strings.PROIZVODI + "\n");
        return this;

    }

    public InventoryPage clickToSortCheckboxItem () {
        print("clickToSortCheckboxItem");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitForElement(cookieButton);
        cookieButton.click();
        js.executeScript("arguments[0].click();", filterByLetter);
        print("filterByLetter");
        waitForElement(filterByLetter);
//        filterByLetter.click();
        return this;

    }


    public InventoryPage clickReportMailForNewsletter() {
        print("clickreportMailForNewsletter");
         JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get ("https://www.knjizare-vulkan.rs/");
        waitForElement(cookieButton);
        cookieButton.click();
        js.executeScript("arguments[0].click();", newsletterEmail);
        waitForElement(newsletterEmail);
        newsletterEmail.sendKeys(Strings.INVALID_EMAIL);
        waitForElement(checkboxButton);
        checkboxButton.click();
        waitForElement(newsletterButton);
        newsletterButton.click();

        return this;
    }



    public void enterNewsletterEmail (String text) {
        print("enterNewsletterEmailField");
        newsletterEmail.sendKeys(text);
    }




    public String getmessageFailedText() {
        String messageFailedText = messageFailed.getText();
        print("Error message is " + messageFailedText);
        return messageFailedText;

    }




    public InventoryPage clicklogToFacebookButton () {
        print("clickingToFacebookButton");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get ("https://www.knjizare-vulkan.rs/");
        waitForElement(cookieButton);
        cookieButton.click();
        js.executeScript("arguments[0].click();", logToFacebookButton);
        waitForElement(logToFacebookButton);
        logToFacebookButton.click();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(2));

        return this;

    }
    public InventoryPage clicklogToTwitterButton () {
        print("clickingToTwitterButton");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get ("https://www.knjizare-vulkan.rs/");
        waitForElement(cookieButton);
        cookieButton.click();
        js.executeScript("arguments[0].click();", logToTwitterButton);
        waitForElement(logToTwitterButton);
        logToTwitterButton.click();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(2));
        return this;
    }

    public InventoryPage clicklogToInstagramButton () {
            print("clicklogToInstagramButton");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.get ("https://www.knjizare-vulkan.rs/");
            waitForElement(cookieButton);
            cookieButton.click();
            js.executeScript("arguments[0].click();", logToInstagramButton);
            waitForElement(logToInstagramButton);
            logToInstagramButton.click();
            List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs.get(2));

            return this;
    }


    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickCookieButton() {
        waitForElement(cookieButton);
        cookieButton.click();

    }

    public InventoryPage clickfindItemAndAddToCart()  {
        print("clickfindItemAndAddToCart");
        waitForElement(cookieButton);
        cookieButton.click();
        print("searchButton");
        waitForElement(searchButton);
        searchButton.click();
        print("enterSearchText");
        waitForElement(enterSearchText);
        enterSearchText.sendKeys(Strings.AUTHOR_OF_BOOKS + "\n");
        print("clickOnBookCentralPark");
        waitForElement(bookCentralPark);
        bookCentralPark.click();
        print("clickAddToCartBookCentralPark");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartBookCentralPark);
        waitForElement(addToCartBookCentralPark);
        addToCartBookCentralPark.click();
        waitForElement(shoppingCartNumberBadge);
        shoppingCartNumberBadge.click();
        return this;

    }

    public InventoryPage clickRemoveItemFromCart() {
        print("clickRemoveItemFromCart");
        waitForElement(removeItemFromCartButton);
        removeItemFromCartButton.click();
        waitForElement(confirmRemoveButton);
        confirmRemoveButton.click();
        return this;
    }

    }

