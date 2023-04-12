import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FormularioTests {

    @Test
    public void dado_que_sejam_inseridas_informacoes_validas() {

        //Setup | Iniciando o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jessica\\Desktop\\chromedriver-config\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");

        //Arrange
        String inputNome = "Jesga de Oliveira";
        String inputCpf = "619.967.560-60";
        String inputCelular = "24969696969";
        String inputDtNasc = "16/06/1993";

        //Act
        //Insere informaçoes VALIDAS para cadastro
        driver.findElement(By.id("nome")).sendKeys(inputNome);
        driver.findElement(By.id("cpf")).sendKeys(inputCpf);
        driver.findElement(By.id("celular")).sendKeys(inputCelular);
        driver.findElement(By.id("dt-nascimento")).sendKeys(inputDtNasc);
        driver.findElement(By.id("btn-salvar")).click();

        //Assert
        //Verifica se o campo NOME foi preenchido corretamente
        String encontraInputNome = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]")).getText();
        assertEquals(encontraInputNome, inputNome);

        ////Verifica se o campo CPF foi preenchido corretamente
        String encontraInputCpf = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]")).getText();
        assertEquals(encontraInputCpf, inputCpf);

        //Verifica se o campo CELULAR foi preenchido corretamente
        String encontraInputCelular = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[3]")).getText();
        assertEquals(encontraInputCelular, inputCelular);

        //Verifica se o campo DATA DE NASCIMENTO foi preenchido corretamente
        String encontraInputDtNasc = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[4]")).getText();
        assertEquals(encontraInputDtNasc, inputDtNasc);

        //Verifica se a BUSCA encontra o nome e o exibe na tabela
        driver.findElement(By.id("input-search")).sendKeys(inputNome);
        driver.findElement(By.id("btn-buscar")).click();
        driver.navigate().refresh();
        String encontraInputNomeBuscar = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]")).getText();
        assertEquals(encontraInputNomeBuscar, inputNome);
        WebElement resultadoBusca = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td"));
        assertTrue(resultadoBusca.isDisplayed());

        //Aciona o botão EXCLUIR e verifica se o conteúdo da tabela foi excluído
            //Act
        driver.findElement(By.id("btn-excluir")).click();
        driver.navigate().refresh();
            //Assert
        String conferindoExclusao = driver.findElement(By.xpath("/html/body/div/table/tbody")).getText();
        assertEquals("", conferindoExclusao);

        //Encerra a aplicação
        driver.quit();
    }
}
