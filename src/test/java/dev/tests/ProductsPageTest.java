package dev.tests;

import dev.selenium.base.MainTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainBeforeAfter;
import pages.ProductsPage;

public class ProductsPageTest extends MainTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    //ShoppingCartPage shoppingCartPage;
    @BeforeMethod
    public void loginBefore() {
        loginPage = new LoginPage();
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void canOpenCart() {
        productsPage = new ProductsPage();
        productsPage.header().openCartByIcon();

        //CartPage cartPage = new CartPage(driver);
        // cartPage.
    }

    @Test
    public void TestRemoveProduct() {
        productsPage = new ProductsPage();
        productsPage.addProduct();
        productsPage.clickShoppingBasket();


    }
}