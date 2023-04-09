using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace HelpersDriver
{
    public class DriverChrome
    {
        private IWebDriver _driver;

        // Construtor da classe. 
        public DriverChrome()
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


        // Disponibiliza driver.
        public IWebDriver GetWebDriver()
        {
            return _driver;
        }
    }
}