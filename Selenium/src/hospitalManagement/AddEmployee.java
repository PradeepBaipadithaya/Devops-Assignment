package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class AddEmployee {
    private WebDriver driver;

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployeInfo() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Employee")));
        element.click();

        Random random = new Random();

        // Generate a random email address
        String email = "user" + random.nextInt(1000) + "@example.com";

        // Generate a random mobile number (10 digits)
        StringBuilder mobileNo = new StringBuilder("9"); // Start with 9 to make it a valid mobile number
        for (int i = 0; i < 9; i++) {
            mobileNo.append(random.nextInt(10)); // Append random digits
        }

        // Generate a random Aadhar number (12 digits)
        StringBuilder adharNo = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            adharNo.append(random.nextInt(10)); // Append random digits
        }

        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        firstNameInput.sendKeys("John");

        WebElement middleNameInput = driver.findElement(By.name("middleName"));
        middleNameInput.sendKeys("Doe");

        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        lastNameInput.sendKeys("Smith");

        WebElement birthdateInput = driver.findElement(By.name("birthdate"));
        birthdateInput.sendKeys("2000-01-01");

        WebElement genderDropdown = driver.findElement(By.name("gender"));
        genderDropdown.sendKeys("male");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(""+email);

        WebElement mobileNoInput = driver.findElement(By.name("mobileNo"));
        mobileNoInput.sendKeys(""+mobileNo);

        WebElement adharNoInput = driver.findElement(By.name("adharNo"));
        adharNoInput.sendKeys(""+adharNo);

        WebElement countryInput = driver.findElement(By.name("country"));
        countryInput.sendKeys("Country");

        WebElement stateInput = driver.findElement(By.name("state"));
        stateInput.sendKeys("State");

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys("City");

        WebElement residentialAddressInput = driver.findElement(By.name("residentialAddress"));
        residentialAddressInput.sendKeys("Residential Address");

        WebElement permanentAddressInput = driver.findElement(By.name("permanentAddress"));
        permanentAddressInput.sendKeys("Permanent Address");

        WebElement roleDropdown = driver.findElement(By.name("role"));
        roleDropdown.sendKeys("doctor");

        WebElement qualificationInput = driver.findElement(By.name("qualification"));
        qualificationInput.sendKeys("Qualification");

        WebElement specializationInput = driver.findElement(By.name("specialization"));
        specializationInput.sendKeys("Specialization");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Submit the form
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

    }
}
