using OpenQA.Selenium;
using QA.Fixtures;
using QA.PageObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xunit;

namespace QA.Testes
{
    [Collection("Chrome Driver")]
    public class EfetuarCadastro
    {
        private IWebDriver driver;

        public EfetuarCadastro(TestFixture fixture)
        {
            driver = fixture.Driver;
        }
        [Fact]
        public void DadoInformacoesValidasDeveEfetuarCadastro()
        {
            //arrange
            var registroPO = new RegistroPO(driver);
            registroPO.Visitar();        

            registroPO.PreencherCadastro("Wellington", "123.456.789-00", "(11) 12345/6789", "13/10/1996");           

            //act
            registroPO.SubmeteFormulario();

            //Assert
            Assert.Contains("Wellington", driver.PageSource);
        }
        [Theory]
        [InlineData("", "95694507037", "(47) 99317-6983", "11/01/1944")]
        [InlineData("Wellington", "", "12992250524", "13/10/1996")]        
        [InlineData("Elcai", "568.475.920-36", "96992637653", "05031965")]
        [InlineData("Coin", "72220872068", "", "")]        
        [InlineData("Muranoumu", "291.012.800-82", "(48) 98489-7623", "09/04/1989")]        
        public void VerificandoValidacaoDosCamposInseridos(
            string nome,
            string cpf,
            string celular,
            string dataDeNascimento)
        {
            //arrange
            var registroPO = new RegistroPO(driver);
            registroPO.Visitar();
            registroPO.PreencherCadastro(nome, cpf, celular, dataDeNascimento);

            //act
            registroPO.SubmeteFormulario();
            
            //Arrange
            Assert.Contains(nome, driver.PageSource);
           

        }
        
        
    }
}
