package dev.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainDriver {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get ("https://www.selenium.dev/selenium/web/web-form.html");
    }
    //@AfterMethod
    //public void tearDown() {
        //driver.quit();
    //}
}
