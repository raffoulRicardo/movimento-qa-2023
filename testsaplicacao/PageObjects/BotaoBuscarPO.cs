using OpenQA.Selenium;

namespace Movimento.Selenium.PageObjects
{
    public class BotaoBuscarPO
    {
        private IWebDriver driver;

        private By byBotaoBuscar;

        public BotaoBuscarPO(IWebDriver driver)
        {
            this.driver = driver;
            byBotaoBuscar = By.CssSelector("body:nth-child(2) div.container:nth-child(1) form:nth-child(2) > button.btn.btn-primary");
        }

        public void Visitar()
        {
            driver.Navigate().GoToUrl("http://localhost:8080/");
        }

        public void SubmeteFormulario()
        {
            driver.FindElement(byBotaoBuscar).Submit();
        }

    }
}