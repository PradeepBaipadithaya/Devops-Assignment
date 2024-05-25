package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Prescription {
    private WebDriver driver;

    // Constructor
    public Prescription(WebDriver driver) {
        this.driver = driver;
    }

    public void testPrescription() {
        try {
            // Locate the <a> tag by link text and click it
            WebElement linkByText = driver.findElement(By.linkText("Prescriptions"));
            linkByText.click();
            Thread.sleep(300);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
