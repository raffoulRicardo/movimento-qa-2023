using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QA.Helpers;

namespace QA.Fixtures
{
    
        public class TestFixture : IDisposable
        {
            public IWebDriver Driver { get; private set; }

            //Setup
            public TestFixture()
            {
                Driver = new ChromeDriver(TestHelper.PastaDoExecutavel);
            }

            //TearDown
            public void Dispose()
            {
                Driver.Quit();
            }
        }
}
