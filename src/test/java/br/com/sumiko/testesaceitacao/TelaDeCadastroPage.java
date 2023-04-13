package br.com.sumiko.testesaceitacao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;

public class TelaDeCadastroPage {
    public void setNome(String nome) {
        escrever("nome", nome);
    }
    public void setCPF(String cpf) {
        escrever("cpf", cpf);
    }
    public void setCelular(String celular) {
        escrever("celular", celular);
    }
    public void setDataNascimento(String dtNascimento) {
        escrever("dt-nascimento", dtNascimento);
    }
    public void salvar() {
        clicarBotao("btn-salvar");
    }
    public void buscar() {
        clicarBotao("buscar");
    }
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
    public String obterValorCelulaNome () {
        return getDriver().findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]")).getText();
    }
    public String obterValorCelulaCPF () {
        return getDriver().findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]")).getText();
    }

    public String obterValorCelulaCelular () {
        return getDriver().findElement(By.xpath("/html/body/div/table/tbody/tr/td[3]")).getText();
    }
    public String obterValorCelulaDataNascimento () {
        return getDriver().findElement(By.xpath("/html/body/div/table/tbody/tr/td[4]")).getText();
    }
    public void clicarBotao(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void clicarLink(String link) {
        getDriver().findElement(By.id(link)).click();
    }

    public boolean isCadastroInserido(String nome, String CPF, String celular, String dataNascimento) {
        WebElement linhaDaTabela = getDriver().findElement(By.cssSelector("#tabela-usuarios tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaCPF = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement colunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));

        return colunaNome.getText().equals(nome)
                && colunaCPF.getText().equals(CPF)
                && colunaCelular.getText().equals(celular)
                && colunaDataNascimento.getText().equals(dataNascimento);
    }

    public boolean isCadastroDeletado(String nome, String CPF, String celular, String dataNascimento) {
        WebElement linhaDaTabela = getDriver().findElement(By.cssSelector("#tabela-usuarios tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaCPF = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement colunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));

        return colunaNome.getText().equals("")
                && colunaCPF.getText().equals("")
                && colunaCelular.getText().equals("")
                && colunaDataNascimento.getText().equals("");
    }



}




