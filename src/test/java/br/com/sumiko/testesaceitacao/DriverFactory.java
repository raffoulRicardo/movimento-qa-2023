package br.com.sumiko.testesaceitacao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@NoArgsConstructor
public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }
        return driver;
    }

    public static void killDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
