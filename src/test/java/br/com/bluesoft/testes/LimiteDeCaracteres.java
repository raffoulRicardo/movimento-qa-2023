package br.com.bluesoft.testes;

import br.com.bluesoft.metodos.Metodos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LimiteDeCaracteres extends Metodos {

    @BeforeEach
    public void setUp() throws Exception {
        iniciarNavegador("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown() {
        encerrarNavegador(driver);
    }

    @Test
    public void verificandolimiteMaximoNome() {
        escrever(By.xpath("//input[@id='nome']"), "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        validarAtributo(By.xpath("//input[@id='nome']"), "value", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        escrever(By.xpath("//input[@id='input-search']"), "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        validarTexto(By.xpath("(//td)[1]"), "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void verificandolimiteMinimoNome() {
        escrever(By.xpath("//input[@id='nome']"), "H");
        validarAtributo(By.xpath("//input[@id='nome']"), "value", "H");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        escrever(By.xpath("//input[@id='input-search']"), "H");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        validarTexto(By.xpath("(//td)[1]"), "H");
        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void verificandolimiteMaximoCPF() {

        escrever(By.xpath("//input[@id='cpf']"), "777777777777777777777777777777777777777777777777777777777777777777777777777777");
        validarAtributo(By.xpath("//input[@id='cpf']"), "value", "777777777777777777777777777777777777777777777777777777777777777777777777777777");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        validarTexto(By.xpath("(//td)[2]"), "777777777777777777777777777777777777777777777777777777777777777777777777777777");
        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void verificandolimiteMinimoCPF() {

        escrever(By.xpath("//input[@id='cpf']"), "7");
        validarAtributo(By.xpath("//input[@id='cpf']"), "value", "7");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        validarTexto(By.xpath("(//td)[2]"), "7");
        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void verficandoLimiteMaximoCelular() {

        escrever(By.xpath("//input[@id='celular']"), "55555555555555555555555555555555555555555555555555555555555555");
        validarAtributo(By.xpath("//input[@id='celular']"), "value", "55555555555555555555555555555555555555555555555555555555555555");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        validarTexto(By.xpath("(//td)[3]"), "55555555555555555555555555555555555555555555555555555555555555");
        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void verficandoLimiteMinimoCelular() {
        escrever(By.xpath("//input[@id='celular']"), "5");
        validarAtributo(By.xpath("//input[@id='celular']"), "value", "5");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        validarTexto(By.xpath("(//td)[3]"), "5");
        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }
    @Test
    public void verificandoLimiteMaximoDataNascimento () {

        escrever(By.xpath("//input[@id='dt-nascimento']"), "222222222222222222222222222222222222222222222222222222222222222222222222222222");
        validarAtributo(By.xpath("//input[@id='dt-nascimento']"), "value", "222222222222222222222222222222222222222222222222222222222222222222222222222222");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void verificandoLimiteMinimoDataNascimento () {

        escrever(By.xpath("//input[@id='dt-nascimento']"), "2");
        validarAtributo(By.xpath("//input[@id='dt-nascimento']"), "value", "2");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }
}

