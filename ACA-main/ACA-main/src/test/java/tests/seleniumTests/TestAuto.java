package tests.seleniumTests;

import base.BaseGoogleAutoAm;
import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AutoHomePage;

public class TestAuto extends BaseGoogleAutoAm {
    AutoHomePage autoHomePage;



    @Test
    public void AutoAm(){
        autoHomePage = new AutoHomePage(driver);
        autoHomePage.inputSearch("auto.am");
        autoHomePage.clickLick();
        autoHomePage.checkTitle();
        autoHomePage.selectMark();
        autoHomePage.selectModel();
        autoHomePage.selectMinYear();
        autoHomePage.checkCheckBox();
        autoHomePage.clickSearch();
        autoHomePage.checkResult();
    }
}




