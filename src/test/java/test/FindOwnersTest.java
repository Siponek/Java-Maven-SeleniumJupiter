package test;

import POs.FindOwnersPageObject;
import POs.OwnerInformationPageObject;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumJupiter.class)
public class FindOwnersTest {
    ChromeDriver driver;
    FindOwnersPageObject findOwnersPage;
    OwnerInformationPageObject ownerInfoPage;

    @BeforeEach
    public void setup(ChromeDriver driver) {
        this.driver = driver;
        findOwnersPage = new FindOwnersPageObject(driver);
        ownerInfoPage = new OwnerInformationPageObject(driver);
        findOwnersPage.visit("http://localhost:8080/owners/find");
    }

    @Test
    public void searchOwnerFromList() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        assertEquals("George Franklin", ownerInfoPage.getOwnerName("George Franklin"), ANSI_BLUE + "Owner name is not correct" + ANSI_RESET);
    }

    @Test
    public void searchExistingOwner() {
        findOwnersPage.searchForOwnerName("Black");
        assertEquals("Jeff Black", ownerInfoPage.getOwnerName("Black"), ANSI_BLUE + "Owner name is not correct" + ANSI_RESET);
    }

    @Test
    public void searchNonExistentOwner() {
        findOwnersPage.searchForOwnerName("Bianchi");
        boolean isErrorMessageDisplayed = findOwnersPage.isErrorDisplayed("has not been found");
        assertTrue(isErrorMessageDisplayed, ANSI_BLUE + "Error message is not displayed" + ANSI_RESET);
    }
}
