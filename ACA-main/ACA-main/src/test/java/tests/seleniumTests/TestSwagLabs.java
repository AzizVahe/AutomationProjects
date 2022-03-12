package tests.seleniumTests;

import base.SwagLabsBase;
import org.openqa.selenium.WebDriver;
import pages.SwagLoginPage;
import org.testng.annotations.Test;
import pages.PracticePage;

public class TestSwagLabs extends SwagLabsBase {
    SwagLoginPage swagLoginPage;

@Test
public void swagTest(){
swagLoginPage = new SwagLoginPage(driver);
swagLoginPage.checkTitle();
swagLoginPage.login();
swagLoginPage.checkTitleProd();
swagLoginPage.filtering();
//swagLoginPage.checkFiltering();
swagLoginPage.addJacket();
swagLoginPage.navigateToCart();
swagLoginPage.checkProduct();
swagLoginPage.clickOnCheckoutBtn();
swagLoginPage.checkout();
swagLoginPage.checkTotalPrice();
swagLoginPage.checkMessage();
}


}
