package br.com.bluesoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TesteQaApplicationTests {
	private static WebDriver chromeDriver;
// Metodo para criar uma unica instancia do chrome driver e assim abrir uma unica janela do navegador para executar todos os testes
	@BeforeClass
	public static void setup(){
		WebDriverManager.chromedriver().setup();
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
	}
	// Metodo que limpa a base antes de executar cada teste
	@Before
	public void LimparDados(){
		chromeDriver.get("http://localhost:8080");
		chromeDriver.findElement(By.className("btn-danger")).click();

	}
	// Teste de busca de campos
 	@Test
	public void FindFields(){
		chromeDriver.get("http://localhost:8080");
		chromeDriver.findElement(By.id("nome"));
		chromeDriver.findElement(By.id("cpf"));
		chromeDriver.findElement(By.id("celular"));
		chromeDriver.findElement(By.id("dt-nascimento"));
		chromeDriver.findElement(By.id("btn-salvar"));
		chromeDriver.findElement(By.id("input-search"));
		chromeDriver.findElement(By.cssSelector(".btn:nth-child(2)"));
		chromeDriver.findElement(By.cssSelector(".btn-danger"));
	}

	// Teste de cadastro de usuarios

	@Test
	public void CreateMultipleUsers(){
		createUser("Marcos Vinicius Emanuel Thomas Galvão", "462.258.965-63", "(17)99676-2672", "28/02/1994");
		createUser("André Luan Fernando Pereira", "452.301.249-03", "(43) 98328-6989", "07/04/1999");
		createUser("Tânia Larissa Peixoto", "638.627.249-80", "(43) 2833-0160", "28/02/1994");
		createUser("Kauê Jorge Benjamin Almada", "055.095.222-59", "(92) 99220-1050", "24/02/1999");

		WebElement element = chromeDriver.findElement(By.id("tabela-usuarios"));
		WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(element, "André Luan Fernando Pereira"));
	}
	// Teste de busca de usuarios
	@Test
	public void FindUser(){
		createUser("André Luan Fernando Pereira", "452.301.249-03", "(43) 98328-6989", "07/04/1999");

		WebElement element = chromeDriver.findElement(By.id("tabela-usuarios"));

		WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(element, "André Luan Fernando Pereira"));
	}
	// Teste de exclusão de usuarios
	@Test
	public void DeleteUsers(){
		CreateMultipleUsers();
		chromeDriver.findElement(By.cssSelector(".btn-danger")).click();
	}
	// Teste de formato invalido de data
	@Test
	public void ValidateBirthdateFormat(){
		createUser("Marcos Vinicius Emanuel Thomas Galvão", "462.258.965-63", "(17)99676-2672", "28021994");

		WebElement element = chromeDriver.findElement(By.id("tabela-usuarios"));

		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, 2);
			wait.until(ExpectedConditions.textToBePresentInElement(element, "Marcos Vinicius Emanuel Thomas Galvão"));
			Assert.fail("A exceção .TimeoutException não foi lançada");
		} catch (org.openqa.selenium.TimeoutException e){
			System.out.println("Exception lançada: "+ e);
		}
	}
	// Método que recebe como parametros os dados do usuário e o cadastra
	private void createUser(String name, String cpf, String phone, String birthdate){
		chromeDriver.get("http://localhost:8080");
	 	chromeDriver.findElement(By.id("nome")).sendKeys(name);
		chromeDriver.findElement(By.id("cpf")).sendKeys(cpf);
		chromeDriver.findElement(By.id("celular")).sendKeys(phone);
		chromeDriver.findElement(By.id("dt-nascimento")).sendKeys(birthdate);
		chromeDriver.findElement(By.id("btn-salvar")).click();
	}
	// TearDown
	@AfterClass
	public static void TearDown() {
		chromeDriver.quit();
	}
}
