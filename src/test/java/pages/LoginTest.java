package pages;

import dev.selenium.base.MainTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainTest {
    //private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void testSuccessfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        //ProductsPage productsPage = loginPage.clickLoginButton();
        assertEquals(productsPage.getPageTitle(), "Products");
        loginPage.clickLoginButton();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());
    }
@Test
public void DevBg(){
    loginPage = new LoginPage(driver);
    loginPage.DevBg();


}
    @Test
    public void testNotValidLogin() {
        SoftAssert soft = new SoftAssert();
        loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        soft.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
         //assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        soft.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
        soft.assertAll();
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



