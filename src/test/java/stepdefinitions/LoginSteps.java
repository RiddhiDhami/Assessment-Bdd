package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;

    @Given("user is on SauceDemo login page")
    public void openLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters valid credentials")
    public void enterCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should land on inventory page")
    public void validateLogin() {
        //Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue("User is not on inventory page", currentUrl.contains("inventory"));
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());
        //ensures the actual page content loaded, not just URL change.
        driver.quit();
    }
}