package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//page:url = http://localhost:8080/owners/find.html
public class FindOwnersPageObject extends BasePagePO {

    //Xpath returns a single element, so you can use it to find a single element on the page. In this case it is the button with
    //the text "Add Owner". You can use the By.xpath() method to find the element.
    private final By addOwnerButton = By.xpath("//a[@href='/owners/new']");




    public FindOwnersPageObject(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);

    }

    public void goToAddOwnerPage() {
        click(addOwnerButton);
    }

    @FindBy(xpath = "//*[text() = 'Find\n          Owner']")
    public WebElement buttonFindOwner;
    public void searchForAllOwners() {
        buttonFindOwner.click();
    }
    public void searchForOwnerName(String lastName) {
        type(By.id("lastName"), lastName);
        searchForAllOwners();
    }

    public void clickOnOwner(String nameLink) {
        click(By.linkText(nameLink));
        
    }
}

