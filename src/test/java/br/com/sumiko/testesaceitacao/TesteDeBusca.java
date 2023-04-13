package br.com.sumiko.testesaceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import static br.com.sumiko.testesaceitacao.DriverFactory.killDriver;



@RunWith(Parameterized.class)
public class TesteDeBusca {
    private static TelaDeCadastroPage page;
    @Parameterized.Parameter
    public String nome;
    @Parameterized.Parameter(value = 1)
    public String cpf;
    @Parameterized.Parameter(value = 2)
    public String celular;
    @Parameterized.Parameter(value = 3)
    public String dataNascimento;

    @Before
    public void inicializa() {
        getDriver().get("http://localhost:8080");
        page = new TelaDeCadastroPage();
    }

    @After
    public void finaliza() {
        killDriver();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][] {
                {"ana paula sumiko","123.456.789-99","(11)9.8998-0234","18/11/1985",}

        });
    }

    @Test
    public void deveValidarDadosInseridos() {
        page.setNome(nome);
        page.setCPF(cpf);
        page.setCelular(celular);
        page.setDataNascimento(dataNascimento);
        page.salvar();
        page.escrever("input-search", nome);
        page.buscar();
        Assert.assertEquals(nome, page.obterValorCelulaNome());
        Assert.assertEquals(cpf, page.obterValorCelulaCPF());
        Assert.assertEquals(celular, page.obterValorCelulaCelular());
        Assert.assertEquals(dataNascimento, page.obterValorCelulaDataNascimento());

    }
}


