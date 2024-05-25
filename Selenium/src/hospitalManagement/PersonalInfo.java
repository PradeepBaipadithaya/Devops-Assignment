package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class PersonalInfo {
    private WebDriver driver;

    // Constructor
    public PersonalInfo(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalInfo() {
        try {
            // Locate the <a> tag by link text and click it
            WebElement linkByText = driver.findElement(By.linkText("Personal Info"));
            linkByText.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


