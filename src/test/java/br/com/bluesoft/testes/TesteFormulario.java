package br.com.bluesoft.testes;

import br.com.bluesoft.metodos.Metodos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TesteFormulario extends Metodos {

    @BeforeEach
    public void setUp() throws Exception {
        iniciarNavegador("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown() {
        encerrarNavegador(driver);
    }

    @Test
    public void validandoFormularioComDadosValidos() {

        escrever(By.xpath("//input[@id='nome']"), "Miguel Gama da Silva Muniz");
        escrever(By.xpath("//input[@id='cpf']"), "188.320.560-38");
        escrever(By.xpath("//input[@id='celular']"), "(11) 97693-8588");
        escrever(By.xpath("//input[@id='dt-nascimento']"), "15/10/2000");

        validarAtributo(By.xpath("//input[@id='nome']"), "value", "Miguel Gama da Silva Muniz");
        validarAtributo(By.xpath("//input[@id='cpf']"), "value", "188.320.560-38");
        validarAtributo(By.xpath("//input[@id='celular']"), "value", "(11) 97693-8588");
        validarAtributo(By.xpath("//input[@id='dt-nascimento']"), "value", "15/10/2000");

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        escrever(By.xpath("//input[@id='input-search']"), "Miguel Gama da Silva Muniz");
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        validarTexto(By.xpath("(//td)[1]"), "Miguel Gama da Silva Muniz");
        validarTexto(By.xpath("(//td)[2]"), "188.320.560-38");
        validarTexto(By.xpath("(//td)[3]"), "(11) 97693-8588");
        validarTexto(By.xpath("(//td)[4]"), "15/10/2000");

        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }
}
