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
        paginaExcluir.maximixatela();
    }

    @Test
    public void Dado_que_Tenha_Registros_na_Tabela_e_Pressione_o_Botao_Excluir_os_Registros_Deve_ser_Apagados(){
        //preenche o formulario e submete formulario
        paginaExcluir.preencherFormulario("tavio","94904111340","11982125633","29/03/2004");
        //excluir todos os usuarios
        paginaExcluir.excluirUsuarios();
        //verificar se os elementos de lista estao presente na pagina
        Assert.assertFalse(paginaExcluir.confereSeOElementoDaTabelaNaoApareceNaPagina());
    }
}
