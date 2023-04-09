package Busca;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class buscaTest {

    private buscaPage paginaBusca;

    @BeforeEach
    public void beforeEach() {
        this.paginaBusca = new buscaPage();
        paginaBusca.maximixatela();

    }
    @AfterEach
    public void afterEach() {
        this.paginaBusca.fechar();
    }
    //SEMPRE CHECAR SE A TABELA DO SITE CONTEM DADOS ANTES DE REALIZAR OS TESTE.
    //SE HOUVER DADOS NA TABELA UTILIZAR O BOTÃO EXCLUIR TODOS PARA EVITAR CONFLITO COM OS TESTES.
    @Test
    public void Dado_que_Insira_um_Nome_Registrado_no_Campo_de_Busca_e_Pressione_Buscar_os_Dados_Serao_Exibidos_na_Tabela(){
        //preenche o formulario e submete formulario
        paginaBusca.preencherFormulario("beltrano", "95904111362","11977051384","28/04/2002");
        paginaBusca.preencherFormulario("fill", "959333311362","1198232322","22/04/2002");

        //Realiza Busca Do Cadastro
        paginaBusca.buscarCadastro("beltrano");

        //Confere se os dados que foram buscados estão na tabela
        Assert.assertTrue(paginaBusca.confereSeOsDadosForamInseridosNaTabela("beltrano", "95904111362","11977051384","28/04/2002"));

        //excluir todos usuarios para que não influencie no proximo teste
        paginaBusca.excluirUsuarios();
    }
    @Test
    public void Dado_que_Insira_um_Nome_nao_Registrado_no_Campo_de_Busca_e_Pressione_Buscar_Nada_Sera_Exibido() {
        //Busca pelo cadastro através do nome
        paginaBusca.buscarCadastro("claudinei");

        //confere se o elemento da tabela não aparece na pagina
        Assert.assertFalse(paginaBusca.confereSeOElementoDaTabelaNaoApareceNaPagina());

        //excluir todos usuarios para que não influencie no proximo teste
        paginaBusca.excluirUsuarios();
    }

}