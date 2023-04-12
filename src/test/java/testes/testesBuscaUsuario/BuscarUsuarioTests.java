package testes.testesBuscaUsuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormularioPage;
import suporte.Web;

public class BuscarUsuarioTests {
    private WebDriver navegador;
    @Before
    public void setUp() {
        navegador = Web.createChrome();
        new FormularioPage(navegador)
                // Apagar registros antes de cada teste
                .apagarRegistros()
                // Cadastrar um usuário válido para cada teste do botão de busca
                .cadastrarUsuario("Igor Carvalho Amaral", "12345678910","71996759145","16/03/1998");
    }
    @Test
    public void buscarUsuarioPorNomeCompletoTest() {
        new FormularioPage(navegador)
                .buscarUsuario("Igor Carvalho Amaral")
                // Validar se é possível buscar um usuário pelo nome completo
                .validarTabela("Igor Carvalho Amaral 12345678910 71996759145 16/03/1998");
    }
    @Test
    public void buscarUsuarioPorParteDoNomeTest() {
        new FormularioPage(navegador)
                .buscarUsuario("Amaral")
                // Verificar se é possível buscar um usuário por parte do nome (se falhar, a busca apenas pela parte do nome não acontece)
                .validarTabela("Igor Carvalho Amaral 12345678910 71996759145 16/03/1998");
    }
    @Test
    public void naoBuscarUsuarioPorCpfTest() {
        new FormularioPage(navegador)
                .buscarUsuario("12345678910")
                // Validar se não é possível buscar um usuário apenas pelo cpf
                .validarBusca("Nome CPF: Celular: Data de nascimento:");
    }
    @Test
    public void naoBuscarUsuarioPorCelularTest() {
        new FormularioPage(navegador)
                .buscarUsuario("71996759145")
                // Validar se não é possível buscar um usuário apenas pelo celular
                .validarBusca("Nome CPF: Celular: Data de nascimento:");
    }
    @Test
    public void naoBuscarUsuarioPorDataNascimentoTest() {
        new FormularioPage(navegador)
                .buscarUsuario("16/03/1998")
                // Validar se não é possível buscar um usuário apenas pela data de nascimento
                .validarBusca("Nome CPF: Celular: Data de nascimento:");
    }
    @After
    public void tearDown() {
                // Fechar o navegador
                navegador.quit();
    }
}
