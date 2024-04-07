package pages;

import dev.selenium.base.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    //private WebDriver driver;

    @FindBy(css = "span.title")
    private WebElement pageTitle;

    @FindBy(css = "btn btn_primary")
    private WebElement addButton;

    @FindBy(className = "add-to-cart-sauce")
    private WebElement ShoppingBasket;

    @FindBy (css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;

    public ProductsPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void addProduct() {
        addButton.click();
    }

    public void clickShoppingBasket() {
        ShoppingBasket.click();
    }
    //}
    //public void openShoppingCart(){

    //}
    public HeaderComponent header() {
        return new HeaderComponent(driver);
    }

    public void openShoppingCart(){
        waitForElementToBeVisible(shoppingCartBadge);
        shoppingCartBadge.click();
    }
}

