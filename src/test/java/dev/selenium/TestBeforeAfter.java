package dev.selenium;

import org.testng.annotations.BeforeMethod;

public class TestBeforeAfter {
    @BeforeMethod
    public void before() {
        System.out.println("BeforeMethod");
    }
}
