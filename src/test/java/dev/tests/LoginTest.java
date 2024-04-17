package dev.tests;

import com.opencsv.exceptions.CsvException;
import dev.selenium.base.MainTest;
import dev.selenium.driver.DriverFactory;
import dev.selenium.utils.CsvReader;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainTest {
    //private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderHardcodedData() {      //Вс.класове в java са наследници на глвен клас Object
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "login-data-file")
    public static Object[][] dataProviderFromScvFile() throws IOException, CsvException {      //Вс.класове в java са наследници на глвен клас Object
        return CsvReader.readFile("src/test/resources/login-data.csv");
    }

    @DataProvider(name = "notvalid-login-data")
    public static Object[][] dataProviderCsvNotvalidData() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/login-notvalid-data.csv");
    }

    @Epic("Authentication")
    @Feature("Login")
    @Story("Successful Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "login-data-file")
    public void testSuccessfulLogin(String username, String password) {
        loginPage = new LoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        //ProductsPage productsPage = loginPage.clickLoginButton();
        assertEquals(productsPage.getPageTitle(), "Products");
        loginPage.clickLoginButton();
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        ProductsPage productsPage = new ProductsPage();
        assertEquals("Products", productsPage.getPageTitle());
    }
    @Epic("Dev.bg")
    @Feature("Login")
    @Story("Successful Login")
    @Severity(SeverityLevel.CRITICAL)
   @Test
    public void DevBg() {
        loginPage = new LoginPage();
        loginPage.DevBg();
    }
    @Epic("Authentication")
    @Feature("Login")
    @Story("Unsuccessful Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "notvalid-login-data")
    public void testNotValidLogin(String username, String password, String message) {
        //SoftAssert soft = new SoftAssert();
        loginPage = new LoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        //assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
        //assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
        //loginPage = new LoginPage();
        //loginPage.setUsername("standard_user");
        //loginPage.setPassword("");
        //loginPage.clickLoginButton();
        //assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
        //assertAll();
        assertEquals(loginPage.getErrorMessage(), message);
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



