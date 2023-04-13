package br.com.bluesoft;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TesteQaApplicationTests {

	@Test
	void testeSeleniumIDE() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(capabilities);

		driver.get("file:///{/home/sarah/movimento-qa-2023/movimento-qa-2023/src/test/selenium/Automacao-Sarah-Ishida.side}");
		driver.quit();
	}

}
