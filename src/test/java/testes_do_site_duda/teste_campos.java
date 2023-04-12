package testes_do_site_duda;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class teste_campos {

        @Test
        public void abrir_navegador() {
                System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
                WebDriver browser = new ChromeDriver();
                browser.navigate().to("http://localhost:8080/?");
                browser.quit();
        }


}
