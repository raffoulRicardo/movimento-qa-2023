package br.com.bluesoft;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteBaseQATests {

    @Test
    public void testeCadastroUsuario() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navegando até a página de cadastro
        driver.get("http://localhost:8080/");

        // Preencher todos os campos do cadastro
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("João da Silva");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("123.456.789-00");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(11) 99999-9999");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("01/01/1990");

        // Clicar no botão para salvar os dados do usuário
        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        //tempo de espera
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
        }

       // Buscar por usuário pelo nome cadastrado
        WebElement campoBusca = driver.findElement(By.cssSelector(".btn:nth-child(2)"));
        campoBusca.sendKeys("João da Silva");
        WebElement botaoBuscar = driver.findElement(By.cssSelector(".btn:nth-child(2)"));
        botaoBuscar.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
        }



        // Clicando no botão para excluir todos os usuários cadastrados
        WebElement botaoExcluirTodos = driver.findElement(By.className("btn-danger"));
        botaoExcluirTodos.click();

        driver.quit();



    }

}