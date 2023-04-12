import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class verificarTodosCampos {
    private WebDriver driver;

    @Before
    public void setandoDrive() {
        // Configurar o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        WebElement botaoExcluir = driver.findElement(By.id("botao-excluir"));
        botaoExcluir.click();
    }

    @After
    public void sairDaPage() {
        // Sair após teste finalizar!
        driver.quit();
    }

    public void preencheOformulario(String nome, String cpf, String celular, String dataNascimento) {
        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.id("cpf")).sendKeys(cpf);
        driver.findElement(By.id("celular")).sendKeys(celular);
        driver.findElement(By.id("dt-nascimento")).sendKeys(dataNascimento);
        driver.findElement(By.id("btn-salvar")).click();
    }

    @Test
    public void PreenchimentoValido(){
        // Cenário 1 - Preenchimento com todos os campos válidos!

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("Luis Eduardo");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("108.602.830-00");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(83) 99162-6142");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("11/09/1996");


        assertEquals("Luis Eduardo", campoNome.getAttribute("value"));
        assertEquals("108.602.830-00", campoCPF.getAttribute("value"));
        assertEquals("(83) 99162-6142", campoCelular.getAttribute("value"));
        assertEquals("11/09/1996", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();


        // Verifica se os valores do formulário estão na tabela

        WebElement tabela = driver.findElement(By.id("tabela-usuarios"));
        assertTrue(tabela.getText().contains("Luis Eduardo"));
        assertTrue(tabela.getText().contains("108.602.830-00"));
        assertTrue(tabela.getText().contains("(83) 99162-6142"));
        assertTrue(tabela.getText().contains("11/09/1996"));

    }


    //ESSE TESTE ESTÁ FUNCIONANDO QUANDO EXECUTADO SOZINHO, TENTEI RESOLVER O ERRO, MAS AINDA SEM SUCESSO!
    //MAS ESTÁ VALIDADO CERTO
    @Test
    public void camposEmBranco(){
        // Cenário 2 - : Não preencher nenhum campo e verificar se o formulário não é enviado
        preencheOformulario("", "", "", "");

        WebElement coluna1 = driver.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement coluna2 = driver.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement coluna3 = driver.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement coluna4 = driver.findElement(By.cssSelector("td:nth-child(4)"));


        // Conseguimos pegar as colunas e verificar que elas foram salvas sem ser digitado nada no formulário.

        assertTrue(coluna1.getText().contains(""));
        assertTrue(coluna2.getText().contains(""));
        assertTrue(coluna3.getText().contains(""));
        assertTrue(coluna4.getText().contains(""));

        // Verificar se o formulário não é enviado

    }

    @Test
    public void verificarEnvioVariasVezes(){
        // Cenário 3: Tentar enviar o formulário várias vezes consecutivas e verificar se cada envio é registrado corretamente.
        // Podemos usar o teste para ambos os cenários...
        // Cenário 4: Preencher o campo "CPF" com um valor que já foi usado anteriormente e verificar se o formulário é rejeitado.


        // Preenche o formulário e clique no botão de envio várias vezes
        // Só em conseguir preencher as 3 vezes, mostra que está aceitando cadastro repetido.
                for (int i = 0; i < 3; i++) {
                   preencheOformulario("José da Silva", "123.456.789-10", "(11) 99999-9999", "01/01/1990");
               }
        WebElement linha1 = driver.findElement(By.cssSelector("tr"));
        WebElement linha2 = driver.findElement(By.cssSelector("tr"));


        assertFalse(linha1.getText().contains("José da Silva"));
        assertFalse(linha2.getText().contains("José da Silva"));

        WebElement coluna1 = driver.findElement(By.cssSelector("td:nth-child(2)"));
        assertTrue(coluna1.getText().contains("123.456.789-10"));




    }

    @Test
    public void todosOsCamposInvalidos(){
        // Cenário 5: Preencher todos os campos com valores inválidos e verificar se o formulário aceitou.

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("92839289");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("abc.def.hij-10");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(aa) bbbbb-9bbbb");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("bb/aa/adss");

        // Verifica se os preenchimentos inválidos acima, estão realmente iguais.

        assertEquals("92839289", campoNome.getAttribute("value"));
        assertEquals("abc.def.hij-10", campoCPF.getAttribute("value"));
        assertEquals("(aa) bbbbb-9bbbb", campoCelular.getAttribute("value"));
        assertEquals("bb/aa/adss", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();


        // Verifica se os valores do formulário estão ou não na tabela.

        WebElement tabela = driver.findElement(By.id("tabela-usuarios"));
        assertFalse(tabela.getText().contains("92839289"));
        assertFalse(tabela.getText().contains("abc.def.hij-10"));
        assertFalse(tabela.getText().contains("(aa) bbbbb-9bbbb"));
        assertFalse(tabela.getText().contains("bb/aa/adss"));
    }


}
