package Formulario;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class formularioTest {

          private formularioPage paginaForm;

            @BeforeEach
            public void beforeEach() {
                this.paginaForm = new formularioPage();
            }
            @AfterEach
            public void afterEach() {
            this.paginaForm.fechar();
            }
            //SEMPRE CHECAR SE A TABELA DO SITE NÃO CONTEM DADOS ANTES DE REALIZAR OS TESTES.
            //SE HOUVER DADOS NA TABELA UTILIZAR O BOTÃO EXCLUIR TODOS PARA EVITAR CONFLITO COM OS TESTES.
            @Test
            public void Dado_Que_o_Formulario_Seja_Preenchido_e_Submetido_os_Valores_Devem_ser_Exibidos_na_Tabela() {
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("fulano", "94904111641","11977051384","29/03/2004");
                //confere se os dados inseridos no formulario e submetido estão na tabela
                Assert.assertTrue(paginaForm.confereSeOsDadosForamInseridosNaTabela("fulano", "94904111641","11977051384","29/03/2004"));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }
            @Test
            public void Dado_Que_o_Formulario_Nao_Seja_Preenchido_e_Submtido_Deve_Exibir_Campos_Vazios_na_Tabela(){
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("", "","","");
                //Confere se a tabela está vazia
                Assert.assertTrue(paginaForm.confereSeOsDadosNaoForamInseridosNaTabela("", "","",""));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }
}

