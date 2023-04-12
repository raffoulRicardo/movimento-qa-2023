package testesSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
    public void Dado_Que_o_Usuario_Efetue_um_Cadastro_e_Recarregue_a_Pagina_os_Dados_Deverao_Permanecer_na_Tabela (){
     //Preenche o formulario e submete o formulario
    paginaSite.preencherFormulario("Gabriela Antônia Teixeira","062.705.378-51","(67)98617-2784","29/03/2001");

    //Recarrega a pagina 10x
    paginaSite.RecarregarPagina();

    //Confere se os dados permanecem na tabela
    paginaSite.confereSeOsDadosForamInseridosNaTabela("Gabriela Antônia Teixeira","062.705.378-51","(67)98617-2784","29/03/2001");

    //Retorna os dados da tabela para o console
    paginaSite.scrap();

    //Espera 3 segundos antes de realizar a proxima ação
    paginaSite.esperar(3);

    //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
    paginaSite.clear();
    }
}
