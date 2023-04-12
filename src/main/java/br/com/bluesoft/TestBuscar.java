package br.com.bluesoft;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestBusca {
    private WebDriver driver;

    @Before
    public void setandoDrive() {
                System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");

    }

    @After
    public void sairDaPage() {
                driver.quit();
    }

    public boolean confereSeApareceNaPagina() {

        try {
            WebElement primeiroTD = driver.findElement(By.cssSelector("td:nth-child(1)"));
            boolean elementoExiste = primeiroTD.isDisplayed();
            return elementoExiste;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void buscandoUsuario(){
        // Cenário 1: Pesquisar usuário pelo primeiro nome e verificar se é possível localiza-lo.

        WebElement botaoExcluir = driver.findElement(By.id("botao-excluir"));
        botaoExcluir.click();

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("Vedole Loeas");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        WebElement campoPesquisa = driver.findElement(By.id("input-search"));
        campoPesquisa.sendKeys("Vedole");


        WebElement botaoBuscar = driver.findElement(By.id("buscar"));
        botaoBuscar.click();

         Assert.assertFalse(confereSeApareceNaPagina());
    }}
