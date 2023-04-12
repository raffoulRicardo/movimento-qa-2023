using Movimento.Selenium.PageObjects;
using Movimento.Selenium.Fixtures;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;
using Xunit;


namespace Movimento.Selenium.Testes

{
    [Collection("Chrome Driver")]
    public class AoRealizarCadastro
    {
        private IWebDriver driver;

        public AoRealizarCadastro(TestFixture fixture)
        {
            driver = fixture.Driver;    
        }
        
        [Fact]
        public void DadoCredenciaisValidasDeveDemonstarNaPagina()
        {
            //arrange - CredenciaisValidas//
            var cadastroPO = new CadastroPO(driver);
            var botaoExcluirPO = new CadastroPO(driver);

            cadastroPO.Visitar();
            cadastroPO.PreencheFormulario("Márcia Cristina Alves de Oliveira Silva",
             "115.443.166-58","(31) 98881-0650","06/09/1997");
            cadastroPO.SubmeteFormulario();
           
            cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Sônia Aparecida","123.456.789-10",
             "(31) 99877-5912","12/10/1971");
             cadastroPO.SubmeteFormulario();

             cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Márcio Marcelo Alves da Silva",
             "109.876.543-21","(31) 98885-0650","16/06/1972");
            cadastroPO.SubmeteFormulario();

            //assert
            Assert.Contains("Márcia", driver.PageSource);

            //Excluir Formulário Após O Teste//
            botaoExcluirPO.ExcluiFormulario();

            //assert Cadastros Excluídos//
            Assert.Single(driver.FindElements(By.Id("tabela2")));

        }
    }
}

