package br.com.sumiko.testesaceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import br.com.sumiko.testesaceitacao.TelaDeCadastroPage;


public class TesteDeCadastro {
    private TelaDeCadastroPage page;
    private DSL dsl;

    @Before
    public void inicializa() {
        getDriver().get("http://localhost:8080");
        page = new TelaDeCadastroPage();
        dsl = new DSL();
    }

    @After
//	public void finaliza() {
//		killDriver();
//	}

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Sumiko");
        page.setCPF("111.111.111-11");
        page.setCelular("(11)99999-9999");;
        page.setDataNascimento("13/11/1111");
        page.salvar();

        Assert.assertEquals("Sumiko", page.obterNomeCadastro());
        Assert.assertEquals("111.111.111-11", page.obterCPFCadastro());
        Assert.assertEquals("(11)99999-9999", page.obterCelularCadastro());
        Assert.assertEquals("13/11/1111", page.obterDataNascimentoCadastro());
    }

}
