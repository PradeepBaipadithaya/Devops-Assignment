package hospitalManagement;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirefoxReceptionistMain {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        // Open a webpage
        driver.get("http://localhost:8081/HospitalManagement");


        try {
            WebElement button = driver.findElement(By.cssSelector(".btn.btn-primary"));
            // Click the button
            button.click();

            WebElement selectElement = driver.findElement(By.id("exampleSelect1"));

            // Create a new Select object
            Select select = new Select(selectElement);

            // Select the "Receptionist" option by its visible text
            select.selectByVisibleText("Receptionist");

            // Test scenario for login
            testLogin(driver);

            testPersonalInfo(driver);

            testAddPatient(driver);

            testSearchPatient(driver);

            testOPDQueue(driver);

            testPrescription(driver);

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void testLogin(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.setUsername("EMP105");
        loginPage.setPassword("neha1234");
        loginPage.clickSubmit();
    }

    private static void testPersonalInfo(WebDriver driver) {
        PersonalInfo personalInfo = new PersonalInfo(driver);
        personalInfo.clickPersonalInfo();
    }

    private static void testSearchPatient(WebDriver driver) throws InterruptedException {
        SearchPatient searchPatient = new SearchPatient(driver);
        searchPatient.clickSearchPatient();
        searchPatient.setFirstName("patient2");
        searchPatient.setLastName("patient2");
        searchPatient.clickSearchByName();

        driver.navigate().back();
//
        searchPatient.clickSearchByID("P106");

    }

    private static void testAddPatient(WebDriver driver) {
        AddPatient addPatient = new AddPatient(driver);
        addPatient.addPatientInfo();
    }

    private static void testOPDQueue(WebDriver driver) {
        OPDQueue opdQueue = new OPDQueue(driver);
        opdQueue.clickOpdQueue();
    }

    private static void testPrescription(WebDriver driver) {
        Prescription prescription = new Prescription(driver);
        prescription.testPrescription();
    }
}
