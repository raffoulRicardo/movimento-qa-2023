package br.com.bluesoft.testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteFormulario {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void validandoFormularioComDadosVálidos () {

        driver.findElement(By.xpath("//input[@id='nome']")).sendKeys("Miguel Gama da Silva Muniz");
        driver.findElement(By.xpath("//input[@id='cpf']")).sendKeys("348.766.080-67");
        driver.findElement(By.xpath("//input[@id='celular']")).sendKeys("(11) 97693-8588)");
        driver.findElement(By.xpath("//input[@id='dt-nascimento']")).sendKeys("15/10/2000");

        String nomeRetornado = driver.findElement(By.xpath("//input[@id='nome']")).getAttribute("value");
        String cpfRetornado = driver.findElement(By.xpath("//input[@id='cpf']")).getAttribute("value");
        String celularRetornado = driver.findElement(By.xpath("//input[@id='celular']")).getAttribute("value");
        String dataNascimentoRetornado = driver.findElement(By.xpath("//input[@id='dt-nascimento']")).getAttribute("value");

        assertEquals("Miguel Gama da Silva Muniz", nomeRetornado);
        assertEquals("348.766.080-67", cpfRetornado);
        assertEquals("(11) 97693-8588)", celularRetornado);
        assertEquals("15/10/2000", dataNascimentoRetornado);

        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

        driver.findElement(By.xpath("//input[@id='input-search']")).sendKeys("Miguel Gama da Silva Muniz");

        String nomePesquisado = driver.findElement(By.xpath("//input[@id='input-search']")).getAttribute("value");
        assertEquals("Miguel Gama da Silva Muniz", nomePesquisado);

        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();

        String retornoColunaNome =  driver.findElement(By.xpath("(//td)[1]")).getText();
        String retornoColunaCpf = driver.findElement(By.xpath("(//td)[2]")).getText();
        String retornoColunaCelular = driver.findElement(By.xpath("(//td)[3]")).getText();
        String retornoColunaDataNascimento = driver.findElement(By.xpath("(//td)[4]")).getText();

        assertEquals("Miguel Gama da Silva Muniz", retornoColunaNome);
        assertEquals("348.766.080-67", retornoColunaCpf);
        assertEquals("(11) 97693-8588)", retornoColunaCelular);
        assertEquals("15/10/2000", retornoColunaDataNascimento);

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
    }
}
