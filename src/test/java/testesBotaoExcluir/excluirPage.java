package testesBotaoExcluir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class excluirPage {
    private static final String URL_PAGINA = "http://localhost:8080/";
    private WebDriver browser;
    public excluirPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_PAGINA);
    }

    //Preenche o formulario e o submete
    public void preencherFormulario(String nome, String cpf, String celular, String dataNascimento) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("cpf")).sendKeys(cpf);
        browser.findElement(By.id("celular")).sendKeys(celular);
        browser.findElement(By.id("dt-nascimento")).sendKeys(dataNascimento);
    }

    //Fecha a pagina
    public void fechar() {
        this.browser.quit();
    }

    //Confere se os elementos estão presentes na página
    public boolean confereSeOElementoDaTabelaApareceNaPagina() {
        try {
            WebElement primeiroTD = this.browser.findElement(By.cssSelector("td:nth-child(1)"));
            WebElement segundoTD = this.browser.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement terceiroTD = this.browser.findElement(By.cssSelector("td:nth-child(3)"));
            WebElement quartoTD = this.browser.findElement(By.cssSelector("td:nth-child(4)"));
            boolean elementoExiste = primeiroTD.isDisplayed();
            boolean elementoExiste2 = segundoTD.isDisplayed();
            boolean elementoExiste3 = terceiroTD.isDisplayed();
            boolean elementoExiste4 = quartoTD.isDisplayed();
            return elementoExiste && elementoExiste2 && elementoExiste3 && elementoExiste4;
        } catch (Exception e) {
            return false;
        }
    }

    //Maximixa o navegador
    public void maximixaTela() {
        this.browser.manage().window().maximize();
    }

    //Limpa a tabela de dados caso tenha algo lá.
    public boolean clear() {
        try {
            WebElement deleteButton = this.browser.findElement(By.id("btn_excluir"));
            WebElement primeiroTD = this.browser.findElement(By.cssSelector("td:nth-child(1)"));
            if (primeiroTD.isDisplayed()) {
                deleteButton.click();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Confere se os dados estão presente nas linhas da tabela
    public boolean confereSeOsDadosForamInseridosNaTabela(String nome, String cpf, String celular, String DataNascimento) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody "));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement ColunaCpf = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement ColunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement ColunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(nome) && ColunaCpf.getText().equals(cpf) && ColunaCelular.getText().equals(celular) && ColunaDataNascimento.getText().equals(DataNascimento);
    }

    //Espera antes de realizar a proxima ação
    public void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submeterFormulario() {
        browser.findElement(By.id("btn-salvar")).click();

    }
    //Confere se nome está presente na tabela
    public boolean confereNomeNaTabela(String nomeEsperado) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        return ColunaNome.getText().equals(nomeEsperado);
    }
    //Confere se cpf está presente na tabela
    public boolean confereCpfNaTabela(String cpfEsperado) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        return ColunaNome.getText().equals(cpfEsperado);
    }
    //Confere se celular está presente na tabela
    public boolean confereCelularNaTabela(String celularEsperado) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        return ColunaNome.getText().equals(celularEsperado);
    }
    //Confere se datadenascimento está presente na tabela
    public boolean confereDataNascimentoNaTabela(String dataEsperada) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(dataEsperada);
    }

}