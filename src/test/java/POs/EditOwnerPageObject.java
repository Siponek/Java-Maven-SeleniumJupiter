package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditOwnerPageObject extends BasePagePO {
//    @FindBy(xpath = "//*[text() = 'must not be empty']")
//    public WebElement spanMustNotEmpty;

    @FindBy(css = "span.help-inline")
    public List<WebElement> spanErrorMessage;

//    @FindBy(xpath = "//*[text() = 'numeric value out of bounds (<10 digits>.<0 digits> expected)']")
//    public WebElement spanNumericValueOutBounds;
//
//    @FindBy(css = "span.help-inline")
//    public List<WebElement> spanNumericValueOutBounds2;

    public EditOwnerPageObject(WebDriver driver) {
        super(driver);
    }

    

    public void  fillElement(By by, String text) {
        WebElement element = find(by);
        element.clear();
        element.sendKeys(text);
    }


    public void editOwner(String firstName, String lastName, String address, String city, String telephone) {
        fillElement(By.id("firstName"), firstName);
        fillElement(By.id("lastName"), lastName);
        fillElement(By.id("address"), address);
        fillElement(By.id("city"), city);
        fillElement(By.id("telephone"), telephone);
    }

    public void editOwnerCity(String city) {
        fillElement(By.id("city"), city);
    }
    public void editOwnerTelephone(String telephone) {
        fillElement(By.id("telephone"), telephone);
    }
    public void editOwnerAddress(String address) {
           fillElement(By.id("address"), address);
    }
    public void editOwnerLastName(String lastName) {
        fillElement(By.id("lastName"), lastName);
    }
    public void editOwnerFirstName(String firstName) {
        fillElement(By.id("firstName"), firstName);
    }

    public void updateOwner() {
        click(By.xpath("//button[text()='Update Owner']"));
    }
}
