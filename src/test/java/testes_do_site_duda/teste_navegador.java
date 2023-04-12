package testes_do_site_duda;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class teste_navegador {

        @Test
        public void abrir_navegador() {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mduda\\OneDrive\\Documentos\\driver\\chromedriver.exe");
                WebDriver browser = new ChromeDriver();
                browser.get("http://localhost:8080");
                browser.quit();

        }




}
