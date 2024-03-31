package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class MainBeforeAfter {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get ("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    //@AfterMethod
    //public void tearDown() {
    //driver.quit();
    //}
}
