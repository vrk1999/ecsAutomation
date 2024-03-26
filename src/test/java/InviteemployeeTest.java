import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class InviteemployeeTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public InviteemployeeTest(WebDriver driver) {
        this.driver = driver;
    }


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void inviteemployee() {
        driver.get("http://ecs.memss.co.uk/");
        driver.manage().window().setSize(new Dimension(1512, 852));
        driver.findElement(By.cssSelector(".nav-item:nth-child(3) span")).click();
        driver.findElement(By.cssSelector(".align-items-end > .btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Add Employee")));

        driver.findElement(By.id("Title")).click();
        driver.findElement(By.id("Title")).sendKeys("Mr");
        driver.findElement(By.cssSelector(".mb-3 > #ForeNames")).sendKeys("Sam");
        driver.findElement(By.id("LastName")).sendKeys("Curran");
        driver.findElement(By.id("PrimaryEmailAddress")).click();
        driver.findElement(By.id("PrimaryEmailAddress")).sendKeys("ram.koushik+samcurran@jdrealit.com");
        driver.findElement(By.id("Job Title")).click();
        driver.findElement(By.id("Job Title")).sendKeys("QA");
        driver.findElement(By.id("EmploymentStartDate")).click();
        driver.findElement(By.id("EmploymentStartDate")).sendKeys("2023-09-28");
        driver.findElement(By.id("DateOfBirth")).click();
        driver.findElement(By.id("DateOfBirth")).sendKeys("2003-09-04");
        driver.findElement(By.cssSelector(".form-check-label")).click();
        driver.findElement(By.id("select2-UserRoleId-container")).click();
        driver.findElement(By.cssSelector(".btn-success")).click();
    }
}
