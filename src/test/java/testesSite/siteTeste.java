package testesSite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class siteTeste {

    private sitePage paginaSite;

    //Tudo que acontece antes de iniciar os testes
    @BeforeEach
    public void beforeEach() {
        this.paginaSite = new sitePage();
        paginaSite.maximixaTela();
    }

    //Tudo que acontece ao terminar os testes
    @AfterEach
    public void afterEach() {
        this.paginaSite.fechar();
    }
    //Verifica se ao dar refresh na pagina os dados permanecem
    @Test
    public void dado_Que_O_usuario_efetue_um_cadastro_e_recarregue_a_pagina_os_dados_deverao_permanecer_na_tabela (){
     //Preenche o formulario e submete o formulario
    paginaSite.preencherFormulario("gabriel","94904111324","119772382922","29/03/2001");

    //Recarrega a pagina 10x
    paginaSite.RecarregarPagina();

    //Confere se os dados permanecem na tabela
    paginaSite.confereSeOsDadosForamInseridosNaTabela("gabriel","94904111324","119772382922","29/03/2001");

    //Retorna os dados da tabela para o console
    paginaSite.scrap();

    //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
    paginaSite.clear();
    }
}