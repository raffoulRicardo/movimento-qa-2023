package testes.testesCadastro;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormularioPage;
import suporte.Web;

public class CadastroUsuarioInvalidoTests {
    private WebDriver navegador;

    @Before
    public void setUp () {
        navegador = Web.createChrome();
        new FormularioPage(navegador)
                // Apagar registros antes de cada teste
                .apagarRegistros();
    }

    @Test
    public void naoCadastrarNomeInvalidoTest() {
        new FormularioPage(navegador)
                // Cadastro de usuário com nome inválido
                .cadastrarUsuario("123456", "12345678910","71996759145","16/03/1998")
                // Validar se o usuário com nome inválido não foi salvo (se falhar, o usuário inválido foi salvo)
                .validarRegistro("123456 12345678910 71996759145 16/03/1998");
    }

    @Test
    public void naoCadastrarCpfInvalidoTest() {
        new FormularioPage(navegador)
                // Cadastro de usuário com cpf inválido
                .cadastrarUsuario("Igor Carvalho Amaral", "123456789101igor","71996759145","16/03/1998")
                // Validar se o usuário com cpf inválido não foi salvo (se falhar, o usuário inválido foi salvo)
                .validarRegistro("Igor Carvalho Amaral 123456789101igor 71996759145 16/03/1998");
    }

    @Test
    public void naoCadastrarCelularInvalidoTest() {
        new FormularioPage(navegador)
                // Cadastro de usuário com celular inválido
                .cadastrarUsuario("Igor Carvalho Amaral", "12345678910","71igor96759i45","16/03/1998")
                // Validar se o usuário com celular inválido não foi salvo (se falhar, o usuário inválido foi salvo)
                .validarRegistro("Igor Carvalho Amaral 12345678910 71igor96759i45 16/03/1998");
    }

    @Test
    public void naoCadastrarDataNascimentoInvalidaSemMascaraTest() {
        new FormularioPage(navegador)
                // Cadastro de usuário com a data de nascimento inválida (sem máscara)
                .cadastrarUsuario("Igor Carvalho Amaral", "12345678910","71996759145","16do3de1998")
                // Validar se o usuário com a data de nascimento inválida não foi salvo (se falhar, o usuário inválido foi salvo)
                .validarRegistro("Igor Carvalho Amaral 12345678910 71996759145 16do3de1998");
    }

    @Test
    public void naoCadastrarDataNascimentoInvalidaComMascaraTest() {
        new FormularioPage(navegador)
                // Cadastro de usuário com a data de nascimento inválida (com máscara)
                .cadastrarUsuario("Igor Carvalho Amaral", "12345678910","71996759145","16/03/1998igor")
                // Validar se o usuário com a data de nascimento inválida não foi salvo (se falhar, o usuário inválido foi salvo)
                .validarRegistro("Igor Carvalho Amaral 12345678910 71996759145 16/03/1998igor");
    }
    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}

