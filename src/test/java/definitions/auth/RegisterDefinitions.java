package definitions.auth;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterDefinitions {
  WebDriver driver;
  
  @Given("User sedang berada di halaman register")
  public void user_sedang_berada_di_halaman_register() {
    System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://demo.guru99.com");
  }

  @When("User memasukan email {string}")
  public void user_memasukan_email(String string) {
    driver.findElement(By.name("emailid")).sendKeys(string);;
  }

  @When("User menekan tombol submit")
  public void user_menekan_tombol_submit() {
    try {
      driver.findElement(By.name("btnLogin")).click();
    } catch (WebDriverException e) {}
    
  }

  @Then("User akan melihat kredensial yang diberikan")
  public void user_akan_melihat_kredensial_yang_diberikan() {
    boolean state = true;
    String expect = "Access details to demo site.";
    
    while (state) {
      try {
        String actual = driver.findElement(By.xpath("//td/h2")).getText();
        assertEquals(actual, expect);
        state = false;
      } catch (Exception e) {}
    }
    
    driver.close();
  }

  @Then("User akan melihat pesan validasi {string}")
  public void user_akan_melihat_pesan_validasi(String string) {
    String actual = driver.findElement(By.id("message9")).getText();
    assertEquals(actual, string);
    driver.close();
  }

}
