package pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage{
    //private WebDriver driver;

    @FindBy(css = "span.title")
    private WebElement pageTitle;

    @FindBy (className = "btn btn_primary")
    private WebElement addButton;

    @FindBy (className = "add-to-cart-sauce")
    private WebElement basket;

    public ProductsPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }
    public String getPageTitle(){
        return pageTitle.getText();
    }
    public void addProduct() {
        addButton.click();
    }
        public void clickBasket(){
            basket.click();
        }
    //}
    //public void openShoppingCart(){

    //}

}
