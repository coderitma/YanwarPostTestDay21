package definitions.auth;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinitions {
  WebDriver driver;
  
  @Given("User sedang berada di halaman login")
  public void user_sedang_berada_di_halaman_login() {
    System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://demo.guru99.com/V1/index.php");
  }

  @When("User memasukan userID {string}")
  public void user_memasukan_userID(String string) {
    driver.findElement(By.name("uid")).sendKeys(string);
  }

  @When("User memasukan password {string}")
  public void user_memasukan_password(String string) {
    driver.findElement(By.name("password")).sendKeys(string);
  }

  @When("User menekan tombol login dan sistem memprosesnya")
  public void user_menekan_tombol_login_dan_sistem_memprosesnya() {
    try {
      driver.findElement(By.name("btnLogin")).submit();
    } catch (WebDriverException e) {}
  }

  @Then("User harus berada di halaman {string}")
  public void user_harus_berada_di_halaman(String string) {
    String actual = driver.findElement(By.className("heading3")).getText();
    assertEquals(actual, string);
    driver.close();
  }

  @Then("User harus melihat alert berisi {string}")
  public void user_harus_melihat_alert_berisi(String string) {
    Alert alert = driver.switchTo().alert();
    String actual = alert.getText();
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    alert.accept();
    assertEquals(actual, string);
    driver.close();
  }
}
