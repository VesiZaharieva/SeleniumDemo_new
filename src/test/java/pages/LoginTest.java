package pages;

import dev.selenium.MainDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainBeforeAfter {
    //private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void testSuccessfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        //ProductsPage productsPage = loginPage.clickLoginButton();
        //Assert.assertEquals(productsPage.getPageTitle(), "Products");
        loginPage.clickLoginButton();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());
    }

    @Test
    public void testNotValidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }


    // productsPage.addProduct();
    //productsPage.openShoppingCart();
    //ShoppingCart cart = new ShoppingCart(driver);
    //Assert.assertTrue(cart.isItemAdded());

    //cart.removeItem();
    //assertFalse(cart.isItemAdded());


    //@Test
    //public void testNotValidLogin() {
    //loginPage = new LoginPage(driver);
    //loginPage.setUsername("error_user");
    //loginPage.setPassword("secret_sauce");
    //loginPage.clickLoginButton();
    //productsPage = new ProductsPage(driver);
    //checkPage


    //}
}



