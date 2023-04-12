package br.com.bluesoft;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    public void findFieldsEdge(){
        edgeDriver = new EdgeDriver();
        findFields(edgeDriver);
    }

    @Test
    public void findFieldsFirefox(){
        fireFoxDriver = new FirefoxDriver();
        findFields(fireFoxDriver);
    }

    @Test
    public void findFieldsOpera(){
        operaDriver = new OperaDriver();
        findFields(operaDriver);
    }

    private void findFields(WebDriver driver){
        driver.get("http://localhost:8080");
        driver.findElement(By.id("nome"));
        driver.findElement(By.id("cpf"));
        driver.findElement(By.id("celular"));
        driver.findElement(By.id("dt-nascimento"));
        driver.findElement(By.id("btn-salvar"));
        driver.findElement(By.id("input-search"));
        driver.findElement(By.cssSelector(".btn:nth-child(2)"));
        driver.findElement(By.cssSelector(".btn-danger"));
        driver.quit();
    }

}
