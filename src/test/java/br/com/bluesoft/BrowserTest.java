package br.com.bluesoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BrowserTest {

    protected WebDriver edgeDriver;
    protected  WebDriver fireFoxDriver;
    protected WebDriver operaDriver;

    public BrowserTest(){
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.operadriver().setup();
    }

    @Test
    public void ValidateDisplayedFieldsEdge(){
        edgeDriver = new EdgeDriver();
        ValidateDisplayedFields(edgeDriver);
    }

    @Test
    public void ValidateDisplayedFieldsFirefox(){
        fireFoxDriver = new FirefoxDriver();
        ValidateDisplayedFields(fireFoxDriver);
    }

    @Test
    public void ValidateDisplayedFieldsOpera(){
        operaDriver = new OperaDriver();
        ValidateDisplayedFields(operaDriver);
    }

    private void ValidateDisplayedFields(WebDriver driver){
        driver.get("http://localhost:8080");
        Assert.assertTrue(driver.findElement(By.id("nome")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("cpf")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("celular")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("dt-nascimento")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("btn-salvar")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("input-search")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn:nth-child(2)")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn-danger")).isDisplayed());
        driver.quit();
    }

}
