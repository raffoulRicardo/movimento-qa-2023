package Excluir;

import Busca.buscaPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class excluirTest {
    private excluirPage paginaExcluir;

    @BeforeEach
    public void beforeEach() {
        this.paginaExcluir = new excluirPage();
    }
    @AfterEach
    public void afterEach() {
        this.paginaExcluir.fechar();
    }
    @Test
    public void Dado_que_Tenha_Registros_na_Tabela_e_Pressione_o_Botao_Excluir_os_Registros_Deve_ser_Apagados(){
        //preenche o formulario e submete formulario
        paginaExcluir.preencherFormulario("sergio", "923929392392","1198773222","28/04/2020");

        //Conferir se os dados estão na tabela
        Assert.assertTrue(paginaExcluir.confereSeOsDadosForamInseridosNaTabela("sergio", "923929392392","1198773222","28/04/2020"));

        //excluir todos usuarios
        paginaExcluir.excluirUsuarios();

        //confere se o elemento da tabela não aparece na pagina
        Assert.assertFalse(paginaExcluir.confereSeOElementoDaTabelaNaoApareceNaPagina());

    }
}
