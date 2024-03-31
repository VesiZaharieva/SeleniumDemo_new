package dev.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.event.ActionEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ActionsAndSelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new EdgeDriver();
    }

    @Test
    public void sliderTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = driver.findElement(By.cssSelector(".form-range"));
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider).moveByOffset(40, 0).perform();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Actions drag = new Actions(driver);
        Thread.sleep(2000);
        drag.clickAndHold(source).moveToElement(target).release().perform();
    }

    @Test
    public void escapeKey() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement inputRow = driver.findElement(By.id("target"));
        inputRow.sendKeys(Keys.ESCAPE);
        WebElement message = driver.findElement(By.id("result"));
        String messageText = message.getText();
        Assert.assertEquals(messageText, "You entered: ESCAPE");
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement select = driver.findElement(By.id("dropdown"));
        Select dropDown = new Select(select);
        dropDown.selectByVisibleText("Option 1");
        Thread.sleep(8000);
        dropDown.selectByValue("2");
    }

    @Test
    public void dropdownTest2() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement select = driver.findElement(By.className("form-select"));
        Select dropDown = new Select(select);
        dropDown.selectByVisibleText("One");
        Thread.sleep(8000);
        dropDown.selectByValue("3");
    }

    @Test
    public void tableExtraction() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> emails = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[3]"));
        for (WebElement email : emails) {
            System.out.println(email.getText());
        }
    }

    @Test
    public void colorPickerTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement colorPicker = driver.findElement(By.className(".col-md-4 py-2 'Color picker']"));
        colorPicker.click();
        Actions moveColor = new Actions(driver);
        moveColor.click(colorPicker).moveByOffset(60, 70).perform();
    }

    @Test
    public void paginationTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pagination.js.org/");
        WebElement demo1 = driver.findElement(By.id("demo1"));
        List<WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
        List<WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));
        pagination.get(2).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.stalenessOf(items.get(0)));
        items = demo1.findElements(By.cssSelector(".data-container ul li"));
        //assertTrue(items.get(0).getText().equals("11"));
        assertEquals("11", items.get(0).getText());
    }

    @Test
    public void waitVisibility() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/['button']"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement helloWorldText = wait.until(visibilityOfElementLocated
                (By.xpath("//div[@id='finish']/['start']")));
        // assertEquals("Hello World!", helloWorldText.getText());
    }

    @Test
    public void uploadFile() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        File uploadFile = new File("C:\\Users\\my\\IdeaProjects\\SeleniumDemo\\test.docx");
        WebElement fileInput = driver.findElement(By.cssSelector("[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();
    }

    @Test
    public void waitUploadFile() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        File uploadFile = new File("C:\\Users\\my\\IdeaProjects\\SeleniumDemo\\target\\istockphoto-1353370109-640_adpp_is.mp4");
        WebElement fileInput = driver.findElement(By.cssSelector("[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();
    }

    @Test
    public void tableClickEdit() {
        // To click edit button of "Doe Jason and to print $sum."
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> lastNames = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[1]"));
        for (WebElement lastName : lastNames) {
            if (lastName.getText().equals("Doe")) {
                WebElement firstName = driver.findElement(By.xpath("//*[@id='table1']//tr[td[contains(text(),'Doe')]]/td[2]"));
                if (firstName.getText().equals("Jason")) {
                    WebElement editButton = driver.findElement(By.xpath("//*[@id='table1']//tr[td[contains(text(),'Doe')]]/td[6]/a[@href='#edit']"));
                    editButton.click();
                    WebElement money = driver.findElement(By.xpath("//*[@id='table1']//tr[td[contains(text(),'Doe')]]/td[4]"));
                    System.out.println(money.getText());
//table[@id='table1']//td[contains(text(), 'Frank'0]/../td/a/[contains(text(),'edit')]
                }
            }
        }
    }
    @Test
    public void Table2(){

    }

    @Test
    public void loginGlitchUser() {
        // test wait
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("performance_glitch_user");
        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement pageTitle = wait.until(visibilityOfElementLocated(By.className("title")));
        Assert.assertTrue(pageTitle.isDisplayed());
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
    }

    @Test
    public void waits() {
        driver.get("https://www.broshura.bg/b/4863703#page-1");

        WebDriverWait waitToShow = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieWindow1 = waitToShow.until(visibilityOfElementLocated(By.id("cookiescript_injected_wrapper")));

        WebElement cookieClose = driver.findElement(By.cssSelector("div.cookiescript_pre_header #cookiescript_close"));
        cookieClose.click();
        WebDriverWait waitToClose = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement cookieWindow2 = waitToClose.until(stalenessOf(WebElement)By.id("cookiescript_injected_wrapper")));


        //WebElement nextBrochure = driver.findElement(By.xpath("//nav[@class='og-navigation-bottom']//div[@class='og-is-right']"));
        WebDriverWait waitToBeClickable = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextBrochureButton = waitToBeClickable.until(elementToBeClickable(By.xpath("//nav[@class='og-navigation-bottom']//div[@class='og-is-right']")));
        nextBrochureButton.click();
    }

    @Test
    public void removeCheckBox() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkBox = driver.findElement(By.cssSelector("div#checkbox"));
        WebElement checkBoxInput = driver.findElement(By.cssSelector("input[type=checkbox]"));
        checkBoxInput.click();
        WebElement removeButton = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        removeButton.click();
        wait.until(ExpectedConditions.stalenessOf(checkBoxInput)); //or
        WebElement message = driver.findElement(By.cssSelector("p#message"));
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(message.getText(), "It's gone!");
        removeButton.click();
        WebElement message2 = driver.findElement(By.cssSelector("p#message"));//......?
        wait.until(ExpectedConditions.visibilityOf(message2));
        Assert.assertEquals(message2.getText(), "It's back!");

    }

    @Test
    public void acceptAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        //driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You successfully clicked an alert", result.getText());
    }

    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You clicked: Cancel", result.getText());
    }

    @Test
    public void promptAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Vesela");
        alert.accept();
        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You entered: Vesela", result.getText());
    }

    @Test
    public void newTabTest() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void nestedFramesTest() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftElement = driver.findElement(By.tagName("body"));
        leftElement.getText();
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

    @Test
    public void iFrameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textField = driver.findElement(By.cssSelector("body#tinymce"));
        textField.clear();
        textField.sendKeys("Text for test.");
        driver.switchTo().defaultContent();
    }
}







