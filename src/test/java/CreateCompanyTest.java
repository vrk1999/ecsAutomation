import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;

public class CreateCompanyTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createCompany() {
        driver.get("http://ecs.memss.co.uk/Identity/Account/Login?ReturnUrl=%2F");
        driver.manage().window().setSize(new Dimension(1512, 945));
        driver.findElement(By.linkText("Signup")).click();
        driver.findElement(By.id("floatingfirst")).click();
        driver.findElement(By.id("floatingfirst")).sendKeys("User");
        driver.findElement(By.id("floatinglast")).click();
        driver.findElement(By.id("floatinglast")).sendKeys("name");
        driver.findElement(By.id("CompanyName")).click();
        driver.findElement(By.id("CompanyName")).sendKeys("test_company");
        driver.findElement(By.id("EmailAddress")).click();
        driver.findElement(By.id("EmailAddress")).sendKeys("test@email.co.au");
        driver.findElement(By.id("ConfirmEmailAddress")).click();
        driver.findElement(By.id("ConfirmEmailAddress")).sendKeys("test@email.co.au");
        driver.findElement(By.id("select2-employee-count-input-container")).click();
        driver.findElement(By.id("Signup-submit")).click();
    }
}
