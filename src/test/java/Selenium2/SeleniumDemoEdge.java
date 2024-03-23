package Selenium2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumDemoEdge extends MainDriverEdge {


    @Test
    public void getTitle() {
        String title = driver.getTitle();
        System.out.println("Result 1: " + title);
    }

    @Test
    public void findElement() {
        WebElement element = driver.findElement(By.id("my-text-id"));
    }

    @Test
    public void findFormSelect() {
        WebElement formSelect = driver.findElement(By.className("form-select"));
    }

    @Test
    public void findDataList() {
        WebElement dataList = driver.findElement(By.cssSelector("#my-check-1.form-check-input"));
    }




}



