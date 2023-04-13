package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroPage {
    public static final String URL_8080 = "http://localhost:8080/?";
    public WebDriver browser;

    public CadastroPage() {
        System.setProperty("web-driver.chrome.driver", "/path/to/chromedriver");
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_8080);
    }
    public void fechar() {
        this.browser.quit();
    }

    public void preencheFormulario(String nome, String cpf, String celular, String dtNascimento) {

        this.browser.findElement(By.id("nome")).clear();
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("cpf")).clear();
        this.browser.findElement(By.id("cpf")).sendKeys(cpf);
        this.browser.findElement(By.id("celular")).clear();
        this.browser.findElement(By.id("celular")).sendKeys(celular);
        this.browser.findElement(By.id("dt-nascimento")).clear();
        this.browser.findElement(By.id("dt-nascimento")).sendKeys(dtNascimento);
    }
    public void clicaSalvarFormulario() {
        this.browser.findElement(By.id("btn-salvar")).click();
    }

    public void excluirTodosUsuarios() {
        this.browser.findElement(By.id("excluirTodosUsuarios")).click();
    }

    public void buscaPorNome(String nome) {
        this.browser.findElement(By.id("input-search")).sendKeys(nome);
        this.browser.findElement(By.id("Botao_Buscar")).click();
    }

    public boolean validarCampoNome(String nome) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        return colunaNome.getText().equals(nome);
    }
    public boolean validarCampoCpf(String cpf) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement colunaCpf  = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        return colunaCpf.getText().equals(cpf);
    }
    public boolean validarCampoCelular(String celular) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement colunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        return colunaCelular.getText().equals(celular);
    }
    public boolean validarCampoDtNascimento(String dtNascimento) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr"));
        WebElement colunaDtNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return colunaDtNascimento.getText().equals(dtNascimento);
    }

}
