package test;

import POs.FindOwnersPageObject;
import POs.OwnerInformationPageObject;
import POs.PetPageObject;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumJupiter.class)
public class EditPetTest {
    ChromeDriver driver;
    FindOwnersPageObject findOwnersPage;
    OwnerInformationPageObject ownerInfoPage;
    PetPageObject petPage;

    @BeforeEach
    public void setup(ChromeDriver driver) {
        this.driver = driver;
        findOwnersPage = new FindOwnersPageObject(driver);
        ownerInfoPage = new OwnerInformationPageObject(driver);
        petPage = new PetPageObject(driver);
        findOwnersPage.visit("http://localhost:8080/owners/find");
    }

    @Test
    public void editPetBirthDate() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        ownerInfoPage.goToEditPetPage();
        petPage.providePetBirthDate("10102020");
        petPage.clickUpdatePetButton();
        assertTrue(ownerInfoPage.isPetDetailsPresent("2020-10-10"), ANSI_BLUE + "Pet birth date is not updated" + ANSI_RESET);
    }

    @Test
    public void editPetType() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        ownerInfoPage.goToEditPetPage();
        petPage.providePetType("dog");
        petPage.clickUpdatePetButton();
        assertTrue(ownerInfoPage.isPetDetailsPresent("dog"), ANSI_BLUE + "Pet type is not updated" + ANSI_RESET);
    }

    @Test
    public void editPetNameInvalid() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        ownerInfoPage.goToEditPetPage();
        petPage.providePetName("");
        petPage.clickUpdatePetButton();
        assertTrue(petPage.isErrorDisplayed("is required"), ANSI_BLUE + "Error message is not displayed" + ANSI_RESET);
    }
}
