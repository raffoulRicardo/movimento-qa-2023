using Movimento.Selenium.PageObjects;
using Movimento.Selenium.Fixtures;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Text;
using Xunit;
using OpenQA.Selenium.Support;
using OpenQA.Selenium.Support.UI;





namespace Movimento.Selenium.Testes

{
    [Collection("Chrome Driver")]
    public class AoBuscarCadastro
    {
        private IWebDriver driver;

        public AoBuscarCadastro(TestFixture fixture)
        {
            driver = fixture.Driver;    
        }
        
        [Fact]
        public void DadoCadastrosRealizadosBuscarPeloNome()
        {
            
            //arrange
            var cadastroPO = new CadastroPO(driver);
            var botaoBuscarPO = new CadastroPO(driver);
            var botaoExcluirPO = new CadastroPO(driver);

            //arrange + act Realizando Cadastros//
            cadastroPO.Visitar();
            cadastroPO.PreencheFormulario("Márcia Cristina Alves de Oliveira Silva",
             "115.443.166-58","(31) 98881-0650","06/09/1997");
             cadastroPO.SubmeteFormulario();

            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(200);

             cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Sônia Aparecida","123.456.789-10",
             "(31) 99877-5912","12/10/1971");
             cadastroPO.SubmeteFormulario();

             cadastroPO.Visitar();
             cadastroPO.PreencheFormulario("Márcio Marcelo Alves da Silva",
             "109.876.543-21","(31) 98885-0650","16/06/1972");
            cadastroPO.SubmeteFormulario();

            //assert
            Assert.Contains("Sônia Aparecida", driver.PageSource);

            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(200);

            //------------------------------------------------------------//

            //arrange Buscando Cadastro//
             botaoBuscarPO.Visitar();

            //act
            botaoBuscarPO.SubmeteFormulario();

            //assert
            Assert.Contains("Márcio Marcelo Alves da Silva", driver.PageSource);


            //Excluir formulário após o teste.//
            botaoExcluirPO.ExcluiFormulario();

        }

        // - Segundo teste para validar se digitado a busca incorreta o teste passa.//
        [Fact]
        public void DadoCadastrosRealizadosBuscarPeloNomeInvalido()
        {
            
            //arrange
            var cadastroPO = new CadastroPO(driver);
            var botaoBuscarPO = new CadastroPO(driver);
            var botaoExcluirPO = new CadastroPO(driver);

            //arrange + act Realizando Cadastros//
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

            //assert - Uma validação em que o cadastro foi feito corretamente, podendo incluir mais asserts.//
            Assert.Contains("Sônia Aparecida", driver.PageSource);


            //-------------------------------------------------------------------------//

            //arrange Buscando Cadastro.//
             botaoBuscarPO.Visitar();

            //act
            botaoBuscarPO.SubmeteFormulario();

            //assert - Validando que não possui o cadastro com o nome digitado de maneiras diferentes, apenas se for preenchido com o nome completo e minúsculo.//
            Assert.DoesNotContain("Marcio Marcelo Alves da Silva",("Márcio Marcelo Alves da Silva"));
            Assert.DoesNotContain("Marcio",("Márcio Marcelo Alves da Silva"));
            Assert.DoesNotContain("Marcio Marcelo",("Márcio Marcelo Alves da Silva"));
            Assert.DoesNotContain("Marcio Marcelo Alves",("Márcio Marcelo Alves da Silva"));
            Assert.DoesNotContain("MÁRCIO MARCELO ALVES DA SILVA",("Márcio Marcelo Alves da Silva"));
            
            //Botão para excluir a tabela de cadastros assim que finaliza o teste, evitando que o cadastro salva esteja em uma nova aplicação de testes.//
            botaoExcluirPO.ExcluiFormulario();
        }








        //Terceiro Teste Para Realizar A Busca Separadamente - (Pode ser usado para selecionar outros cadastros).//
        [Fact]
        public void DadoCadastrosRealizadosBuscarPeloNomeSeparado()
        {
            //arrange
             var botaoBuscarPO = new CadastroPO(driver);
             var botaoExcluirPO = new CadastroPO(driver);

             botaoBuscarPO.Visitar();

            //act
            botaoBuscarPO.SubmeteFormulario();

            //assert
            Assert.Contains("", driver.PageSource);

            botaoExcluirPO.ExcluiFormulario();
        }
    }
}