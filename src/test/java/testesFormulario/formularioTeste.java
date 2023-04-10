package testesFormulario;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class formularioTeste {

          private formularioPage paginaForm;
            //Tudo que acontece antes de iniciar os testes
            @BeforeEach
            public void beforeEach() {
                this.paginaForm = new formularioPage();
                paginaForm.maximixatela();
            }

            //Tudo que acontece ao terminar os testes
            @AfterEach
            public void afterEach() {
            this.paginaForm.fechar();
            }

            //Confere se ao efetuar um registro com dados validos eles serão exibidos na tabela.
            @Test
            public void Dado_que_o_Formulario_Seja_Preenchido_e_Submetido_os_Valores_Devem_ser_Exibidos_na_Tabela() {
                //Preenche o formulario e submete o formulario
                paginaForm.preencherFormulario("fulano", "94904111641","11977051384","29/03/2004");

                //Confere se os dados cadastrados estão inseridos na tabela
                Assert.assertTrue(paginaForm.confereSeOsDadosForamInseridosNaTabela("fulano", "94904111641","11977051384","29/03/2004"));

                //excluir todos usuarios para não influenciar no proximo teste
                paginaForm.excluirUsuarios();
            }

            //Confere se ao efetuar um registro sem preencher o formulario é exibido strings vazias na tabela de dados.
            @Test
            public void Dado_que_o_Formulario_nao_Seja_Preenchido_e_Submtido_Deve_Exibir_Campos_Vazios_na_Tabela(){
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("", "","","");

                //Confere se a tabela está vazia
                Assert.assertTrue(paginaForm.confereSeOsDadosNaoForamInseridosNaTabela("", "","",""));

                //excluir todos usuarios para não influenciar no proximo teste
                paginaForm.excluirUsuarios();
            }

    @Test
    public void Dado_que_o_Formulario_Seja_Preenchido_e_Submtido_Com_uma_Data_de_Nascimento_Invalida_Nao_Deve_Exibir_Nada_na_Tabela(){
        //preenche o formulario e submete formulario
        paginaForm.preencherFormulario("claudinho", "94904111641","11977051384","29/50/1500");

        //confere se o elemento da tabela não aparece na página
        Assert.assertFalse(paginaForm.confereSeOElementoDaTabelaApareceNaPagina());
    }
}

