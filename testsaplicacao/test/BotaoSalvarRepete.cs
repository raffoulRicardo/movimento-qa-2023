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
    public class AoPressionarOBotaoSalvarRepetidamente
    {
        private IWebDriver driver;

        public AoPressionarOBotaoSalvarRepetidamente(TestFixture fixture)
        {
            driver = fixture.Driver;    
        }

        [Fact]
        public void DadoAbertoOSiteDeCadastroPressionoOBotaoSalvarRepetidasVezes()
        {
            //arrange
            var salvarPO = new SalvarPO(driver);
            salvarPO.Visitar();

            //act Pressionando_O_Botão_Salvar_8x
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();
            salvarPO.SubmeteFormulario();


            //assert 
            Assert.NotEmpty(driver.FindElements(By.CssSelector("#tabela2")));
        }
    }
}