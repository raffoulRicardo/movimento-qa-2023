package br.com.bluesoft;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@SpringBootTest
class TesteQaApplicationTests {
	private static WebDriver driver;
	public static final String urlBase = "http://localhost:8080/?";
	public static final String caminhoDriver = "src/main/resources/drivers/chromedriver.exe";

		@BeforeAll
		public static void beforeAll(){
			System.setProperty("webdriver.chrome.driver", caminhoDriver);
		}

		@BeforeEach
		public void beforeEach() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(urlBase);
			//driver.navigate().to (urlBase);
		}

		@AfterEach
		public void afterEach() {
			driver.quit();
		}

				// TESTES DE PREENCHIMENTO COLETIVO DOS CAMPOS
				@Test
				@Order(1)
				void TC001_PrechimentoCorretoDeTodosOsCampos() {
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					driver.findElement(By.id("cpf")).click();
					driver.findElement(By.id("cpf")).sendKeys("426.932.318-38");
					driver.findElement(By.id("celular")).click();
					driver.findElement(By.id("celular")).sendKeys("(11)97977-6996");
					driver.findElement(By.id("dt-nascimento")).click();
					driver.findElement(By.id("dt-nascimento")).sendKeys("21/05/1996");
					driver.findElement(By.id("btn-salvar")).click();
		
				}
				// TESTES DE PREENCHIMENTO DOS CAMPOS INDIVIDUALMENTE
				@Test
				@Order(2)
				void TC002_PreenchimentoDoCampoNome() {
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
				}

				@Test
				@Order(3)
				void TC003_PreenchimentoDoCampoCPF() {
					driver.findElement(By.id("cpf")).click();
					driver.findElement(By.id("cpf")).sendKeys("426.932.318-38");
				}

				@Test
				@Order(4)
				void TC004_PreenchimentoDoCampoCelular() {
					driver.findElement(By.id("celular")).click();
					driver.findElement(By.id("celular")).sendKeys("(11)97977-6996");
				}

				@Test
				@Order(5)
				void TC005_PreenchimentoDoCampoData() {
					driver.findElement(By.id("dt-nascimento")).click();
					driver.findElement(By.id("dt-nascimento")).sendKeys("21/05/1992");
				}

				// TESTES DE GRAVAÇÃO DOS DADOS
				@Test
				@Order(6)
				void TC006_DadosDevemSerGravadosNaTabelaAoClicarEmSalvar() {
					// aguarda exclusao
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-danger")));
					
					// exclui
					driver.findElement(By.cssSelector(".btn-danger")).click();
				
					// adiciona
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Ana Maria");
					driver.findElement(By.id("btn-salvar")).click();
				
					// valida
					String resultado = driver.findElement(By.id("nome-buscado")).getText();
					assertEquals("Ana Maria", resultado);
			    }

				@Test
				@Order(7)
				void TC007_OCampoNomeCompletoGravadoDeveEstarVisivelNaTabela() {
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					driver.findElement(By.id("btn-salvar")).click();

					List<WebElement> elementosNome = driver.findElements(By.xpath("//td[text()='Fulano da Silva']"));
    				assertFalse(elementosNome.isEmpty());
				}

				@Test
				@Order(8)
				void TC008_OCampoCPFGravadoDeveEstarVisivelNaTabela() {
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					driver.findElement(By.id("cpf")).click();
					driver.findElement(By.id("cpf")).sendKeys("426.932.318-38");
					driver.findElement(By.id("btn-salvar")).click();

					List<WebElement> elementosCpf = driver.findElements(By.xpath("//td[text()='426.932.318-38']"));
    				assertFalse(elementosCpf.isEmpty());
				}

				@Test
				@Order(9)
				void TC009_OCampoCelularGravadoDeveEstarVisivelNaTabela() {
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					driver.findElement(By.id("celular")).click();
					driver.findElement(By.id("celular")).sendKeys("(11)97977-6996");
					driver.findElement(By.id("btn-salvar")).click();

					List<WebElement> elementosCelular = driver.findElements(By.xpath("//td[text()='(11)97977-6996']"));
    				assertFalse(elementosCelular.isEmpty());
				}

				@Test
				@Order(10)
				void TC0010_OCampoDataDeNascimentoGravadoDeveEstarVisivelNaTabela() {
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					driver.findElement(By.id("dt-nascimento")).click();
					driver.findElement(By.id("dt-nascimento")).sendKeys("21/05/1992");
					driver.findElement(By.id("btn-salvar")).click();

					List<WebElement> elementosData = driver.findElements(By.xpath("//td[text()='21/05/1992']"));
    				assertFalse(elementosData.isEmpty());
				}

				// TESTE DE BUSCA DOS DADOS
				@Test
				@Order(11)
				void TC011_DeveLocalizarUsuarioAoDigitarNomeEClicarEmBuscar() {
					//exclui
					driver.findElement(By.cssSelector(".btn-danger")).click();
					//adiciona
					driver.findElement(By.id("nome")).click();
					driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					driver.findElement(By.id("btn-salvar")).click();
					//busca
					driver.findElement(By.id("input-search")).click();
					driver.findElement(By.id("input-search")).sendKeys("Fulano da Silva");
					driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();					
					//resultado
					String resultado = driver.findElement(By.id("nome-buscado")).getText();
					assertEquals("Fulano da Silva", resultado, resultado);
				}

				// TESTES DE EXCLUSÃO DOS DADOS
				@Test
				@Order(12)
				void TC012_DadosDevemSerExcluidosDaTabelaAoClicarEmExcluir() {
					 //adiciona
					 driver.findElement(By.id("nome")).click();
					 driver.findElement(By.id("nome")).sendKeys("Fulano da Silva");
					 driver.findElement(By.id("cpf")).click();
					 driver.findElement(By.id("cpf")).sendKeys("426.932.318-38");
					 driver.findElement(By.id("celular")).click();
					 driver.findElement(By.id("celular")).sendKeys("(11)97977-6996");
					 driver.findElement(By.id("dt-nascimento")).click();
					 driver.findElement(By.id("dt-nascimento")).sendKeys("21/05/1996");
					 driver.findElement(By.id("btn-salvar")).click();
					 //exclui
					 driver.findElement(By.cssSelector(".btn-danger")).click();
					 //valida
					 List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
					 boolean found = false;
					 for (WebElement row : rows) {
						if (row.findElement(By.cssSelector("td:nth-child(2)")).getText().equals("426.932.318-38")) {
								found = true;
								break;
							}
					}
					 assertFalse(found);

					 assertEquals("", driver.findElement(By.id("nome")).getText());
					 assertEquals("", driver.findElement(By.id("cpf")).getText());
					 assertEquals("", driver.findElement(By.id("celular")).getText());
					 assertEquals("", driver.findElement(By.id("dt-nascimento")).getText());
				}
	}