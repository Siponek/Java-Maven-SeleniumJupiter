package POs;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

// PageObjects/AddPetPageObject.java
public class PetPageObject extends BasePagePO{

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

    @FindBy(xpath = "//*[text() = 'Update Pet']")
    public WebElement buttonUpdatePet;

    public PetPageObject(WebDriver driver) {
        super(driver);
    }

    public void providePetData(String petName, String birthDate, String type) {
        providePetName(petName);
        providePetBirthDate(birthDate);
        providePetType(type);
    }
    public void providePetName(String petName) {
        this.petName.clear();
        this.petName.sendKeys(petName);
    }
    public void providePetBirthDate(String birthDate) {
        this.birthDate.clear();
        this.birthDate.sendKeys(birthDate);
    }
    public void providePetType(String type) {
        Select petTypeDropdown = new Select(this.petTypeElement);
        petTypeDropdown.selectByVisibleText(type);
    }
    public void clickAddPetButton() {
        buttonAddPet.click();
    }
    public void clickUpdatePetButton() {
        buttonUpdatePet.click();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
