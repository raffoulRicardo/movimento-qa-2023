package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

}
