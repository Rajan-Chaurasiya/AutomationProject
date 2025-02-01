package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchPage;
import pageObject.homePage;
import testBase.BaseClass;

public class SearchProductTest extends BaseClass {

    @Test(groups = {"Master"})
    public void productsearch(){

        try {
            logger.info("*** Search Test Case started ***");
            homePage hp = new homePage(driver);

            logger.info("Product seached");
            hp.setTxtProduct(p.getProperty("SEARCH_PRODUCT"));
            logger.info("click on search button");
            hp.ButtonSearch();

            SearchPage sp = new SearchPage(driver);


            Assert.assertTrue(sp.verifysearchText(), "search results are not showing");
            logger.info("Search Test Case Passed");
        } catch (Exception e) {
            logger.error("Search Test Case failed",e);
            Assert.fail();
        }
    }
}
