using OpenQA.Selenium;
using QA.Fixtures;
using QA.PageObjects;
using Xunit;

namespace QA.Testes
{
    [Collection("Chrome Driver")]
    public class AoDeletarUsuario
    {
        private IWebDriver driver;

        public AoDeletarUsuario(TestFixture fixture)
        {
            driver = fixture.Driver;
        }        
        [Fact]
        public void AoClicarNoBotaoDeveDeletar()
        {
            var buscaPO = new BuscaPO(driver);
            buscaPO.Visitar();

            buscaPO.Deletar();

            Assert.Contains("Wellington", driver.PageSource);
        }
    }
}
