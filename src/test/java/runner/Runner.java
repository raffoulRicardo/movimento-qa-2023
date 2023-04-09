package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = true,
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = "html:src/test/java/target/Relatorio-html.html")
public class Runner {

}