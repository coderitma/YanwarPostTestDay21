package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = "src/test/resources/transactions", 
  glue="definitions.transactions",
  plugin= {
      "pretty",
      "html:target/ecommerce-reports-transactions",
      "json:target/ecommerce-reports-transactions/master.json",
  })
public class TransactionsRunnerTest extends AbstractTestNGCucumberTests {

}
