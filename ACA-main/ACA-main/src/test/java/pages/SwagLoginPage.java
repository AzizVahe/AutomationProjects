package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SwagLoginPage {
    WebDriver driver;

    @FindBy(id = "login_credentials")
    WebElement loginCrdntls;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]")
    WebElement passCredentials;

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    WebElement filter;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addJacketBtn;

    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCart;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]")
    WebElement cartItemLabel;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(className = "summary_total_label")
    WebElement totalPrice;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "complete-header")
    WebElement header;

//    public boolean checkFiltering(){
//        List<WebElement> elements = driver.findElements(By.className("inventory_item_price"));
//        List<Integer> prices = new ArrayList<>();
//        for (int i = 0; i < elements.size(); i++) {
//            Integer price = Integer.parseInt(elements.get(i).getText());
//            prices.add(price);
//            if (prices.get(i) < prices.get(i+1)){
//                return true;
//            }
//        }return false;
//    }
    public void checkMessage(){
        header.getText().contentEquals("THANK YOU FOR YOUR ORDER");
    }

    public void checkTotalPrice(){
       totalPrice.getText().contains("53.99");
       finishBtn.click();
    }

    public void checkout(){
        firstName.sendKeys("Jackie");
        lastName.sendKeys("Chan");
        postalCode.sendKeys("0101");
        continueBtn.click();
    }

    public void clickOnCheckoutBtn(){checkoutBtn.click();}

    public void checkProduct(){
        cartItemLabel.getText().equals("Sauce Labs Fleece Jacket");
    }

    public void navigateToCart(){shoppingCart.click();}

    public void addJacket(){addJacketBtn.click();}

    public void filtering(){
        Select select = new Select(filter);
        select.selectByValue("lohi");
    }

    public  void login(){
        username.sendKeys(getLogin());
        password.sendKeys(getPass());
        submitBtn.click();
    }

    public String getLogin(){
        String[] login = loginCrdntls.getText().split("\n");
        String log = login[1];
        return log;
    }
    public String getPass(){
        String[] password = passCredentials.getText().split("\n");
        String log = password[1];
        return log;
    }

    public void checkTitle() {
        driver.getTitle().contains("Swag Labs");
    }

    public void checkTitleProd() {
        driver.getTitle().contains("Products");
    }

    public SwagLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
