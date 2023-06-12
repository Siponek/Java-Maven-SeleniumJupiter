package POs;// PageObjects/OwnerInformationPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:8080/owners/find
public class OwnerInformationPageObject extends BasePagePO{

    public OwnerInformationPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToEditOwnerPage() {
        click(By.linkText("Edit Owner"));
    }

    public void goToAddNewPet() {
        click(By.linkText("Add New Pet"));
    }

    public void goToEditPetPage() {
        click(By.linkText("Edit Pet"));
    }

    public void goToNewVisitPage() {
        click(By.linkText("Add Visit"));
    }
    public String getOwnerCity(String ownerCityName) {

        WebElement ownerCityElement = driver.findElement(By.xpath("//*[text() = '" + ownerCityName + "']"));

        return ownerCityElement.getText();
    }

    public String getOwnerName(String ownerFullName) {
        WebElement ownerNameElement = driver.findElement(By.xpath("//*[contains(text(), '" + ownerFullName + "')]"));
        return ownerNameElement.getText();
    }
    public String getOwnerAddress(String ownerAddress) {
        WebElement ownerAddressElement = driver.findElement(By.xpath("//*[text() = '" + ownerAddress + "']"));
        return ownerAddressElement.getText();
    }
    public boolean isPetDetailsPresent(String petDetail) {
        WebElement petDetailElement = driver.findElement(By.xpath("//*[contains(text(), '" + petDetail + "')]"));
        return petDetailElement.isDisplayed();
    }


}
