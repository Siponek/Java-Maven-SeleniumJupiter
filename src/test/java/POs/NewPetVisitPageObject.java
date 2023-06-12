package POs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = http://localhost:8080/owners/1/edit

public class NewPetVisitPageObject extends BasePagePO {
    // example of element, adjust according to your HTML structure
    @FindBy(id = "description")
    private WebElement descriptionInputField;

    @FindBy(id = "add-visit-button")
    private WebElement addVisitButton;

    @FindBy(id = "date")
    public WebElement inputDate;

    @FindBy(xpath = "//*[text() = 'Add Visit']")
    public WebElement buttonAddVisit;

    public NewPetVisitPageObject(WebDriver driver) {
        super(driver);
    }

    public void enterDescription(String description) {
        this.descriptionInputField.sendKeys(description);
    }

    public void setDate(String date) {
        this.inputDate.sendKeys(date);
    }
    public void clickAddVisit() {
        this.buttonAddVisit.click();
    }

    // add other necessary methods for elements/actions on this page
}
