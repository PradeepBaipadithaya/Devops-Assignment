package hospitalManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    public static void main(String[] args) {
        // Define the URL of the Selenium Grid Hub
        String hubURL = "http://localhost:4444/wd/hub";

        // Define ChromeOptions for Chrome browser
        ChromeOptions chromeOptions = new ChromeOptions();

        // Define FirefoxOptions for Firefox browser
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        // Define EdgeOptions for Edge browser
        EdgeOptions edgeOptions = new EdgeOptions();

        // Initialize the remote WebDriver instances
        WebDriver chromeDriver = null;
        WebDriver firefoxDriver = null;
        WebDriver edgeDriver = null;
        try {
            chromeDriver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
            firefoxDriver = new RemoteWebDriver(new URL(hubURL), firefoxOptions);
            edgeDriver = new RemoteWebDriver(new URL(hubURL), edgeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Failed to create a session with the Selenium Grid.");
            e.printStackTrace();
        }

        // Check if WebDriver instances are initialized successfully
        if (chromeDriver != null && firefoxDriver != null && edgeDriver != null) {
            // Open webpages in respective browsers
            openWebpage(chromeDriver, "http://localhost:8081/HospitalManagement");
            openWebpage(firefoxDriver, "http://localhost:8081/HospitalManagement");
            openWebpage(edgeDriver, "http://localhost:8081/HospitalManagement");

            // Perform tests in respective browsers
            performTests(chromeDriver);
            performTests(firefoxDriver);
            performTests(edgeDriver);

            // Quit the browsers
            chromeDriver.quit();
            firefoxDriver.quit();
            edgeDriver.quit();
        } else {
            System.out.println("Driver initialization failed. Please check the Selenium Grid setup.");
        }
    }

    private static void openWebpage(WebDriver driver, String url) {
        // Open a webpage in the specified browser
        driver.get(url);
    }

    private static void performTests(WebDriver driver) {
        // Perform tests on the opened webpage
        // Example:
        try {
            WebElement button = driver.findElement(By.cssSelector(".btn.btn-primary"));
            // Click the button
            button.click();

            // Test scenarios
            testLogin(driver);
            testPersonalInfo(driver);
            testOPDQueue(driver);
            testSearchPatient(driver);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testLogin(WebDriver driver) {
        // Example test scenario for login page
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.setUsername("EMP101");
        loginPage.setPassword("neel1234");
        loginPage.clickSubmit();
    }

    private static void testPersonalInfo(WebDriver driver) {
        // Example test scenario for personal info page
        PersonalInfo personalInfo = new PersonalInfo(driver);
        personalInfo.clickPersonalInfo();
    }

    private static void testOPDQueue(WebDriver driver) {
        // Example test scenario for OPD queue page
        OPDQueue opdQueue = new OPDQueue(driver);
        opdQueue.clickOpdQueue();
    }

    private static void testSearchPatient(WebDriver driver) throws InterruptedException {
        // Example test scenario for search patient page
        SearchPatient searchPatient = new SearchPatient(driver);
        searchPatient.clickSearchPatient();
        searchPatient.setFirstName("patient1");
        searchPatient.setLastName("patient1");
        searchPatient.clickSearchByName();

        driver.navigate().back();

        searchPatient.clickSearchByID("P106");
    }
}
