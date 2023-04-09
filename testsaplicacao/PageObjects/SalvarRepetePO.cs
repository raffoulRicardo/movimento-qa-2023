using OpenQA.Selenium;

namespace Movimento.Selenium.PageObjects
{
    public class SalvarPO
    {
        private IWebDriver driver;

        private By byBotaoSalvar;

        public SalvarPO(IWebDriver driver)
        {
            this.driver = driver;
            byBotaoSalvar = By.Id("btn-salvar");
        }

        public void Visitar()
        {
            driver.Navigate().GoToUrl("http://localhost:8080/");
        }

        public void SubmeteFormulario()
        {
            driver.FindElement(byBotaoSalvar).Submit();
        }

    }
}