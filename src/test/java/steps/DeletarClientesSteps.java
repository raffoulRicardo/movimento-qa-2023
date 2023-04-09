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

public class DeletarClientesSteps {
    private WebDriver driver;
    public BaseTest baseTest = new BaseTest();

    @Given("que eu esteja logado")
    public void queEuEstejaLogado() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = baseTest.driver;
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }

    @And("eu inserir um cliente para ser deletado")
    public void euInserirUmClienteParaSerDeletado() {
        baseTest.preencherCorreto();
        driver.findElement(By.id("btn-salvar")).click();
    }

    @And("verifico cliente salvo")
    public void verificoClienteSalvo() {
        Assert.assertEquals("Cleverson Fernando", driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText());
        Assert.assertEquals("111.111.111-11", driver.findElement(By.xpath("//tbody/tr[last()]/td[2]")).getText());
        Assert.assertEquals("(19)111111111", driver.findElement(By.xpath("//tbody/tr[last()]/td[3]")).getText());
        Assert.assertEquals("11/11/2023", driver.findElement(By.xpath("//tbody/tr[last()]/td[4]")).getText());
    }

    @When("eu clicar no botao excluir todos os usuarios")
    public void euClicarNoBotaoExcluirTodosOsUsuarios() {
        driver.findElement(By.xpath("//body[1]/div[1]/button[1]")).click();
    }

    @Then("a tabela de clientes cadastrados deve estar vazia")
    public void aTabelaDeClientesCadastradosDeveEstarVazia() throws IOException{
        Assert.assertEquals("", driver.findElement(By.xpath("//tbody")).getText());

        //E todos os campos devem ficar vazios
        baseTest.todosOsCamposVazios();
        baseTest.imprimirEvidencia(driver,"DeleteComSucesso");
        driver.quit();
    }
}
