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
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("fulano", "94904111641","11977051384","29/03/2004");
                //confere se os dados inseridos no formulario e submetido estão na tabela
                Assert.assertTrue(paginaForm.confereSeOsDadosForamInseridosNaTabela("fulano", "94904111641","11977051384","29/03/2004"));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }
            @Test
            public void dadoQueOFormularioNaoSejaPreenchidoESubmtidoDeveExibirCamposVaziosNaTabela(){
                //Confere se a tabela está vazia
                Assert.assertTrue(paginaForm.confereSeOsDadosNaoForamInseridosNaTabela("", "","",""));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }

            @Test
            public void dadoQueInsiraUmNomeValidoNoCampoDeBuscaEPressioneBuscarOsDadosSeraoExibidosNaTabela(){
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("fulano", "94904111641","11977051384","29/03/2004");
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("beltrano", "95904111362","11977051384","28/04/2002");
                //preenche o formulario e submete formulario
                paginaForm.preencherFormulario("ciclano", "964111320002","11977051384","29/01/2001");
                //Realiza Busca Do Cadastro
                paginaForm.buscarCadastro("beltrano");
                //Confere se os dados que foram buscados estão na tabela
                Assert.assertTrue(paginaForm.confereSeOCadastroEstaNaTabela("beltrano", "95904111362","11977051384","28/04/2002"));
                //excluir todos usuarios para que não influencie no proximo teste
                paginaForm.excluirUsuarios();
            }
}

