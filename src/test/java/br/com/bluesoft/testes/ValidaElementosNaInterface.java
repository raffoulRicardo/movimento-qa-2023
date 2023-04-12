package br.com.bluesoft.testes;

import br.com.bluesoft.metodos.Metodos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ValidaElementosNaInterface extends Metodos {

    @BeforeEach
    public void setUp() throws Exception {
        iniciarNavegador("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown() {
        encerrarNavegador(driver);
    }

    @Test
    public void verificandoTextoFormulario() {
        validarTexto(By.xpath("//label[@for='nome']"), "Nome completo");
        validarTexto(By.xpath("//label[@for='cpf']"), "CPF");
        validarTexto(By.xpath("//label[@for='celular']"), "Celular");
        validarTexto(By.xpath("//label[@for='dt-nascimento']"), "Data de Nascimento");
    }

    @Test
    public void validaTextoExibidoBotoes() {
        validarTexto(By.xpath("(//button[@class='btn btn-primary'])[1]"), "Salvar");
        validarTexto(By.xpath("(//button[@class='btn btn-primary'])[2]"), "Buscar");
        validarTexto(By.xpath("//button[@class='btn btn-danger']"), "Excluir todos os usuários");
    }

    @Test
    public void verificandoTextoExibidoLinhaTabela() {
        validarTexto(By.xpath("(//th)[1]"), "Nome");
        validarTexto(By.xpath("(//th)[2]"), "CPF:");
        validarTexto(By.xpath("(//th)[3]"), "Celular:");
        validarTexto(By.xpath("(//th)[4]"), "Data de nascimento:");
    }
    @Test
    public void validaPlaceHolder () {
        validarAtributo(By.xpath("//input[@id='nome']"), "placeholder","Nome");
        validarAtributo(By.xpath("//input[@id='cpf']"), "placeholder","XXX.XXX.XXX-XX");
        validarAtributo(By.xpath("//input[@id='celular']"), "placeholder","(XX) XXXXX-XXXX");
        validarAtributo(By.xpath("//input[@id='dt-nascimento']"), "placeholder"," XX/XX/XXXX");
        validarAtributo(By.xpath("//input[@id='input-search']"), "placeholder", "Busca por nome");
    }
}