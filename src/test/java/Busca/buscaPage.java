package Busca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class buscaPage {

    private static final String URL_FORM = "http://localhost:8080/";

    private WebDriver browser;

    public buscaPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_FORM);
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

    public void excluirUsuarios() {
        browser.findElement(By.id("btn_excluir")).click();
    }

    public void buscarCadastro(String nome) {
        browser.findElement(By.id("input-search")).sendKeys(nome);
        browser.findElement(By.id("btn-buscar")).click();
    }

    public boolean confereSeOCadastroEstaNaTabela(String nome, String cpf, String celular, String DataNascimento) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody"));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement ColunaCpf = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement ColunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement ColunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(nome) && ColunaCpf.getText().equals(cpf) && ColunaCelular.getText().equals(celular) && ColunaDataNascimento.getText().equals(DataNascimento);
    }

    public boolean confereSeOElementoDaTabelaNaoApareceNaPagina() {
        boolean elementoPresente = false;
        try {
            WebElement elemento = this.browser.findElement(By.cssSelector("td:nth-child(1)"));
            elementoPresente = true;
        } catch (Exception e) {
            elementoPresente = false;

        }
        return elementoPresente;
    }

}

