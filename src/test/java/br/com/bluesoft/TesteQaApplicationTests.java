package br.com.bluesoft;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
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

	@BeforeClass
	public static void setup(){
		WebDriverManager.chromedriver().setup();
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
	}

	//@Test
	// public void contextLoads() {}

	// Teste de busca de campos no chrome ok
 	@Test
	public void findFields(){
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

	//teste de cadastro de usuarios no chrome

	@Test
	public void createMultipleUsers(){
		createUser("Marcos Vinicius Emanuel Thomas Galvão", "462.258.965-63", "(17)99676-2672", "28/02/1994");
		createUser("André Luan Fernando Pereira", "452.301.249-03", "(43) 98328-6989", "07/04/1999");
		createUser("Tânia Larissa Peixoto", "638.627.249-80", "(43) 2833-0160", "28/02/1994");
		createUser("Kauê Jorge Benjamin Almada", "055.095.222-59", "(92) 99220-1050", "24/02/1999");
		WebDriverWait espera = new WebDriverWait(chromeDriver, 20);
	}
	////teste de busca de usuarios no chrome ok
	@Test
	public void findUser(){
		createUser("André Luan Fernando Pereira", "452.301.249-03", "(43) 98328-6989", "07/04/1999");

		WebElement elemento = chromeDriver.findElement(By.id("tabela-usuarios"));

		WebDriverWait espera = new WebDriverWait(chromeDriver, 5);
		espera.until(ExpectedConditions.textToBePresentInElement(elemento, "André Luan Fernando Pereira"));
	}
	//teste de exclusão de usuarios no chrome  ok
	@Test
	public void deleteUsers(){
		createMultipleUsers();
		chromeDriver.findElement(By.cssSelector(".btn-danger")).click();
	}

	@Test
	public void validateBirthdateFormat(){
		createUser("Marcos Vinicius Emanuel Thomas Galvão", "462.258.965-63", "(17)99676-2672", "28021994");

		WebElement elemento = chromeDriver.findElement(By.id("tabela-usuarios"));

		try {
			WebDriverWait espera = new WebDriverWait(chromeDriver, 2);
			espera.until(ExpectedConditions.textToBePresentInElement(elemento, "Marcos Vinicius Emanuel Thomas Galvão"));
			Assert.fail("A exceção .TimeoutException não foi lançada");
		} catch (org.openqa.selenium.TimeoutException e){
			System.out.println("Exception lançada: "+ e);
		}
	}

	private void createUser(String name, String cpf, String phone, String birthdate){
		chromeDriver.get("http://localhost:8080");
	 	chromeDriver.findElement(By.id("nome")).sendKeys(name);
		chromeDriver.findElement(By.id("cpf")).sendKeys(cpf);
		chromeDriver.findElement(By.id("celular")).sendKeys(phone);
		chromeDriver.findElement(By.id("dt-nascimento")).sendKeys(birthdate);
		chromeDriver.findElement(By.id("btn-salvar")).click();
	}

	@AfterClass
	public static void tearDown() {
		chromeDriver.quit();
	}
}
