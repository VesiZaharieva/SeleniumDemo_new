package pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends MainBeforeAfter {
    LoginPage loginPage;
    ProductsPage productsPage;
    //ShoppingCartPage shoppingCartPage;
    @BeforeMethod
    public void loginBefore() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
    }
    @Test
    public void canOpenCart() {
        productsPage = new ProductsPage(driver);
        productsPage.header().openCartByIcon();

        //CartPage cartPage = new CartPage(driver);
               // cartPage.
    }
    @Test
    public void TestRemoveProduct() {
        productsPage = new ProductsPage(driver);
        productsPage.addProduct();
        productsPage.clickShoppingBasket();


    }}