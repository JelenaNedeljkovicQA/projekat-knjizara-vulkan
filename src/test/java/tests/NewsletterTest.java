package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.InventoryPage;
import pages.Strings;

public class NewsletterTest extends BaseTest{


    @Test
    public void reportMailForNewsletter() {
        driver = openChromeDriver();

        try {

            InventoryPage inventoryPage = logIntoInventoryPage();

            assert CurrentURLEqualTo(Strings.INVENTORY_PAGE_URL) : "Expected url:" + Strings.INVENTORY_PAGE_URL;

            inventoryPage.clickReportMailForNewsletter();




            String messageFailed = inventoryPage.getmessageFailedText();
            Assert.assertFalse(" Expected : " + Strings.MESSAGE_FAILED + ". Actual: "
                    + messageFailed, messageFailed.equals(Strings.MESSAGE_FAILED));

        }finally {
            driver.quit();
        }
        }


}
