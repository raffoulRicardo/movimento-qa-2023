using System;
using System.Collections.Generic;
using System.Text;
using Movimento.Selenium.Fixtures;
using Xunit;

namespace Movimento.Selenium.Fixtures
{
    [CollectionDefinition("Chrome Driver")]
    public class CollectionFixture : ICollectionFixture<TestFixture>
    {
    }
}
