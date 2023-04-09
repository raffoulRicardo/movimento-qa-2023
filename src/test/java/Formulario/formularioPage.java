package Formulario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class formularioPage {

    private static final String URL_PAGINA = "http://localhost:8080/";

    private WebDriver browser;

    public formularioPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_PAGINA);
    }
    public void preencherFormulario(String nome, String cpf, String celular, String dataNascimento) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("cpf")).sendKeys(cpf);
        browser.findElement(By.id("celular")).sendKeys(celular);
        browser.findElement(By.id("dt-nascimento")).sendKeys(dataNascimento);
        browser.findElement(By.id("btn-salvar")).click();
    }

    public void fechar() {
        this.browser.quit();
    }

    public void redirecionaParaPaginaConsulta() {
        browser.findElement(By.id("consulta")).click();
    }

    public boolean confereSeOsDadosForamInseridosNaTabela(String nome, String cpf, String celular, String DataNascimento) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement ColunaCpf = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement ColunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement ColunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(nome) && ColunaCpf.getText().equals(cpf) && ColunaCelular.getText().equals(celular) && ColunaDataNascimento.getText().equals(DataNascimento);
    }

    public void excluirUsuarios() {
        browser.findElement(By.id("btn_excluir")).click();
    }

    public boolean confereSeOsDadosNaoForamInseridosNaTabela(String vazio, String vazio1, String vazio2, String vazio3) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement ColunaCpf = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement ColunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement ColunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(vazio) && ColunaCpf.getText().equals(vazio1) && ColunaCelular.getText().equals(vazio2) && ColunaDataNascimento.getText().equals(vazio3);


    }


    public void maximixatela() {

        this.browser.manage().window().maximize();


    }

}
