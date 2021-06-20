package org.fasttrackit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getDriver(String browser){
        WebDriver driver;

        switch (browser){
            default:
                System.out.println("Using default browser: Chrome");
            case "chrome":
                System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", AppConfig.getGeckoDriverPath());
                driver = new FirefoxDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", AppConfig.getOperaDriverPath());
                driver = new OperaDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}
