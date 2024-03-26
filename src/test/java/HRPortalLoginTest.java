import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HRPortalLoginTest {
    private WebDriver driver;
    private static final String EXCEL_PATH = "/Users/ramkoushikreddy/Downloads/testDataLogin.xlsx";
    public static final String LOGIN_URL = "http://ecs.memss.co.uk";
    private static final String EXPECTED_TITLE = "Dashboard | PixelsHR - All in One Cloud HR Software";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws Exception {
        List<String[]> allLoginData = ExcelUtility.getAllLoginData(EXCEL_PATH);
        Object[][] data = new Object[allLoginData.size()][2];
        int index = 0;
        for (String[] loginData : allLoginData) {
            data[index++] = loginData;
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLoginLogout(String username, String password) {
        driver.get(LOGIN_URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username); // Set username
        loginPage.setPassword(password); // Set password
        loginPage.clickLogin();

        // Validate login by checking the page title
        if (driver.getTitle().equals(EXPECTED_TITLE)) {
            System.out.println("Login successful for user: " + username);
            InviteemployeeTest inviteemployeeTest = new InviteemployeeTest(driver);
            inviteemployeeTest.inviteemployee();
            // Perform Logout Operation
            performLogout();

            // Proceed to next credentials
        } else {
            System.out.println("Login failed for user: " + username);
        }
    }

    private void performLogout() {
        // Use the logout sequence from the provided script
        driver.findElement(By.cssSelector(".d-xl-inline-block")).click();
        driver.findElement(By.cssSelector(".text-dark")).click();
    }
}
