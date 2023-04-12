package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Web {
    public static WebDriver createChrome() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        // Maximizando tela do navegador
        navegador.manage().window().maximize();
        // Navegando para a página
        navegador.get("http://localhost:8080/");

        return navegador;
    }
}
