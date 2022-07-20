package definitions.master;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerDefinitions {
  WebDriver driver;
  
  @Given("customer sedang berada di halaman add customer {string}")
  public void customer_sedang_berada_di_halaman_add_customer(String string) {
    System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(string);
  }

  @When("customer memilih {string}")
  public void customer_memilih(String string) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('" + string + "').checked = true;");
  }

  @When("customer memasukan nama {string} dan {string}")
  public void customer_memasukan_nama_dan(String string, String string2) {
    try {
      driver.findElement(By.id("fname")).sendKeys(string);
      driver.findElement(By.id("lname")).sendKeys(string2);
    } catch (WebDriverException e) {}
  }

  @When("customer memasukan email {string}")
  public void customer_memasukan_email(String string) {
    try {
      driver.findElement(By.id("email")).sendKeys(string);
    } catch (WebDriverException e) {}
    
  }

  @When("customer memasukan alamat {string}")
  public void customer_memasukan_alamat(String string) {
    try {
//      String actual = new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.xpath("//header/h2"))).getText();
      driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(string);
    } catch (WebDriverException e) {}
//   
  }
  
  

  @When("customer memasukan nomor telepon {string}")
  public void customer_memasukan_nomor_telepon(String string) {
    try {
      driver.findElement(By.id("telephoneno")).sendKeys(string);
    } catch (WebDriverException e) {}
    
  }
  
  @When("customer klik submit dan diproses")
  public void customer_klik_submit_dan_diproses() {
    try {
      driver.findElement(By.xpath("//input[@type='submit']")).click();
    } catch (WebDriverException e) {}
    
  }

  @Then("customer harus mendapatkan pesan sukses {string}")
  public void customer_harus_mendapatkan_pesan_sukses(String string) {
    try {
      String actual = new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.xpath("//header/h2"))).getText();
//    String actual = driver.findElement(By.xpath("//heading/h2")).getText();
      assertEquals(actual, string);
    } catch (WebDriverException e) {} finally {
      driver.close();
    }
  }
  
  @When("customer fill data {string} , {string}, {string} dan {string}")
  public void customer_fill_data_dan(String fname, String lastName, String message, String phone) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("document.getElementById('done').checked = false;");
      driver.findElement(By.id("fname")).sendKeys(fname);
      driver.findElement(By.id("lname")).sendKeys(lastName);
      driver.findElement(By.id("email")).sendKeys("");
      driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(message);
      driver.findElement(By.id("telephoneno")).sendKeys(phone);
    } catch (WebDriverException e) {}
  }

  @Then("customer harus mendapatkan pesan alert {string}")
  public void customer_harus_mendapatkan_pesan_alert(String string) {
    Alert alert = driver.switchTo().alert();
    String actual = alert.getText();
    
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    alert.accept();
    assertEquals(actual, string);
    driver.close();
  }
}
