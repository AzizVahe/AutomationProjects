package tests.seleniumTests;

import base.PracticePageBase;
import org.testng.annotations.Test;
import pages.PracticePage;

public class TestPracticePage extends PracticePageBase {
    PracticePage practicePage;

    @Test
    public void radioClick() {
        practicePage = new PracticePage(driver);
        practicePage.clickRadio();
    }

    @Test
    public void inputCountry() {
        practicePage = new PracticePage(driver);
        practicePage.inputCountry("Armenia");
    }

    @Test
    public void selectDropDown() {
        practicePage = new PracticePage(driver);
        practicePage.selectDropDown();
    }

    @Test
    public void checkCheckBox() {
        practicePage = new PracticePage(driver);
        practicePage.checkCheckBox();
    }

    @Test
    public void popUpHandle() throws InterruptedException {
        practicePage = new PracticePage(driver);
        practicePage.clickWindowBtn();
    }

    @Test
    public void clickNewTab() throws InterruptedException {
        practicePage = new PracticePage(driver);
        practicePage.clickNewTab();
    }

    @Test
    public void alertHandeling() throws InterruptedException {
        practicePage = new PracticePage(driver);
        practicePage.alertHandel("Tdxk");
    }

    @Test
    public void webTableCheck() {
        practicePage = new PracticePage(driver);
        practicePage.checkTable();
    }

    @Test
    public void hideShowCheck() {
        practicePage = new PracticePage(driver);
        practicePage.checkHideShow();
    }

    @Test
    public void mouseHoverCkeck() throws InterruptedException {
        practicePage = new PracticePage(driver);
        practicePage.mouseHoverClick();
    }

}
