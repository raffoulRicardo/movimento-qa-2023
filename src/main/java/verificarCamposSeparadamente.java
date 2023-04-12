import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;




public class verificarCamposSeparadamente {


        private WebDriver driver;

        @Before
        public void setandoDrive() {
            // Configurar o driver do Chrome
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://localhost:8080");

            // Apagar todos os elementos que estão salvos antes de começar, para não atrapalhar nos testes.
            WebElement botaoExcluir = driver.findElement(By.id("botao-excluir"));
            botaoExcluir.click();
        }

        @After
        public void sairDaPage() {
            // Sair após teste finalizar!
               driver.quit();
        }





        @Test
        public void CampoNomeInva(){
            // Cenário 1: Preencher o campo de nome com caracteres inválidos, como números ou símbolos, e verificar se o formulário é enviado.

            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("123456");

            assertEquals("123456", campoNome.getAttribute("value"));

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            //Aqui passo o local nome na tabela
            WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(1)"));

            assertTrue(tabela.getText().contains("123456"));

            //
            // Verificar se o formulário é enviado, para que possar ser corrigido.
        }

        @Test
        public void verificarCpfInvalido(){
            // Cenário 2: Preencher o campo de CPF com um formato inválido, como "12345678910" ou "123.456.789/10" ou letras, e verificar se o formulário é enviado.


            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("Fulano de Tal");

            WebElement campoCPF = driver.findElement(By.id("cpf"));
            campoCPF.sendKeys("123.456.789/10"); // ou "12345678910" ou "123.456.789/10" ou aaa.aaa.aaa/10

            assertEquals("123.456.789/10", campoCPF.getAttribute("value"));

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            //Aqui passo o local cpf na tabela
            WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(2)"));
            assertTrue(tabela.getText().contains("123.456.789/10"));


            // Conseguimos verificar o campo está sendo salvo com preenchimentos incorretos

        }

        @Test
        public void verificarTelInvalido(){
            // Cenário 3: Preencher o campo de celular com um formato inválido, como "11999999999" ou "11-99999-9999" ou letras, e verificar se o formulário não é enviado.

            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("Fulano de Tal");

            WebElement campoCelular = driver.findElement(By.id("celular"));
            campoCelular.sendKeys("AA-AAAAA-AAAA"); // ou 11-99999-9999 ou AA-AAAAA-AAAA

            assertEquals("AA-AAAAA-AAAA", campoCelular.getAttribute("value"));

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(3)"));
            assertTrue(tabela.getText().contains("AA-AAAAA-AAAA"));


            // Conseguimos verificar o campo está sendo salvo com preenchimentos incorretos

        }

        @Test
        public void verificarDataNascInva(){

            // Cenário 4: Preencher o campo de data de nascimento com uma data inválida, como "31/02/1990" e verificar se o formulário é enviado.

            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("Fulano de Tal");

            WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
            campoDataNascimento.sendKeys("31/02/1990");

            assertEquals("31/02/1990", campoDataNascimento.getAttribute("value"));

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(4)"));
            assertFalse(tabela.getText().contains("31/02/1990"));

            // Verificar se o formulário está sendo salvado com datas inválidas, inexistentes no calendário.

        }

    @Test
    public void verificarDataFutura(){
        // Cenário 5: Preencher o campo de data de nascimento com uma data futura e verificar se o formulário é enviado.

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("Fulano de Tal");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("123.456.789-10");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(11) 99999-9999");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("01/01/2050");


        assertEquals("Fulano de Tal", campoNome.getAttribute("value"));
        assertEquals("123.456.789-10", campoCPF.getAttribute("value"));
        assertEquals("(11) 99999-9999", campoCelular.getAttribute("value"));
        assertEquals("01/01/2050", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();


        // Verifica se os valores foram salvados

        WebElement tabela = driver.findElement(By.id("tabela-usuarios"));
        assertTrue(tabela.getText().contains("Fulano de Tal"));
        assertTrue(tabela.getText().contains("123.456.789-10"));
        assertTrue(tabela.getText().contains("(11) 99999-9999"));
        assertTrue(tabela.getText().contains("01/01/2050"));

        // Neste teste podemos saber se o formulário está sendo salvo com uma data futura ( no caso, incorreta )


    }

    @Test
    public void verificarNomeExtenso(){
        // Cenário 6: Preencher o campo "nome" com um valor muito longo e verificar se o formulário é rejeitado.

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer malesuada mauris nec consectetur.");

        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer malesuada mauris nec consectetur.", campoNome.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(1)"));
        assertTrue(tabela.getText().contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer malesuada mauris nec consectetur."));

        // Dificilmente um nome terá esse tamanho, podendo haver essa verificação tb.
    }


    // OS TESTES ABAIXO É PARA VERIFICAR SE O FORMULARIO ESTA SENDO SALVO APENAS USANDO UM DOS CAMPOS

    @Test
    public void enviandoSomenteCampoNome(){
        // Cenário 7: Preencher somente o campo NOME e verificar se o fomulário é enviado.
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("José da Silva");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("");

        assertEquals("José da Silva", campoNome.getAttribute("value"));
        assertEquals("", campoCPF.getAttribute("value"));
        assertEquals("", campoCelular.getAttribute("value"));
        assertEquals("", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        // Aqui conseguimos saber se o formulário foi salvo apenas com o campo nome preenchido. Caso não, daria failed.
        WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(1)"));
        assertTrue(tabela.getText().contains("José da Silva"));

    }



    @Test
    public void enviandoSomenteCampoCpf(){
        // Cenário 8: Preencher somente o campo CPF e verificar se o fomulário é enviado.
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("109.222.999-00");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("");

        assertEquals("", campoNome.getAttribute("value"));
        assertEquals("109.222.999-00", campoCPF.getAttribute("value"));
        assertEquals("", campoCelular.getAttribute("value"));
        assertEquals("", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        // Aqui conseguimos saber se o formulário foi salvo apenas com o campo CPF preenchido. Caso não, daria failed.
        WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(2)"));
        assertTrue(tabela.getText().contains("109.222.999-00"));
    }


    @Test
    public void enviandoSomenteCampoCelular(){
        // Cenário 9: Preencher somente o campo CELULAR e verificar se o fomulário é enviado.

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(11) 99999-9999");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("");

        assertEquals("", campoNome.getAttribute("value"));
        assertEquals("", campoCPF.getAttribute("value"));
        assertEquals("(11) 99999-9999", campoCelular.getAttribute("value"));
        assertEquals("", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        // Aqui conseguimos saber se o formulário foi salvo apenas com o campo CELULAR preenchido. Caso não, daria failed.
        WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(3)"));
        assertTrue(tabela.getText().contains("(11) 99999-9999"));

    }
    @Test
    public void enviandoSomenteCampoDtNasci(){
        // Cenário 10: Preencher somente o campo DATA DE NASCIMENTO  e verificar se o fomulário é enviado.
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("11/09/1996");

        assertEquals("", campoNome.getAttribute("value"));
        assertEquals("", campoCPF.getAttribute("value"));
        assertEquals("", campoCelular.getAttribute("value"));
        assertEquals("11/09/1996", campoDataNascimento.getAttribute("value"));

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        // Aqui conseguimos saber se o formulário foi salvo apenas com o campo DATA DE NASCIMENTO preenchido. Caso não, daria failed.
        WebElement tabela = driver.findElement(By.cssSelector("td:nth-child(4)"));
        assertTrue(tabela.getText().contains("11/09/1996"));
    }


}


