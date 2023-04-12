using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xunit;

namespace QA.PageObjects
{
    public class BuscaPO
    {
        private IWebDriver driver;       
        private By byBotaoBuscar;
        private By byInputBuscaPorNome;
        private By byInputDeletar;

        public BuscaPO(IWebDriver driver)
        {
            this.driver = driver;            
            byInputBuscaPorNome = By.Id("input-search");
            byBotaoBuscar = By.CssSelector("#app > form:nth-child(2) > button");
            byInputDeletar = By.CssSelector("#app > button");           
           
        }

        public void Visitar()
        {
            driver.Navigate().GoToUrl("http://localhost:8080");
        }

        public void Buscar()
        {
            driver.FindElement(byBotaoBuscar).Click();            
        }

        public void BuscarNome(string nome)
        {

            driver.FindElement(byInputBuscaPorNome).SendKeys(nome);
        }

        public void Deletar()
        {
            driver.FindElement(byInputDeletar).Click();
        }

       

    }
}
