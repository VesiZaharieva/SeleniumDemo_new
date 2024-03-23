package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo2 extends MainDriver {
    @Test
    public void test0PenBrowser() {
        //WebDriver driver = new ChromeDriver();
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.id("my-text-id-test"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        driver.navigate().refresh();

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();


    }

    }
