import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verificarBusca {
    private WebDriver driver;

    @Before
    public void setandoDrive() {
        // Configurar o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");

    }

    @After
    public void sairDaPage() {
        // Sair após teste finalizar!
        driver.quit();
    }
    // Validacao do Cenario 1
    public boolean confereSeOElementoDaTabelaApareceNaPagina() {

        try {
            WebElement primeiroTD = driver.findElement(By.cssSelector("td:nth-child(1)"));
            boolean elementoExiste = primeiroTD.isDisplayed();
            return elementoExiste;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void pesquisandoUsuario(){
        // Cenário 1: Pesquisar usuário pelo primeiro nome e verificar se é possível localiza-lo.

        WebElement botaoExcluir = driver.findElement(By.id("botao-excluir"));
        botaoExcluir.click();

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("José da Silva");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        WebElement campoPesquisa = driver.findElement(By.id("input-search"));
        campoPesquisa.sendKeys("José");


        WebElement botaoBuscar = driver.findElement(By.id("buscar"));
        botaoBuscar.click();


        Assert.assertFalse(confereSeOElementoDaTabelaApareceNaPagina());
    }
}
