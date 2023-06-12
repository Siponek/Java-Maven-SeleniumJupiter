package POs;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

// PageObjects/AddPetPageObject.java
public class AddPetPageObject extends BasePagePO{

    @FindBy(id = "name")
    private WebElement petName;

    @FindBy(id = "birthDate")
    private WebElement birthDate;

    @FindBy(id = "type")
    private WebElement petTypeElement;

    @FindBy(className = "help-inline")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[text() = 'Add Pet']")
    public WebElement buttonAddPet;

    public AddPetPageObject(WebDriver driver) {
        super(driver);
    }

    public void providePetData(String petName, String birthDate, String type) {
        Select petTypeDropdown = new Select(this.petTypeElement);
        this.petName.clear();
        this.petName.sendKeys(petName);
        this.birthDate.clear();
        this.birthDate.sendKeys(birthDate);
        petTypeDropdown.selectByVisibleText(type);
    }
    public void clickAddPetButton() {
        buttonAddPet.click();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
