package br.com.bluesoft.metodos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Metodos {

    public WebDriver driver;

    public void iniciarNavegador (String site) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clicar (By elemento) {
        driver.findElement(elemento).click();
    }

    public void escrever(By elemento, String texto) {
        driver.findElement(elemento).sendKeys(texto);
    }

    public void validarTexto (By elemento, String textoEsperado) {
        String texto = driver.findElement(elemento).getText();
        assertEquals(textoEsperado, texto);
    }

    public void validarAtributo (By elemento, String atributo, String atributoEsperado) {
        String atributoRecebido = driver.findElement(elemento).getAttribute(atributo);
        assertEquals(atributoEsperado, atributoRecebido);
    }

    public void encerrarNavegador(WebDriver driver) {
        driver.quit();
    }
}
