package pages;

import dev.selenium.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[placeholder=Username]")
    private WebElement usernameInput; // Equals to private By userName = By.id("");

    //-> private By userName = By.id("");
    // Equals to @FindBy (id = "user-name")   private WebElement usernameInput;
    //and no need od constructor LoginPage


    @FindBy(css = "[placeholder=Password]")
    private WebElement passwordInput;

    @FindBy(css = "[value=Login]")
    private WebElement loginButton;

    //@FindBys({
            //@FindBy(id = "login-button"),
            //@FindBy(id = "password")})
    //private List<WebElement> LoginButton;

    @FindBy(className = ".error-message-container")
    private WebElement errorMessage;

    @FindBy (css = "#cmplz-cookiebanner-container .cmplz-accept")
    private WebElement element;

    //@FindBys( {
    // @FindBy(id = "login-button"),
    //@FindBy(id = "password")})
    //private List<WebElement> LoginButton;

//@FindBy (xpath = "//login-button")
//private WebElement loginButton;
    public void DevBg(){
        element.click();
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
    public void loginAs (String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
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
