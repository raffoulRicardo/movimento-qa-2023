package testes.testesCadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormularioPage;
import suporte.Web;

public class CadastroUsuarioValidoTests {
    private WebDriver navegador;

    @Before
    public void setUp () {
        navegador = Web.createChrome();
        new FormularioPage(navegador)
                // Apagar registros antes de cada teste
                .apagarRegistros();
    }
    @Test
    public void cadastroUsuarioValidoTest() {
        new FormularioPage(navegador)
                // Cadastro de um usuário válido
                .cadastrarUsuario("Igor Carvalho Amaral","12345678910","71996759145","16/03/1998")
                // Validar se o usuário válido foi salvo com sucesso
                .validarTabela("Igor Carvalho Amaral 12345678910 71996759145 16/03/1998");
    }
    @After
    public void tearDown() {
                // Fechar o navegador
                navegador.quit();
    }
}




