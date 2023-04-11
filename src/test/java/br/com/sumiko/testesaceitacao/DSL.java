package br.com.sumiko.testesaceitacao;


import org.openqa.selenium.By;
import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;


public class DSL {
    public void escrever(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escrever(String string, String texto) {
        getDriver().findElement(By.id(string)).sendKeys(texto);
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

    public void clicarLink(String id) {

        getDriver().findElement(By.linkText(id)).click();
    }


    public String obterConteudoCelula(String celulaPath) {
        return getDriver().findElement(By.xpath(celulaPath)).getText();
    }
    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

}
