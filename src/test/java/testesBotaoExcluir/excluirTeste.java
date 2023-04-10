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
        paginaExcluir.maximixatela();
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

        //Pressiona o botão de excluir todos os usuarios.
        paginaExcluir.excluirUsuarios();

        //verificar se os elementos de lista estao presente na pagina. (Caso positivo significa que há algo na tabela).
        Assert.assertFalse(paginaExcluir.confereSeOElementoDaTabelaApareceNaPagina());

    }
}
