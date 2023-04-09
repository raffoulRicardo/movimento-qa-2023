using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Text;

namespace Movimento.Selenium.Fixtures
{
    public class TestFixture : IDisposable
    {
        public IWebDriver Driver { get; private set; }

        //Setup
        public TestFixture()
        {
            new ChromeOptions();
            Driver = new ChromeDriver();
            Driver.Manage().Window.Maximize();
        }

        //TearDown
        public void Dispose()
        {
            Driver.Quit();
        }
    }
}
