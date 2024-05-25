package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDocterMain {
    public static void main(String[] args) {

        // Initialize a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open a webpage
        driver.get("http://localhost:8081/HospitalManagement");


        try {
            WebElement button = driver.findElement(By.cssSelector(".btn.btn-primary"));
            // Click the button
            button.click();

            // Test scenario for login
            testLogin(driver);

            testPersonalInfo(driver);

            testOPDQueue(driver);

            testSearchPatient(driver);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser
            driver.quit();
        }

    }


    public static void testLogin(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.setUsername("EMP101");
        loginPage.setPassword("neel1234");
        loginPage.clickSubmit();
    }

    private static void testPersonalInfo(WebDriver driver) {
        PersonalInfo personalInfo = new PersonalInfo(driver);
        personalInfo.clickPersonalInfo();
    }

    private static void testOPDQueue(WebDriver driver) {
        OPDQueue opdQueue = new OPDQueue(driver);
        opdQueue.clickOpdQueue();
    }

    private static void testSearchPatient(WebDriver driver) throws InterruptedException {
        SearchPatient searchPatient = new SearchPatient(driver);
        searchPatient.clickSearchPatient();
        searchPatient.setFirstName("patient1");
        searchPatient.setLastName("patient1");
        searchPatient.clickSearchByName();

        driver.navigate().back();

        searchPatient.clickSearchByID("P106");

    }

}