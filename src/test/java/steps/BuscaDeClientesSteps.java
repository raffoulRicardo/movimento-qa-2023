package steps;

import baseTest.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BuscaDeClientesSteps {

    private WebDriver driver;
    public BaseTest baseTest = new BaseTest();

    @Given("que eu logue em localhost")
    public void queEuLogueEmLocalhost() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = baseTest.driver;
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }

    @And("eu inserir um cliente para ser buscado")
    public void euInserirUmClienteParaSerBuscado() {
        baseTest.preencherCorreto();
    }

    @And("clico no botao salvar")
    public void clicoNoBotaoSalvar() {
        driver.findElement(By.id("btn-salvar")).click();
    }

    @And("verifico se o cliente esta salvo")
    public void verificoSeOClienteEstaSalvo() {
        Assert.assertEquals("Cleverson Fernando", driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText());
        Assert.assertEquals("111.111.111-11", driver.findElement(By.xpath("//tbody/tr[last()]/td[2]")).getText());
        Assert.assertEquals("(19)111111111", driver.findElement(By.xpath("//tbody/tr[last()]/td[3]")).getText());
        Assert.assertEquals("11/11/2023", driver.findElement(By.xpath("//tbody/tr[last()]/td[4]")).getText());
    }

    @When("preencher o campo para busca com o nome completo do cliente cadastrado")
    public void preencherOCampoParaBuscaComONomeCompletoDoClienteCadastrado() {
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).sendKeys("Cleverson Fernando");

    }

    @And("clicar no botao buscar")
    public void clicarNoBotaoBuscar() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[2]/button[1]")).click();

    }

    //preencher o campo para busca com o nome de cliente diferente do cliente cadastrado
    @When("preencher o campo para busca com o nome de cliente diferente do cliente cadastrado")
    public void preencherOCampoParaBuscaComONomeDeClienteDiferenteDoClienteCadastrado() {
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).sendKeys("Pedro");
    }

    //preencher o campo para busca com o nome de cliente incompleto
    @When("preencher o campo para busca com o nome de cliente incompleto")
    public void preencherOCampoParaBuscaComONomeDeClienteIncompleto() {
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).sendKeys("Cleverson");
    }

    @Then("eu veja o cliente cadastrado na tabela")
    public void euVejaOClienteCadastradoNaTabela() throws IOException {
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        Assert.assertEquals("Cleverson Fernando", driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText());
        Assert.assertEquals("111.111.111-11", driver.findElement(By.xpath("//tbody/tr[last()]/td[2]")).getText());
        Assert.assertEquals("(19)111111111", driver.findElement(By.xpath("//tbody/tr[last()]/td[3]")).getText());
        Assert.assertEquals("11/11/2023", driver.findElement(By.xpath("//tbody/tr[last()]/td[4]")).getText());

        //E todos os campos devem ficar vazios
        baseTest.todosOsCamposVazios();
        baseTest.imprimirEvidencia(driver,"buscaComSucesso");
        driver.quit();
    }

    @Then("nao retorne nenhum cliente na tabela de cadastro")
    public void naoRetorneNenhumClienteNaTabelaDeCadastro() throws IOException {
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());

        //E todos os campos devem ficar vazios
        baseTest.todosOsCamposVazios();
        baseTest.imprimirEvidencia(driver,"BuscaFalhaNomeNaoCadastrado");
        driver.quit();
    }

    @Then("nao encontre nenhum cliente na tabela de cadastro")
    public void naoEncontreNenhumClienteNaTabelaDeCadastro() throws IOException{
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());

        //E todos os campos devem ficar vazios
        baseTest.todosOsCamposVazios();
        baseTest.imprimirEvidencia(driver,"BuscaFalhaNomeIncompleto");
        driver.quit();
    }
}
