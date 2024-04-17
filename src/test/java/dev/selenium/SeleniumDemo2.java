package dev.selenium;

import dev.selenium.base.MainTest;
import dev.selenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo2 extends MainTest {
    @Test
    public void test0PenBrowser() {
        //WebDriver driver = new ChromeDriver();
        DriverFactory.getDriver().getTitle();

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = DriverFactory.getDriver().findElement(By.id("my-text-id-test"));
        WebElement submitButton = DriverFactory.getDriver().findElement(By.cssSelector("button"));

        DriverFactory.getDriver().navigate().refresh();

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = DriverFactory.getDriver().findElement(By.id("message"));
        message.getText();


    }

    }
