import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HRPortalLoginTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            List<String[]> loginDataList = ExcelUtility.getAllLoginData("/Users/ramkoushikreddy/Downloads/testDataLogin.xlsx");

            for (String[] loginData : loginDataList) {
                driver.get("http://ecs.memss.co.uk"); // Replace with actual URL

                LoginPage loginPage = new LoginPage(driver);
                loginPage.setUsername(loginData[0]); // Set username
                loginPage.setPassword(loginData[1]); // Set password
                loginPage.clickLogin();

                // Add validation and a brief wait here if necessary
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
