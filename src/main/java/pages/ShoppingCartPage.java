package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.ArrayList;

public class ShoppingCartPage extends BasePage{

//    webelements



    @FindBy(className = "table-responsive")
    WebElement cartItemList;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;



//    konstruktor
//

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    metode





    }

