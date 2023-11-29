import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HRPortalLoginTest {
    private static final String EXCEL_PATH = "/Users/ramkoushikreddy/IdeaProjects/ECSAutomation/ExcelData/testDataLogin.xlsx";
    private static final String LOGIN_URL = "http://ecs.memss.co.uk";
    private static final String EXPECTED_TITLE = "Dashboard | PixelsHR - All in One Cloud HR Software";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            List<String[]> loginDataList = ExcelUtility.getAllLoginData(EXCEL_PATH);

            for (String[] loginData : loginDataList) {
                driver.get(LOGIN_URL);

                LoginPage loginPage = new LoginPage(driver);
                loginPage.setUsername(loginData[0]); // Set username
                loginPage.setPassword(loginData[1]); // Set password
                loginPage.clickLogin();

                // Validate login by checking the page title
                if (driver.getTitle().equals(EXPECTED_TITLE)) {
                    System.out.println("Login successful for user: " + loginData[0]);
                } else {
                    System.out.println("Login failed for user: " + loginData[0]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
