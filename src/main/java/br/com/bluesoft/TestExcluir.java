package br.com.bluesoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;


class testExcluir {

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

    public boolean verificaSeFoiInseridoNaTabela(String nome, String cpf, String celular, String DataNascimento) {
        WebElement linhaDaTabela = driver.findElement(By.cssSelector("#tabela-usuarios tbody "));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement ColunaCpf = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement ColunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement ColunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(nome) && ColunaCpf.getText().equals(cpf) && ColunaCelular.getText().equals(celular) && ColunaDataNascimento.getText().equals(DataNascimento);
    }

    //Testa se o botão excluir está funcionando corretamente, caso tenha registros na tabela
    @Test
    public void verificarBotaoExcluir(){
        //Preenche o formulario e o submete.
        preencheOformulario("Vedole Loeas","331.535.470-76","11 40638460","25/01/1956");

        //Confere se os dados foram inseridos na tabela
        verificaSeFoiInseridoNaTabela("Vedole Loeas","331.535.470-76","11 40638460","25/01/1956");

        WebElement botaoExluir = driver.findElement(By.id("botao-excluir"));
        botaoExluir.click();

        //verificar se os elementos de lista tabela-usuarios estao presente na pagina. (Caso false significa que não há nada na tabela).
        //Retornar falso
        WebElement tabela = driver.findElement(By.id("tabela-usuarios"));
        assertFalse(tabela.getText().contains("Vedole Loeas"));
        assertFalse(tabela.getText().contains("331.535.470-76"));
        assertFalse(tabela.getText().contains("11 40638460"));
        assertFalse(tabela.getText().contains("25/01/1956"));
    }
}