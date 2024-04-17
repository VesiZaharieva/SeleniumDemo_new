package dev.selenium;

//import dev.selenium.base.MainDriver;
import dev.selenium.base.MainTest;
import dev.selenium.driver.DriverFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import java.util.List;


public class SeleniumDemo extends MainTest {

    @Test
    public void test0PenBrowser() {

        //driver.getTitle();

        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // WebElement textBox = driver.findElement(By.id("my-text-id-test"));
        // WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // driver.navigate().refresh();

        //textBox.sendKeys("Selenium");
        //submitButton.click();

        //WebElement message = driver.findElement(By.id("message"));
        // message.getText();

        //WebElement password = driver.findElement(By.cssSelector("[name=my-password]"));
        //password.click();

        //WebElement textInput = driver.findElement(By.cssSelector("#my-text-id"));
        //textInput.click();

        WebElement password = DriverFactory.getDriver().findElement(By.xpath("//*[@name='my-password']"));
        password.click();

        WebElement textInput = DriverFactory.getDriver().findElement(By.xpath("//*[@id='my-text-id']"));
        textInput.click();


        WebElement textArea = DriverFactory.getDriver().findElement(By.cssSelector("[type=text].form-control[name*=text]"));
        textArea.click();

        WebElement checkBox1 = DriverFactory.getDriver().findElement(By.cssSelector("[type=checkbox][id $='1']"));
        checkBox1.click();

        WebElement checkBox2 = DriverFactory.getDriver().findElement(By.cssSelector("[type=checkbox][id $='2']"));
        checkBox2.click();

        WebElement colorPicker = DriverFactory.getDriver().findElement(By.cssSelector("[type=color]"));
        colorPicker.click();

        //WebElement radioButtonChecked = driver.findElement(By.cssSelector("[name=my-radio][checked]"));
        //radioButtonChecked.click();

        WebElement radioButtonChecked = DriverFactory.getDriver().findElement(By.xpath("//h1[contains(text(),'Textarea')]"));
        radioButtonChecked.click();

        WebElement buttonSubmit = DriverFactory.getDriver().findElement(By.cssSelector("button[type=submit]"));
        buttonSubmit.click();
    }

    @Test
    public void testList() {
        List<WebElement> myList = DriverFactory.getDriver().findElements(By.cssSelector("input"));
        myList.get(2).click();

    }
    //@Test
//Thread.sleep(5000);
}





