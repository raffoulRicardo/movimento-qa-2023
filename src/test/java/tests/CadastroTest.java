package tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.CadastroPage;

public class CadastroTest {
    private WebDriver browser;

    private CadastroPage paginaDeCadastro;
    @BeforeEach // sempre que iniciar vai passar por aqui primeiro
    public void iniciaAqui(){
        this.paginaDeCadastro = new CadastroPage();
    }
    @AfterEach
    public void finalizaAqui(){
        this.paginaDeCadastro.fechar();
    }
    @Test
    public void preencherCamposDadosValidosESalvar(){
        paginaDeCadastro.preencheFormulario("Pirulito Rex", "628.252.240-49", "(84) 99634-6633", "11/04/1954");
        paginaDeCadastro.clicaSalvarFormulario();

//        Assert.assertTrue(paginaDeCadastro.validarCampoNome("Pirulito Rex"));
//        Assert.assertTrue(paginaDeCadastro.validarCampoCpf("628.252.240-49"));
//        Assert.assertTrue(paginaDeCadastro.validarCampoCelular("(84) 99634-6633"));
//        Assert.assertTrue(paginaDeCadastro.validarCampoDtNascimento("11/04/1954"));

        paginaDeCadastro.fechar();
    }
//    @Test
//    public void BuscarPorNome(){
//        paginaDeCadastro.buscaPorNome("Tio do Sorvete");
//    }
}
