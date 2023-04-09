using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace direcionamento
{
    public class DriverFactory
    {
        private IWebDriver _driver;

        // Construtor da classe. 
        public DriverFactory()
        {
            // Inicializa o browser utilizando o ChromeDriver que está no caminho /usr/share/applications/
            ChromeDriverService service = ChromeDriverService.CreateDefaultService("/usr/share/applications/");
            
            // Faz criação de porta para abrir o browser.
            service.Port = new Random().Next(64000, 64800);
            
            // Inicializa o IWebDriver do selenium, é ele que disponibiliza as consultas e manipulacoes das paginas. 
            _driver = new ChromeDriver(service);
            
            _driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(60);
            _driver.Manage().Window.Maximize();
        }

        // Navega para determinada URL
        public void NavigateToUrl(String url)
        {            
            _driver.Navigate().GoToUrl(url);
        }

        // Finaliza driver e serviço.
        public void Close()
        {
            _driver.Quit();
        }

        // Disponibiliza driver.
        public IWebDriver GetWebDriver()
        {
            return _driver;
        }
    }
}