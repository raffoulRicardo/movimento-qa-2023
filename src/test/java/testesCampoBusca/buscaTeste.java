package testesCampoBusca;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class buscaTeste {
    private testesCampoBusca.buscaPage paginaBusca;
    //Tudo que acontece antes de iniciar os testes
    @BeforeEach
    public void beforeEach() {
        this.paginaBusca = new buscaPage();
        paginaBusca.maximixTela();
    }

    //Tudo que acontece ao terminar os testes
    @AfterEach
    public void afterEach() {
        this.paginaBusca.fechar();
    }

    //Confere se o campo de busca retorna os dados corretos ao pesquisar por um registro valido
    @Test
    @Order(1)
    public void Dado_que_Insira_um_Nome_Registrado_no_Campo_de_Busca_e_Pressione_Buscar_os_Dados_Serao_Exibidos_na_Tabela(){

        //Preenche o formulario e submete o formulario
        paginaBusca.preencherFormulario("Thiago Felipe Bento Farias", "312.278.644-34","(88)98986-3209","10/02/1948");
        paginaBusca.preencherFormulario("Cauê Ruan Rodrigues", "041.973.930-08","(61)99449-8326","06/04/1974");

        //Realiza Busca Do Cadastro
        paginaBusca.buscarCadastro("Thiago Felipe Bento Farias");

        //Confere se os dados buscados estão presentes na tabela
        Assert.assertTrue(paginaBusca.confereSeOsDadosForamInseridosNaTabela("Thiago Felipe Bento Farias", "312.278.644-34","(88)98986-3209","10/02/1948"));

        //Retorna os dados da tabela para o console
        paginaBusca.scrap();

        //Espera 3 segundos antes de realizar a proxima ação
        paginaBusca.esperar(3);
        //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
        paginaBusca.clear();
    }

        //Confere se não retornara nada caso o usuario pressione buscar sem preencher o campo de busca com um nome
        @Test
        @Order(2)
        public void Dado_que_o_Usuario_Pressione_o_Botao_Buscar_sem_Inserir_Nenhum_Nome_nao_Devera_Retornar_Nada_Na_Tabela(){
            //Busca pelo cadastro através do nome
            paginaBusca.buscarCadastro("Daniel Enrico Costa");

            //verificar se os elementos de lista td:nth-child estao presente na pagina. (Caso false significa que não há nada na tabela).
            //Retornar falso
            Assert.assertFalse(paginaBusca.confereSeOElementoDaTabelaApareceNaPagina());

            //Espera 3 segundos antes de realizar a proxima ação
            paginaBusca.esperar(3);

            //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
            paginaBusca.clear();

        }

}