package br.com.sumiko.testesaceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import static br.com.sumiko.testesaceitacao.DriverFactory.killDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class TesteDeCadastro {

    private static TelaDeCadastroPage page;
    private static DSL dsl;



    @Before
    public void inicializa() {
        getDriver().get("http://localhost:8080");
        page = new TelaDeCadastroPage();
        dsl = new DSL();
    }

    @After
    public void finaliza() {
        killDriver();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Sumiko");
        page.setCPF("111.111.111-11");
        page.setCelular("(11)99999-9999");;
        page.setDataNascimento("13/11/1111");
        page.salvar();


    }
    public boolean isCadastroInserido(String nome, String CPF, String celular, String dataNascimento) {
        WebElement linhaDaTabela = getDriver().findElement(By.cssSelector("#tabela-usuarios tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaCPF = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement colunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));

        return colunaNome.getText().equals(nome)
                && colunaCPF.getText().equals(CPF)
                && colunaCelular.getText().equals(celular)
                && colunaDataNascimento.getText().equals(dataNascimento);
    }
}
