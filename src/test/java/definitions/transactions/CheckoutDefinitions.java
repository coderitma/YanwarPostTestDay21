package definitions.transactions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutDefinitions {
  WebDriver driver;
  String xpathButton = "//input[@type='submit']";
  
  @Given("kustomer ada di halaman {string}")
  public void kustomer_ada_di_halaman(String string) {
    System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(string);
  }

  @When("kustomer memasukan quantity {int}")
  public void kustomer_memasukan_quantity(int indexQty) {
    System.out.println(driver.getTitle());
    new Select(driver.findElement(By.name("quantity"))).selectByIndex(indexQty);
  }

  @When("kustomer klik tombol pembelian")
  public void kustomer_klik_tombol_pembelian() {
    try {
      driver.findElement(By.xpath(xpathButton)).submit();
    } catch (WebDriverException e) {}
  }

  @When("kustomer ada di page {string}")
  public void kustomer_ada_di_page(String string) {
    assertEquals(driver.findElement(By.xpath("//header/h2")).getText(), string);
  }

  @When("kustomer fill kartu kredit {string}")
  public void kustomer_fill_kartu_kredit(String string) {
    /**
     * id=card_nmuber
id=month
id=year
id=cvv_code
     */
    driver.findElement(By.id("card_nmuber")).sendKeys(string);
    
  }

  @When("kustomer milih month, tahun dan memasukan code {string}")
  public void kustomer_milih_month_tahun_dan_memasukan_code(String string) {
    new Select(driver.findElement(By.id("month"))).selectByValue("1");
    new Select(driver.findElement(By.id("year"))).selectByValue("2023");
    driver.findElement(By.id("cvv_code")).sendKeys(string);
  }

  @When("kustomer klik tombol bayar")
  public void kustomer_klik_tombol_bayar() {
    try {
      driver.findElement(By.xpath(xpathButton)).click();
    } catch (WebDriverException e) {}
  }

  @Then("kustomer melihat pesan berhasil {string}")
  public void kustomer_melihat_pesan_berhasil(String string) {
//    String actual = new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h2"))).getText();
    assertEquals(driver.findElement(By.xpath("//div/h2")).getText(), string);
    driver.close();
  }

  
}
