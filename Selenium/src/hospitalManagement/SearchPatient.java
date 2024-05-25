package hospitalManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPatient {
    private WebDriver driver;

    private By firstNameField = By.xpath("//label[@for='username']");
    private By lastNameField = By.xpath("//label[@for='password']");
    private By searchButton = By.cssSelector("button.btn.btn-primary");

    // Constructor
    public SearchPatient(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchPatient() {
        try {
            // Locate the <a> tag by link text and click it
            WebElement linkByText = driver.findElement(By.linkText("Search Patient"));
            linkByText.click();
            Thread.sleep(500);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFirstName(String firstName) throws InterruptedException {
            // Locate the input element following the "First name" label
            WebElement firstNameElement = driver.findElement(By.xpath("//label[contains(text(), 'Firstname')]/following-sibling::input"));
            firstNameElement.sendKeys(firstName);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void setLastName(String lastName) {
            // Locate the input element following the "Last name" label
            WebElement lastNameElement = driver.findElement(By.xpath("//label[contains(text(), 'Lastname')]/following-sibling::input"));
            lastNameElement.sendKeys(lastName);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void clickSearchByName() {
            WebElement submitButtonElement = driver.findElement(By.cssSelector(".btn.btn-primary"));
            submitButtonElement.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    public void clickSearchByID(String ID) {
        WebElement IDElement = driver.findElement(By.xpath("//label[contains(text(), 'Id')]/following-sibling::input"));
        IDElement.sendKeys(ID);
        WebElement submitButtonElement = driver.findElement(By.xpath("//form[@action='searchPatientById.html']//button[@type='submit']"));
        submitButtonElement.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }


