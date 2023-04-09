using OpenQA.Selenium;

namespace Movimento.Selenium.PageObjects
{
    public class CadastroPO
    {
        private IWebDriver driver;
        private By byInputNome;
        private By byInputCPF;
        private By byInputCelular;

        private By byInputDataNascimento;

        private By byBotaoSalvar;

        private By byBotaoExcluirTudo;

        public CadastroPO(IWebDriver driver)
        {
            this.driver = driver;
            byInputNome = By.Id("nome");
            byInputCPF = By.Id("cpf");
            byInputCelular = By.Id("celular");
            byInputDataNascimento = By.Id("dt-nascimento");
            byBotaoSalvar = By.Id("btn-salvar");
            byBotaoExcluirTudo = By.CssSelector("body:nth-child(2) div.container:nth-child(1) > button.btn.btn-danger:nth-child(4)");
        }

        public void Visitar()
        {
            driver.Navigate().GoToUrl("http://localhost:8080/");
        }

        public void PreencheFormulario(string nome, string cpf, string celular, string datanascimento)
        {
            driver.FindElement(byInputNome).SendKeys(nome);
            driver.FindElement(byInputCPF).SendKeys(cpf);
            driver.FindElement(byInputCelular).SendKeys(celular);
            driver.FindElement(byInputDataNascimento).SendKeys(datanascimento);
        }

        public void SubmeteFormulario()
        {
           
            driver.FindElement(byBotaoSalvar).Submit();
            
        }

        public void ExcluiFormulario()
        {

            driver.FindElement(byBotaoExcluirTudo).Submit();

        }
    }
}