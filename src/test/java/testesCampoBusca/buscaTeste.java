package testesCampoBusca;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    public void Dado_que_Insira_um_Nome_Registrado_no_Campo_de_Busca_e_Pressione_Buscar_os_Dados_Serao_Exibidos_na_Tabela(){
        //Preenche o formulario e submete o formulario
        paginaBusca.preencherFormulario("beltrano", "95904111362","11977051384","28/04/2002");
        paginaBusca.preencherFormulario("fill", "959333311362","1198232322","22/04/2002");

        //Realiza Busca Do Cadastro
        paginaBusca.buscarCadastro("beltrano");

        //Confere se os dados buscados estão presentes na tabela
        Assert.assertTrue(paginaBusca.confereSeOsDadosForamInseridosNaTabela("beltrano", "95904111362","11977051384","28/04/2002"));

        //Retorna os dados da tabela para o console
        paginaBusca.scrap();

        //Espera 3 segundos antes de realizar a proxima ação
        paginaBusca.esperar(3);
        //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
        paginaBusca.clear();
    }
        @Test
    public void Dado_que_o_Usuario_Pressione_obotaobuscarseminserirnenhumnomenaodeveraretornarnadanatabela(){
            //Busca pelo cadastro através do nome
            paginaBusca.buscarCadastro("claudinei");

            //verificar se os elementos de lista td:nth-child estao presente na pagina. (Caso false significa que não há nada na tabela).
            //Retornar falso
            Assert.assertFalse(paginaBusca.confereSeOElementoDaTabelaApareceNaPagina());

            //Espera 3 segundos antes de realizar a proxima ação
            paginaBusca.esperar(3);

            //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
            paginaBusca.clear();

        }

}