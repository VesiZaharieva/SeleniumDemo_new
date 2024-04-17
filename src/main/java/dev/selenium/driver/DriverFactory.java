package dev.selenium.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Map;

public class DriverFactory {
    private static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<>(); //хранилище-пази инстанциите на уебдрайвърите за многонишкото едновременно тестване

    public static WebDriver getDriver(){
        return tlDriver.get();  //взимаме драйвъра
    }

    public static void setChromeDriver(int wait){
        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5"); //Симулира работа на мобилно устройство

        ChromeOptions options = new ChromeOptions(); // има options за всеки отделен браузер
        options.addArguments("--ignore-sertificate-errors"); // по този начин се изгнорират грешки от сертификати
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS); // да отказва Alerts
        options.setExperimentalOption("mobileEmulation", mobileEmulation); // симулира екран на моб.у-во

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        tlDriver.set(driver); //добавя този драйвър в хранилището

    }
    public static void setFirefoxDriver(int wait){
        FirefoxOptions  options = new FirefoxOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        tlDriver.set(driver);
    }
    public static void quitDriver() {
        if(tlDriver.get() != null){
            tlDriver.get().quit();
            tlDriver.remove(); //премахваме от хранилището да освобождаваме памет
        }
    }
}
