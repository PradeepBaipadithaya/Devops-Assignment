package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("exampleInputEmail1");
    private By passwordField = By.id("exampleInputPassword1");
    private By submitButton = By.cssSelector(".btn.btn-primary");  // Updated locator to use class selector

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements on the login page
    public void setUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
        try {
            Thread.sleep(300);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        submitButtonElement.click();
        try {
            Thread.sleep(300);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
