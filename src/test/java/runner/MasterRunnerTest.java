package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = "src/test/resources/master", 
  glue="definitions.master",
  plugin= {
      "pretty",
      "html:target/guruinc-reports-master",
      "json:target/guruinc-reports-master/master.json",
  })
public class MasterRunnerTest extends AbstractTestNGCucumberTests {

}
