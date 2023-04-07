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

            @Test
            public void dadoQueOFormularioSejaPreenchidoESubmetidoOsValoresDevemSerExibidosNaTabela() {
                //preenche o formulario
                paginaForm.preencherFormulario("fulano", "94904111641","11977051384","29/03/2004");
                //efetua o registro
                paginaForm.efetuarRegistro();
                //confere se os dados inseridos no formulario e submetido estão na tabela
                Assert.assertTrue(paginaForm.confereSeOsDadosForamInseridosNaTabela("fulano", "94904111641","11977051384","29/03/2004"));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }
            @Test
            public void dadoQueOFormularioNaoSejaPreenchidoESubmtidoDeveExibirCamposVaziosNaTabela(){
                //efetua o registro
                paginaForm.efetuarRegistro();
                //Confere se a tabela está vazia
                Assert.assertTrue(paginaForm.confereSeOsDadosNaoForamInseridosNaTabela("", "","",""));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }
            
}

