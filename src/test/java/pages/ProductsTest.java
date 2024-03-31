package pages;

import org.testng.annotations.Test;

public class ProductsTest extends MainBeforeAfter {
    LoginPage loginPage;
    ProductsPage productsPage;
    //ShoppingCartPage shoppingCartPage;
    @Test
    public void TestRemoveProduct() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        //productsPage = new ProductsPage(driver);
        //productsPage.addProduct();
        //productsPage.clickBasket();


    }}