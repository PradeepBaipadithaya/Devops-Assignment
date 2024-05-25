package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OPDQueue {
    private WebDriver driver;

    // Constructor
    public OPDQueue(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOpdQueue() {
        try {
            // Locate the <a> tag by link text and click it
            WebElement linkByText = driver.findElement(By.linkText("OPD Queue"));
            linkByText.click();
            Thread.sleep(300);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
