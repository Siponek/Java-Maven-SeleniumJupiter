package POs;// PageObjects/OwnerInformationPage.java
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

// page_url = http://localhost:8080/owners/find
public class OwnerInformationPageObject extends BasePagePO{

    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[3]/td")
    public WebElement ownerCityName;

    @FindBy(xpath = "//*[text() = 'the first visit']")
    public WebElement tfFirstVisit;

    public OwnerInformationPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToEditOwnerPage() {
        click(By.linkText("Edit Owner"));
    }

    public void goToNewPetPage() {
        click(By.linkText("Add New Pet"));
    }

    public void goToNewVisitPage() {
        click(By.linkText("Add Visit"));
    }
    public String getOwnerCity() {
        return ownerCityName.getText();
    }
}
