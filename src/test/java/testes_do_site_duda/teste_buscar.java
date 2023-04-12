package testes_do_site_duda;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class teste_buscar {
    @Test
    public void botao2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mduda\\OneDrive\\Documentos\\driver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://localhost:8080");
        browser.findElement(By.id("nome")).sendKeys("Duda");
        browser.findElement(By.id("cpf")).sendKeys("24806791867");
        browser.findElement(By.id("dt-nascimento")).sendKeys("11/02/2005");
        browser.findElement(By.id("celular")).sendKeys("11994719889");
        browser.findElement(By.id("btn-salvar")).click();
        browser.navigate().refresh();

        browser.findElement(By.id("nome")).sendKeys("Pedro");
        browser.findElement(By.id("cpf")).sendKeys("99987645987");
        browser.findElement(By.id("dt-nascimento")).sendKeys("11/02/2015");
        browser.findElement(By.id("celular")).sendKeys("11994734567");
        browser.findElement(By.id("btn-salvar")).click();
        browser.navigate().refresh();

        browser.findElement(By.id("nome")).sendKeys("Júlia");
        browser.findElement(By.id("cpf")).sendKeys("00025499844");
        browser.findElement(By.id("dt-nascimento")).sendKeys("21/04/1998");
        browser.findElement(By.id("celular")).sendKeys("31992137787");
        browser.findElement(By.id("btn-salvar")).click();
        browser.navigate().refresh();

        browser.findElement(By.id("input-search")).sendKeys("Júlia");
        browser.findElement(By.id("btn-buscar")).click();
        browser.findElement(By.id("input-search")).clear();

        browser.findElement(By.id("input-search")).sendKeys("Duda");
        browser.findElement(By.id("btn-buscar")).click();
        browser.findElement(By.id("input-search")).clear();

        browser.findElement(By.id("input-search")).sendKeys("Pedro");
        browser.findElement(By.id("btn-buscar")).click();
        browser.findElement(By.id("input-search")).clear();

        


    }
}
