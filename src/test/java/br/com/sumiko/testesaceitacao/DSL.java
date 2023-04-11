package br.com.sumiko.testesaceitacao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;

public class DSL {
    public void escrever(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escrever(String string, String texto) {
        getDriver().findElement(By.id(string)).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterValorCampo(String id_campo ) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarBotao(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public String obterValueElemento(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");

    }

    /********** Link **********/

    public void clicarLink(String linkExcluir) {
        getDriver().findElement(By.linkText(linkExcluir)).click();
    }





    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

}
