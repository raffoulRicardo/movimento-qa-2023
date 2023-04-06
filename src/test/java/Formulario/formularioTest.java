package Formulario;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
            public void deveriaEfetuarRegistroComDadosValidos() {
                //preenche o formulario
                paginaForm.preencherFormulario("fulano", "94904111641","11977051384","29/03/2004");

                //pressiona o botao para efetuar o registro
                paginaForm.efetuarRegistro();

                //confere se os dados inseridos no formulario estão na tabela
                Assert.assertTrue(paginaForm.confereSeOsDadosForamInseridosNaTabela("fulano", "94904111641","11977051384","29/03/2004"));
            }

}

