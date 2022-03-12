package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PracticePage {
    WebDriver driver;

    @FindBy(css = "[value=\"radio2\"]")
    WebElement radioBtn;

    @FindBy(id = "autocomplete")
    WebElement inputCountry;

    @FindBy(id = "dropdown-class-example")
    WebElement dropDown;

    @FindBy(id = "checkBoxOption2")
    WebElement checkBox;

    @FindBy(id = "openwindow")
    WebElement windowBtn;

    @FindBy(id = "opentab")
    WebElement newTab;

    @FindBy(id = "name")
    WebElement alertInput;

    @FindBy(id = "alertbtn")
    WebElement alertBtn;

    @FindBy(xpath = "//*[@id=\"product\"]/tbody/tr[10]")
    WebElement table;

    @FindBy(name = "show-hide")
    WebElement hideShowInput;

    @FindBy(id = "hide-textbox")
    WebElement hideInput;

    @FindBy(id = "show-textbox")
    WebElement showInput;

    @FindBy(id = "mousehover")
    WebElement mouseHoverBtn;

    @FindBy(xpath = "/html/body/div[4]/div/fieldset/div/div/a[2]")
    WebElement hoverReloud;


    public void checkTitle() {
        driver.getTitle().contains("Practice Page");
    }

    public PracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRadio() {
        radioBtn.click();
    }

    public void inputCountry(String input) {
        inputCountry.sendKeys("Armenia");
    }

    public void selectDropDown() {
        Select select = new Select(dropDown);
        select.selectByValue("option3");

    }

    public void checkCheckBox() {
        if (checkBox.isSelected()) {
            return;
        } else checkBox.click();
    }

    public void clickWindowBtn() throws InterruptedException {
        windowBtn.click();
        String homePage = driver.getWindowHandle();
        Set<String> popUps = driver.getWindowHandles();
        Iterator<String> i1 = popUps.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!homePage.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                Thread.sleep(2000);
                driver.close();
            }
        }
    }

    public void clickNewTab() throws InterruptedException {
        newTab.click();
        String homePage = driver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        driver.close();
    }

    public void alertHandel(String input) throws InterruptedException {
        alertInput.sendKeys("Tdxk");
        alertBtn.click();
        Thread.sleep(1000);
        if (driver.switchTo().alert().getText().equals("Tdxk")) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }

    }

    public void checkTable() {
        System.out.println(table.getText()
                .contains("Advanced Selenium Framework Pageobject, TestNG, Maven, Jenkins,C"));
    }

    public void checkHideShow() {
        if (hideShowInput.isDisplayed()) {
            hideInput.click();
        } else {
            showInput.click();
        }
    }

    public void mouseHoverClick() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(mouseHoverBtn).perform();
        Thread.sleep(1000);
        action.moveToElement(hoverReloud).click().build().perform();
        Thread.sleep(1000);
    }
}


