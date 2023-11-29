import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Element Locators
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password-input");
    private By loginButtonLocator = By.id("Login-submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButtonLocator).click();
    }
}
