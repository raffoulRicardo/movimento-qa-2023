using Movimento.Selenium.PageObjects;
using Movimento.Selenium.Fixtures;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;
using Xunit;
using OpenQA.Selenium.Support;



namespace Movimento.Selenium.Testes

{
    [Collection("Chrome Driver")]
    public class AoInserirDataNascimentoInválido
    {
        private IWebDriver driver;

        public AoInserirDataNascimentoInválido(TestFixture fixture)
        {
            driver = fixture.Driver;    
        }
        
        [Fact]
        public void DadoDatasDeNascimentoInválidasRetorneOutroValor()
        {
            
            //arrange
            var cadastroPO = new CadastroPO(driver);


            //arrange + act - Realizando Cadastros Com As Datas Alteradas//
            cadastroPO.Visitar();
            cadastroPO.PreencheFormulario("Márcia Cristina Alves de Oliveira Silva",
             "115.443.166-58","(31) 98881-0650","01/01/1600");
             cadastroPO.SubmeteFormulario();

             cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Sônia Aparecida","123.456.789-10",
             "(31) 99877-5912","12/10/1500");
             cadastroPO.SubmeteFormulario();

             cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Márcio Marcelo Alves da Silva",
             "109.876.543-21","(31) 98885-0650","16/06/2050");
            cadastroPO.SubmeteFormulario();

            //assert - Contendo O Retorno Qua A Aplicação Me Retorna de Cada Cadastro//
            Assert.Contains("31/12/1599", driver.PageSource);
            Assert.Contains("11/10/1500", driver.PageSource);
            Assert.Contains("16/06/2050", driver.PageSource);

        }
    }
}