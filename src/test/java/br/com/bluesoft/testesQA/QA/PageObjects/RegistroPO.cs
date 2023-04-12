using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QA.PageObjects
{
    public class RegistroPO
    {
        private IWebDriver driver;
        private By byInputNome;
        private By byInputCpf;
        private By byInputCelular;
        private By byInputDataDeNascimento;
        private By bySalvar;

        
       public RegistroPO(IWebDriver driver)
        {
            this.driver = driver;
            byInputNome = By.Id("nome");
            byInputCpf = By.Id("cpf");
            byInputCelular = By.Id("celular");
            byInputDataDeNascimento = By.Id("dt-nascimento");
            bySalvar = By.Id("btn-salvar");
        }
        public void Visitar()
        {
            driver.Navigate().GoToUrl("http://localhost:8080");
        }

        public void SubmeteFormulario()
        {
            driver.FindElement(bySalvar).Click();            
        }

        public void PreencherCadastro(string nome, string cpf, string celular, string dataDeNascimento)
        {
            driver.FindElement(byInputNome).SendKeys(nome);
            driver.FindElement(byInputCpf).SendKeys(cpf);
            driver.FindElement(byInputCelular).SendKeys(celular);
            driver.FindElement(byInputDataDeNascimento).SendKeys(dataDeNascimento);            

        }
    }
}
