package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class AddPatient {
    private WebDriver driver;

    public AddPatient(WebDriver driver) {
        this.driver = driver;
    }

    public void addPatientInfo() {

        WebElement linkByText = driver.findElement(By.linkText("Add Patient"));
        linkByText.click();

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

        // Fill the form fields
        driver.findElement(By.name("firstName")).sendKeys("Patient1");
        driver.findElement(By.name("middleName")).sendKeys("Patient1");
        driver.findElement(By.name("lastName")).sendKeys("Patient1");
        driver.findElement(By.name("birthdate")).sendKeys("1990-01-01");
        // Select "Male" gender
        driver.findElement(By.name("gender")).sendKeys("Male");
        driver.findElement(By.name("email")).sendKeys(""+email);
        driver.findElement(By.name("mobileNo")).sendKeys(""+mobileNo);
        driver.findElement(By.name("adharNo")).sendKeys(""+adharNo);
        driver.findElement(By.name("country")).sendKeys("Country");
        driver.findElement(By.name("state")).sendKeys("State");
        driver.findElement(By.name("city")).sendKeys("City");
        driver.findElement(By.name("residentialAddress")).sendKeys("Residential Address");
        driver.findElement(By.name("permanentAddress")).sendKeys("Permanent Address");
        // Select "A+" blood group
        driver.findElement(By.name("bloodGroup")).sendKeys("A+");
        driver.findElement(By.name("chronicDiseases")).sendKeys("none");
        driver.findElement(By.name("medicineAllergy")).sendKeys("none");
        // Select "neelima arun pawar" as doctor
        driver.findElement(By.name("doctorId")).sendKeys("EMP101");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Submit the form
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

    }
}

