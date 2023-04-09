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

public class CadastroDeClientesSteps {
    private WebDriver driver;
    public BaseTest baseTest = new BaseTest();

    @Given("que acesso o localhost")
    public void queAcessoOLocalhost() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = baseTest.driver;
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }

    @When("eu preencho todos os campos corretamente")
    public void euPreenchoTodosOsCamposCorretamente() {
        baseTest.preencherCorreto();
    }

    @And("clico em salvar")
    public void clicoEmSalvar() {
        driver.findElement(By.id("btn-salvar")).click();

    }

    @Then("eu vejo o cliente cadastrado na tabela")
    public void euVejoOClienteCadastradoNaTabela() throws IOException {
        Assert.assertEquals("Cleverson Fernando", driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText());
        Assert.assertEquals("111.111.111-11", driver.findElement(By.xpath("//tbody/tr[last()]/td[2]")).getText());
        Assert.assertEquals("(19)111111111", driver.findElement(By.xpath("//tbody/tr[last()]/td[3]")).getText());
        Assert.assertEquals("11/11/2023", driver.findElement(By.xpath("//tbody/tr[last()]/td[4]")).getText());

        //E todos os campos devem ficar vazios
        baseTest.todosOsCamposVazios();
        baseTest.imprimirEvidencia(driver,"CadastroComSucesso");
        driver.quit();
    }
}
