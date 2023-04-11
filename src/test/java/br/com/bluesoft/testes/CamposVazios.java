package br.com.bluesoft.testes;

import br.com.bluesoft.metodos.Metodos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CamposVazios extends Metodos {

    @BeforeEach
    public void setUp() throws Exception {
        iniciarNavegador("http://localhost:8080/");
    }

    @AfterEach
    public void tearDown() {
        encerrarNavegador(driver);
    }

    @Test
    public void validandoSemPreecherCampos () {

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("//button[@class='btn btn-danger']"));
    }

    @Test
    public void cliquesRepetidosBotãoSalvar() {

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
    }

    @Test
    public void cliquesRepetidosBotãoBuscar() {

        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
    }

    @Test
    public void cliquesRepetidosSalvarEBuscar() {
        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));

        clicar(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        clicar(By.xpath("(//button[@class='btn btn-primary'])[2]"));
    }
}
