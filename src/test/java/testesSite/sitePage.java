package testesSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sitePage {
    private static final String URL_PAGINA = "http://localhost:8080/";
    private WebDriver browser;
    public sitePage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_PAGINA);
    }
    //Preenche o formulario e o submete
    public void preencherFormulario(String nome, String cpf, String celular, String dataNascimento) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("cpf")).sendKeys(cpf);
        browser.findElement(By.id("celular")).sendKeys(celular);
        browser.findElement(By.id("dt-nascimento")).sendKeys(dataNascimento);
        browser.findElement(By.id("btn-salvar")).click();
    }
    //Fecha a pagina
    public void fechar() {
        this.browser.quit();
    }
    //Confere se os dados estão presente na tabela
    public boolean confereSeOsDadosForamInseridosNaTabela(String nome, String cpf, String celular, String DataNascimento) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-usuarios tbody tr:last-child "));
        WebElement ColunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement ColunaCpf = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement ColunaCelular = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement ColunaDataNascimento = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        return ColunaNome.getText().equals(nome) && ColunaCpf.getText().equals(cpf) && ColunaCelular.getText().equals(celular) && ColunaDataNascimento.getText().equals(DataNascimento);
    }
    //Maximixa o navegador
    public void maximixaTela() {
        this.browser.manage().window().maximize();
    }


    //Imprime os dados da tabela no console
    public void scrap() {
        WebElement element = this.browser.findElement(By.cssSelector("#tbl-dados tr"));

        // Extrair o texto do elemento
        String texto = element.getText();

        // Imprimir o texto extraído
        System.out.println("Texto extraído: " + texto);
    }

    public boolean clear() {
        try {
            WebElement deleteButton = this.browser.findElement(By.id("btn_excluir"));
            WebElement primeiroTD = this.browser.findElement(By.cssSelector("td:nth-child(1)"));
            if (primeiroTD.isDisplayed()) {
                deleteButton.click();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   // Recarregar pagina 10x
    public void RecarregarPagina() {
        for (int i = 0; i < 10; i++) {
            this.browser.navigate().refresh();
        }

    }

}
