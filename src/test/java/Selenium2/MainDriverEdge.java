package Selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainDriverEdge {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new EdgeDriver();
        driver.get ("https://www.selenium.dev/selenium/web/web-form.html");
    }
    @AfterMethod
    public void tearDown() {
      driver.quit();
           }

}
