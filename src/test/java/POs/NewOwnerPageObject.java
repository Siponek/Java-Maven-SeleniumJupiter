package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// page_url = http://localhost:8080/

public class NewOwnerPageObject extends BasePagePO {
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By addressField = By.id("address");
    private final By cityField = By.id("city");
    private final By telephoneField = By.id("telephone");
    private final By addOwnerButton = By.xpath("//button[@type='submit']"); // this might need to be adjusted depending on the actual HTML
    private final By errorMessage = By.className("errors"); // this might need to be adjusted depending on the actual HTML

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        WebElement errorMessageElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.help-inline")));
        return errorMessageElement.getText();
    }

    public List<String> getErrorMessages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        List<WebElement> errorMessageElements = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span.help-inline")));
        List<String> errorMessages = new ArrayList<>();
        for (WebElement element : errorMessageElements) {
            errorMessages.add(element.getText());
        }
        return errorMessages;
    }
    public String getDisplayedOwnerName() {
//        WebElement ownerNameElement = find(By.cssSelector("table.table.table-striped tbody tr:nth-child(1) td"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait up to 10 seconds
        By selector = By.cssSelector("table.table.table-striped tbody tr:nth-child(1) td");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        return element.getText();
    }

    public NewOwnerPageObject(WebDriver driver) {
        super(driver);
    }

    public void addOwner(String firstName, String lastName, String address, String city, String telephone) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(addressField, address);
        type(cityField, city);
        type(telephoneField, telephone);
        click(addOwnerButton);
    }

//    public String getErrorMessage() {
//        return find(errorMessage).getText();
//    }
}
