package POs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

// page_url = http://localhost:8080/
public class OwnersPagePageObject extends BasePagePO  {
    private final WebDriver driver;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    public OwnersPagePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchByLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
        this.searchButton.click();
    }

    public WebElement findOwnerInTable(String lastName) {
        return driver.findElement(By.xpath("//table//td[contains(text(), '" + lastName + "')]"));
    }


    // Other methods for interacting with the page, e.g., getOwnerPage(String lastName)
}
