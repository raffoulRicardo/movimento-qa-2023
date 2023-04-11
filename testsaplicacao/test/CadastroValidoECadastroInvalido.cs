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

            //act
            cadastroPO.SubmeteFormulario();

            //assert
            Assert.Contains("Márcia", driver.PageSource);

            //Excluir Formulário Após O Teste//
            botaoExcluirPO.ExcluiFormulario();
        }

        [Fact]
        public void DadoCredenciaisInvalidasDeveRessetarPagina()
        {
            //arrange + act -  CredenciaisInvalidas//
            var cadastroPO = new CadastroPO(driver);
            cadastroPO.Visitar();
            cadastroPO.PreencheFormulario("", 
            "11544316658", "31 988810650","691997");
            cadastroPO.SubmeteFormulario();

            cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Márcia Cristina",
             "","31 98885-0650","06091997");
             cadastroPO.SubmeteFormulario();

             cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Márcia Cristina",
             "115.443.166-58","","06-09-1997");
            cadastroPO.SubmeteFormulario();

            cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Márcia Cristina",
             "11544316658","123456","6-9-97");
             cadastroPO.SubmeteFormulario();
            

            //assert
            Assert.Single(driver.FindElements(By.Id("tabela2")));
        }
    }
}

