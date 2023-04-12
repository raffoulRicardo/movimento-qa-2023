package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class FormularioPage {

    private WebDriver navegador;

    public FormularioPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioPage apagarRegistros(){
        navegador.findElement(By.xpath("//div/button")).click();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return this;
    }

    public FormularioPage cadastrarUsuario(String nome, String cpf,String celular,String dtnascimento){
        WebElement formularioCadastro = navegador.findElement(By.id("app"));
        formularioCadastro.findElement(By.id("nome")).sendKeys(nome);
        formularioCadastro.findElement(By.id("cpf")).sendKeys(cpf);
        formularioCadastro.findElement(By.id("celular")).sendKeys(celular);
        formularioCadastro.findElement(By.id("dt-nascimento")).sendKeys(dtnascimento);
        formularioCadastro.findElement(By.id("btn-salvar")).click();

        return this;
    }

    public FormularioPage buscarUsuario(String parametro){
        WebElement buscarUsuario = navegador.findElement(By.id("input-search"));
        buscarUsuario.sendKeys(parametro);
        navegador.findElement(By.xpath("//form[2]//button")).click();


        return this;
    }
    public FormularioPage validarTabela(String resultadoEsperado){
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement tabelaUsuarios = navegador.findElement(By.id("tabela-usuarios"));
        String dadosSalvosEsperados = resultadoEsperado;
        String dadosSalvosNoRegistro = tabelaUsuarios.getText();
        assertTrue(dadosSalvosNoRegistro.contains(dadosSalvosEsperados));


        return this;
    }
    public FormularioPage validarBusca(String resultadoEsperado){
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement tabelaUsuarios = navegador.findElement(By.id("tabela-usuarios"));
        String usuarios = tabelaUsuarios.getText();
        assertEquals(resultadoEsperado, usuarios);

        return this;
    }
    public FormularioPage validarRegistro(String resultadoEsperado){
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement registroUsuario = navegador.findElement(By.id("tabela-usuarios"));
        assertFalse(registroUsuario.getText().contains(resultadoEsperado));

        return this;
    }
}
