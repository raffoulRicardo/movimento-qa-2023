package br.com.sumiko.testesaceitacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import static br.com.sumiko.testesaceitacao.DriverFactory.killDriver;
public class TesteDeCadastro {
    private static TelaDeCadastroPage page;
    @Before
    public void inicializa() {
        getDriver().get("http://localhost:8080");
        page = new TelaDeCadastroPage();
    }

    @After
    public void finaliza() {
        killDriver();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Sumiko");
        page.setCPF("111.111.111-11");
        page.setCelular("(11)99999-9999");
        page.setDataNascimento("13/11/1111");
        page.salvar();
        String nome =page.obterValorCelulaNome();
        String CPF = page.obterValorCelulaCPF();
        String celular = page.obterValorCelulaCelular();
        String dataNascimento = page.obterValorCelulaDataNascimento();
        page.isCadastroInserido(nome, CPF, celular,dataNascimento);

    }

}
