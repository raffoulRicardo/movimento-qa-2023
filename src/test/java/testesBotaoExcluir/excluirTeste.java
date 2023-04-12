package testesBotaoExcluir;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class excluirTeste {
    private testesBotaoExcluir.excluirPage paginaExcluir;
    //Tudo que acontece antes de iniciar os testes.
    @BeforeEach
    public void beforeEach() {
        this.paginaExcluir = new excluirPage();
        paginaExcluir.maximixaTela();
    }

    //Tudo que acontece ao terminar os testes.
    @AfterEach
    public void afterEach() {
        this.paginaExcluir.fechar();
    }

    //Testa se o botão excluir está funcionando corretamente.
    @Test
    public void Dado_que_Tenha_Registros_na_Tabela_e_Pressione_o_Botao_Excluir_os_Registros_Devem_ser_Apagados(){
        //Preenche o formulario e o submete.
        paginaExcluir.preencherFormulario("Emanuel Juan Drumond","982.527.067-54","(71)98638-0592","10/02/1943");

        //Submete o formulario
        paginaExcluir.submeterFormulario();

        //Confere se os dados estão presentes na tabela
        Assert.assertTrue(paginaExcluir.confereNomeNaTabela("Emanuel Juan Drumond"));
        Assert.assertTrue(paginaExcluir.confereCpfNaTabela("982.527.067-54"));
        Assert.assertTrue(paginaExcluir.confereCelularNaTabela("(71)98638-0592"));
        Assert.assertTrue(paginaExcluir.confereDataNascimentoNaTabela("10/02/1943"));

        //Espera 3 segundos antes de realizar a proxima ação.
        paginaExcluir.esperar(3);

        //Pressiona o botão de excluir todos os usuarios.
        paginaExcluir.clear();

        //verificar se os elementos de lista td:nth-child estao presente na pagina. (Caso false significa que não há nada na tabela).
        //Retornar falso
        Assert.assertFalse(paginaExcluir.confereSeOElementoDaTabelaApareceNaPagina());

        //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes.
        paginaExcluir.clear();
    }

}
