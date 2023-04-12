using OpenQA.Selenium;
using QA.Fixtures;
using QA.PageObjects;
using Xunit;

namespace QA.Testes
{
    [Collection("Chrome Driver")]
    public class AoBuscaNome
    {
        private IWebDriver driver;
        public AoBuscaNome(TestFixture fixture)
        {
            driver = fixture.Driver;
        }
        [Fact]
        public void AoBuscarPorNomeDeveRetornarONomeInformado()
        {
            //arrange
            var buscaPO = new BuscaPO(driver);
            buscaPO.Visitar();

            buscaPO.BuscarNome("Wellington");

            //act
            
            buscaPO.Buscar();

            Thread.Sleep(1000);

            //Assert            
            Assert.Contains("Wellington", driver.PageSource) ;
        }
    }
}
