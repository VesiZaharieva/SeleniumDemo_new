package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {
    //private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameInput; // Equals to private By userName = By.id("");

    //-> private By userName = By.id("");
    // Equals to @FindBy (id = "user-name")   private WebElement usernameInput;
    //and no need od constructor LoginPage

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    //@FindBys({
            //@FindBy(id = "login-button"),
            //@FindBy(id = "password")})
    //private List<WebElement> LoginButton;

    @FindBy(css = "[data-test=error]")
    private WebElement errorMessage;

    //@FindBys( {
    // @FindBy(id = "login-button"),
    //@FindBy(id = "password")})
    //private List<WebElement> LoginButton;

//@FindBy (xpath = "//login-button")
//private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
        super(driver);
    }

    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    //public ProductsPage clickLoginButton(){ //вече съм на др.стр.и от нея продължавам
    //LoginButton.click();
    //return new ProductsPage(driver);
    //}
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
    // public boolean isCartEmpty(){
    //if (passwordInput.size() == 0) {
    // return true;
    //} else {
    //return false;
    //}
    //}
    //public void removeItem(){
    //ListOfRemoveButtons.get(0).click();
    //}
}
