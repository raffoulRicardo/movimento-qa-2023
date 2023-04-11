package br.com.sumiko.testesaceitacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import static br.com.sumiko.testesaceitacao.DriverFactory.killDriver;

public class TesteDeBusca {
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
    public void deveBuscarNomeCadastrado() {
        page.setNome("Sumiko");
        page.setCPF("111.111.111-11");
        page.setCelular("(11)99999-9999");;
        page.setDataNascimento("13/11/1111");
        page.salvar();
        page.setNomeBusca("Sumiko");
        page.buscar();
    }
    public boolean isNomeBuscado(String nome) {
        WebElement linhaDaTabela = getDriver().findElement(By.cssSelector("#tabela-usuarios tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        return colunaNome.getText().equals(nome);
    }
}
