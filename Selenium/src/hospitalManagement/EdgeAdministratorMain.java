package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EdgeAdministratorMain {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.get("http://localhost:8081/HospitalManagement");


        try {

            WebElement button = driver.findElement(By.cssSelector(".btn.btn-primary"));
            // Click the button
            button.click();

            WebElement selectElement = driver.findElement(By.id("exampleSelect1"));

            // Create a new Select object
            Select select = new Select(selectElement);

            // Select the "Administrator" option by its value
            select.selectByValue("administrator");

            testLogin(driver);

            testPersonalInfo(driver);

            testAddEmployee(driver);

            testSearchEmployee(driver);

            testAllEmployee(driver);

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
        loginPage.setUsername("EMP104");
        loginPage.setPassword("rid12345");
        loginPage.clickSubmit();
    }

    private static void testPersonalInfo(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Personal Info")));
        element.click();
    }

    private static void testAddEmployee(WebDriver driver) {
        AddEmployee addEmployee = new AddEmployee(driver);
        addEmployee.addEmployeInfo();
    }

    private static void testSearchEmployee(WebDriver driver) throws InterruptedException {
        SearchPatient searchEmployee = new SearchPatient(driver);
        WebElement linkByText = driver.findElement(By.linkText("Search Employee"));
        linkByText.click();
        searchEmployee.setFirstName("Employee1");
        searchEmployee.setLastName("Employee1");
        searchEmployee.clickSearchByName();

        driver.navigate().back();


        WebElement IDElement = driver.findElement(By.xpath("//label[contains(text(), 'Id')]/following-sibling::input"));
        IDElement.sendKeys("EMP107");
        WebElement submitButtonElement = driver.findElement(By.xpath("//form[@action='searchEmployeeById.html']//button[@type='submit']"));
        submitButtonElement.click();
    }



    private static void testAllEmployee(WebDriver driver) throws InterruptedException {
        WebElement linkByText = driver.findElement(By.linkText("All Employees"));
        linkByText.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
