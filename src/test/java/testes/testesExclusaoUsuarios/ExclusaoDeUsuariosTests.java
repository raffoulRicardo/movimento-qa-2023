package testes.testesExclusaoUsuarios;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormularioPage;
import suporte.Web;

public class ExclusaoDeUsuariosTests {
    private WebDriver navegador;
    @Before
    public void setUp () {
        navegador = Web.createChrome();
        new FormularioPage(navegador)
                // Apagar registros antes de cada teste
                .apagarRegistros()
                // Cadastrar um usuário válido para o teste
                .cadastrarUsuario("Igor Carvalho Amaral", "12345678910","71996759145","16/03/1998");
        }
    @Test
    public void excluirTodosUsuarios() {
        new FormularioPage(navegador)
                // Excluir Todos os Usuários
                .apagarRegistros()
                // Verificar se o registro do usuário cadastrado foi excluído
                .validarRegistro("Igor Carvalho Amaral 12345678910 71996759145 16/03/1998");
    }
    @After
    public void tearDown() {
                // Fechar o navegador
                navegador.quit();
    }
}
