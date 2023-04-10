import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class verificarCamposSeparadamente {


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
            // driver.quit();
        }



        @Test
        public void CampoNomeInva(){
            // Cenário 1: Preencher o campo de nome com caracteres inválidos, como números ou símbolos, e verificar se o formulário não é enviado.

            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.clear();
            campoNome.sendKeys("123456");

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            // Ambos conseguem ser enviado, tanto com o campo Nome em branco, como com números.
            // Verificar se o formulário não é enviado - ao contrário, precisa ser ajeitado.
        }

        @Test
        public void verificarCpfInvalido(){
            // Cenário 2: Preencher o campo de CPF com um formato inválido, como "12345678910" ou "123.456.789/10" ou enviar em branco, e verificar se o formulário não é enviado.


            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("Fulano de Tal");

            WebElement campoCPF = driver.findElement(By.id("cpf"));
            campoCPF.clear();// Podemos ver nesse mesmo cenário se podemos enviar em branco o fomulário.
            campoCPF.sendKeys("123.456.789/10"); // ou "12345678910"


            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            // Verificar se o formulário não é enviado

        }

        @Test
        public void verificarTelInvalido(){
            // Cenário 3: Preencher o campo de celular com um formato inválido, como "11999999999" ou "11-99999-9999", e verificar se o formulário não é enviado.

            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("Fulano de Tal");

            WebElement campoCelular = driver.findElement(By.id("celular"));

            campoCelular.clear();
            campoCelular.sendKeys("11999999999"); // ou 11-99999-9999

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();

            // Verificar se o formulário não é enviado

        }

        @Test
        public void verificarDataNascInva(){

            // Cenário 4: Preencher o campo de data de nascimento com uma data inválida, como "31/02/1990" ou "01/13/1990", e verificar se o formulário não é enviado.

            WebElement campoNome = driver.findElement(By.id("nome"));
            campoNome.sendKeys("Fulano de Tal");

            WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
            campoDataNascimento.clear();
            campoDataNascimento.sendKeys("01/13/1990");

            WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
            botaoSalvar.click();
            // Verificar se o formulário não é enviado

        }

    @Test
    public void verificarDataFutura(){
        // Cenário 5: Preencher o campo de data de nascimento com uma data futura e verificar se o formulário não é enviado.

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("Fulano de Tal");

        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("123.456.789-10");

        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(11) 99999-9999");

        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("01/01/2050");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        // Verificar se é enviado


    }

    @Test
    public void verificarNomeExtenso(){
        // Cenário 6: Preencher o campo "nome" com um valor muito longo e verificar se o formulário é rejeitado.

        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer malesuada mauris nec consectetur.");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

        // Dificilmente um nome terá esse tamanho, podendo haver essa verificação tb.
    }


    @Test
    public void enviandoSomenteCampoNome(){
        // Cenário 7: Preencher somente o campo NOME e verificar se o fomulário é enviado.
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys("José da Silva");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

    }
    @Test
    public void enviandoSomenteCampoCpf(){
        // Cenário 8: Preencher somente o campo CPF e verificar se o fomulário é enviado.
        WebElement campoCPF = driver.findElement(By.id("cpf"));
        campoCPF.sendKeys("123.456.789-10");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();
    }
    @Test
    public void enviandoSomenteCampoCelular(){
        // Cenário 9: Preencher somente o campo CELULAR e verificar se o fomulário é enviado.
        WebElement campoCelular = driver.findElement(By.id("celular"));
        campoCelular.sendKeys("(11) 99999-9999");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();

    }
    @Test
    public void enviandoSomenteCampoDtNasci(){
        // Cenário 10: Preencher somente o campo DATA DE NASCIMENTO  e verificar se o fomulário é enviado.
        WebElement campoDataNascimento = driver.findElement(By.id("dt-nascimento"));
        campoDataNascimento.sendKeys("01/01/1990");

        WebElement botaoSalvar = driver.findElement(By.id("btn-salvar"));
        botaoSalvar.click();
    }


}


