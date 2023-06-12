package test;// Tests/OwnerSearchTest.java
import POs.FindOwnersPageObject;
import POs.OwnerInformationPageObject;
import POs.OwnersPagePageObject;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumJupiter.class)
public class FindOwnersTest {
    OwnersPagePageObject ownersPage;
    FindOwnersPageObject findOwnersPage;
    OwnerInformationPageObject ownerInfoPage;

    @BeforeEach
    public void setup(ChromeDriver driver) {
//        ownersPage = new OwnersPagePageObject(driver);
        findOwnersPage = new FindOwnersPageObject(driver);
        ownerInfoPage = new OwnerInformationPageObject(driver);
        findOwnersPage.visit("http://localhost:8080/owners/find");
    }
    @Test
    public void searchOwnerFromList(ChromeDriver driver) {
        findOwnersPage.searchForAllOwners();
//        might change to "contains" if the text is not exactly the same
        findOwnersPage.clickOnOwner("Franklin");
        assertEquals("George Franklin", ownerInfoPage.getOwnerName("George Franklin"), ANSI_BLUE + "Owner name is not correct" + ANSI_RESET);
    }

    @Test
    public void searchExistingOwner(ChromeDriver driver) {
        findOwnersPage.searchForOwnerName("Black");

        assertEquals("Jeff Black", ownerInfoPage.getOwnerName("Black"), ANSI_BLUE + "Owner name is not correct" + ANSI_RESET);
    }

    @Test
    public void searchNonExistentOwner(ChromeDriver driver) {
        findOwnersPage.searchForOwnerName("Bianchi");
        boolean isErrorMessageDisplayed = findOwnersPage.isErrorDisplayed( "has not been found");
        assertTrue(isErrorMessageDisplayed, ANSI_BLUE + "Error message is not displayed" + ANSI_RESET);
    }
}