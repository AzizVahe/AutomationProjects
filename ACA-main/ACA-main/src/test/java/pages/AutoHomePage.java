package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class AutoHomePage {

    WebDriver driver;

    @FindBy(css = "div > div.a4bIc > input")
    WebElement googleSearch;

    @FindBy(xpath = "//*[@*='LC20lb MBeuO DKV0Md']")
    WebElement link;

    @FindBy(xpath = "//*[@id=\"filter-make\"]")
    WebElement mark;

    @FindBy(xpath = "//*[@id=\"v-model\"]")
    WebElement model;

    @FindBy(xpath = "//*[@id=\"home-filters\"]/div[3]/label[1]/select")
    WebElement year;

    @FindBy(xpath = "//*[@id=\"home-filters\"]/div[6]/div[1]")
    WebElement customCheck;

    @FindBy(id = "search-btn")
    WebElement searchButton;

    @FindBy(css = "div[id ^= 'ad'] [class = 'card-action']")
    WebElement searchResult;



    public void checkTitle(){
        driver.getTitle().contains("Ավտոմեքենաների վաճառք Հայաստանում - Auto.am");
    }

    public AutoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void inputSearch(String input){
        googleSearch.sendKeys("auto.am");
        googleSearch.submit();
    }

    public void clickLick(){
        link.click();
    }

    public void selectMark(){
        Select select = new Select(mark);
        select.selectByVisibleText("Tesla");
    }

    public void selectModel(){
        Select select = new Select(model);
        select.selectByVisibleText("Model Y");
    }

    public void selectMinYear(){
        Select select = new Select(year);
        select.selectByValue("2018");
    }


    public void checkCheckBox(){
        if(customCheck.isSelected()){
            return;
        }else {
            customCheck.click();
        }
    }

    public void clickSearch(){
        searchButton.click();
    }

    public void checkResult(){
        Assert.assertTrue(searchResult.getText().contains("Tesla"));
        Assert.assertTrue(searchResult.getText().contains("$ 67 000"));

    }





}
