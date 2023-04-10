package testesBotaoExcluir;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class excluirTeste {
    private testesBotaoExcluir.excluirPage paginaExcluir;

    //Tudo que acontece antes de iniciar os testes
    @BeforeEach
    public void beforeEach() {
        this.paginaExcluir = new excluirPage();
        paginaExcluir.maximixaTela();
    }

    //Tudo que acontece ao terminar os testes
    @AfterEach
    public void afterEach() {
        this.paginaExcluir.fechar();
    }

    //Testa se o botão excluir está funcionando corretamente
    @Test
    public void Dado_que_Tenha_Registros_na_Tabela_e_Pressione_o_Botao_Excluir_os_Registros_Deve_ser_Apagados(){
        //Preenche o formulario e o submete.
        paginaExcluir.preencherFormulario("tavio","94904111340","11982125633","29/03/2004");

        //Confere se os dados foram inseridos na tabela
        paginaExcluir.confereSeOsDadosForamInseridosNaTabela("tavio","94904111340","11982125633","29/03/2004");

        //Espera 3 segundos antes de realizar a proxima ação
        paginaExcluir.esperar(3);

        //Pressiona o botão de excluir todos os usuarios.
        paginaExcluir.clear();

        //verificar se os elementos de lista td:nth-child estao presente na pagina. (Caso false significa que não há nada na tabela).
        //Retornar falso
        Assert.assertFalse(paginaExcluir.confereSeOElementoDaTabelaApareceNaPagina());
    }

}
