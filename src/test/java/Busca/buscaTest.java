package Busca;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class buscaTest {

    private buscaPage buscaPage;

    @BeforeEach
    public void beforeEach() {
        this.buscaPage = new buscaPage();
    }
    @AfterEach
    public void afterEach() {
        this.buscaPage.fechar();
    }
    //SEMPRE CHECAR SE A TABELA DO SITE NÃO CONTEM DADOS ANTES DE REALIZAR OS TESTE.
    //SE HOUVER DADOS NA TABELA UTILIZAR O BOTÃO EXCLUIR TODOS PARA EVITAR CONFLITO COM OS TESTES.
    @Test
    public void dadoQueInsiraUmNomeRegistradoNoCampoDeBuscaEPressioneBuscarOsDadosSeraoExibidosNaTabela(){
        //preenche o formulario e submete formulario
        buscaPage.preencherFormulario("beltrano", "95904111362","11977051384","28/04/2002");
        buscaPage.preencherFormulario("fill", "959333311362","1198232322","22/04/2002");
        //Realiza Busca Do Cadastro
        buscaPage.buscarCadastro("beltrano");
        //Confere se os dados que foram buscados estão na tabela
        Assert.assertTrue(buscaPage.confereSeOCadastroEstaNaTabela("beltrano", "95904111362","11977051384","28/04/2002"));
        //excluir todos usuarios para que não influencie no proximo teste
        buscaPage.excluirUsuarios();
    }
    @Test
    public void dadoQueInsiraUmNomeNãoRegistradoNoCampoDeBuscaEPressioneBuscarNadaSeraExibido() {
        //Busca pelo cadastro através do nome
        buscaPage.buscarCadastro("claudinei");
        //confere se o elemento da tabela não aparece na pagina
       Assert.assertFalse(buscaPage.confereSeOElementoDaTabelaNaoApareceNaPagina());
        //excluir todos usuarios para que não influencie no proximo teste
        buscaPage.excluirUsuarios();
    }
}