package baseTest;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver driver = new ChromeDriver();

    public void preencherCorreto() {
        String nomeKey = "Cleverson Fernando";
        String cpfKey = "111.111.111-11";
        String celularKey = "(19)111111111";
        String dataKey = "11/11/2023";

        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys(nomeKey);
        driver.findElement(By.id("cpf")).click();
        driver.findElement(By.id("cpf")).sendKeys(cpfKey);
        driver.findElement(By.id("celular")).click();
        driver.findElement(By.id("celular")).sendKeys(celularKey);
        driver.findElement(By.id("dt-nascimento")).click();
        driver.findElement(By.id("dt-nascimento")).sendKeys(dataKey);
    }

    public void todosOsCamposVazios() {
        Assert.assertEquals("", driver.findElement(By.id("nome")).getText());
        Assert.assertEquals("", driver.findElement(By.id("cpf")).getText());
        Assert.assertEquals("", driver.findElement(By.id("celular")).getText());
        Assert.assertEquals("", driver.findElement(By.id("dt-nascimento")).getText());
    }
    public void imprimirEvidencia(WebDriver driver, String nomeArquivo) throws IOException {
        File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printFinal,new File("src/test/java/target/Evidencia" + nomeArquivo + ".png"));
    }
}

