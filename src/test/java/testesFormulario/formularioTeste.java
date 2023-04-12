package testesFormulario;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class formularioTeste {

          private formularioPage paginaForm;
            //Tudo que acontece antes de iniciar os testes
            @BeforeEach
            public void beforeEach() {
                this.paginaForm = new formularioPage();
                paginaForm.maximixaTela();
            }

            //Tudo que acontece ao terminar os testes
            @AfterEach
            public void afterEach() {
            this.paginaForm.fechar();
            }

            //Confere se ao efetuar registro com dados validos eles serão exibidos na tabela.
            @Test
            @Order(1)
            public void Dado_que_o_Formulario_Seja_Preenchido_e_Submetido_os_Dados_Devem_ser_Exibidos_na_Tabela() {
                //Preenche o formulario e submete o formulario
                paginaForm.preencherFormulario("Vinicius Samuel das Neves", "716.116.387-04","(69)98120-1604","08/01/1998");

                //Confere se os dados cadastrados estão inseridos na tabela
                Assert.assertTrue(paginaForm.confereSeOsDadosForamInseridosNaTabela("Vinicius Samuel das Neves", "716.116.387-04","(69)98120-1604","08/01/1998"));

                //Retorna os dados da tabela para o console
                paginaForm.scrap();

                //Espera 3 segundos antes de realizar a proxima ação
                paginaForm.esperar(3);

                //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
                paginaForm.clear();
            }


         //Teste se ao inserir uma data de nascimento invalida os dados não serão registrados na tabela.
         @Test
         @Order(2)
         public void Dado_que_o_Formulario_Seja_Preenchido_e_Submtido_Com_uma_Data_de_Nascimento_Invalida_nao_Deve_Exibir_Nada_na_Tabela(){
        //preenche o formulario e submete formulario
        paginaForm.preencherFormulario("Vinicius Samuel das Neves", "716.116.387-04","(69)98120-1604","29/50/1500");

        //verificar se os elementos de lista td:nth-child estao presente na pagina. (Caso false significa que não há nada na tabela).
        //Retornar falso
        Assert.assertFalse(paginaForm.confereSeOElementoDaTabelaApareceNaPagina());

        //Espera 3 segundos antes de realizar a proxima ação
        paginaForm.esperar(3);

        //verifica se há dados na tabela e caso positivo ele apaga para evitar conflito nos testes
        paginaForm.clear();
    }
}

