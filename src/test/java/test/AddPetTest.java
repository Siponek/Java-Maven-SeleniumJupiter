package test;

import POs.PetPageObject;
import POs.FindOwnersPageObject;
import POs.OwnerInformationPageObject;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import static POs.BasePagePO.ANSI_BLUE;
import static POs.BasePagePO.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumJupiter.class)
public class AddPetTest {
    ChromeDriver driver;
    FindOwnersPageObject findOwnersPage;
    OwnerInformationPageObject ownerInfoPage;
    PetPageObject addPetPage;

    @BeforeEach
    public void setup(ChromeDriver driver) {
        this.driver = driver;
        findOwnersPage = new FindOwnersPageObject(driver);
        ownerInfoPage = new OwnerInformationPageObject(driver);
        addPetPage = new PetPageObject(driver);
        findOwnersPage.visit("http://localhost:8080/owners/find");
    }

    @Test
    public void addNewPetWithValidData() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        ownerInfoPage.goToAddNewPet();
        addPetPage.providePetData("Charles12", "05301999", "dog");
        addPetPage.clickAddPetButton();
        assertTrue(ownerInfoPage.isPetDetailsPresent("Charles"), ANSI_BLUE + "New pet is not in list" + ANSI_RESET);
        assertTrue(ownerInfoPage.getOwnerName("Franklin").contains("George Franklin"), ANSI_BLUE + "Owner name is not correct" + ANSI_RESET);
    }

    @Test
    public void tryToAddExistingPet() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        ownerInfoPage.goToAddNewPet();
        addPetPage.providePetData("Leo", "05301999", "bird");
        addPetPage.clickAddPetButton();
        assertTrue( addPetPage.isErrorDisplayed("is already in use"), ANSI_BLUE + "Error message is not correct" + ANSI_RESET);
    }

    @Test
    public void tryToAddPetWithEmptyName() {
        findOwnersPage.searchForAllOwners();
        findOwnersPage.clickOnOwner("Franklin");
        ownerInfoPage.goToAddNewPet();
        addPetPage.providePetData("", "05301999", "dog");
        addPetPage.clickAddPetButton();
        assertTrue(addPetPage.isErrorDisplayed("is required"), ANSI_BLUE + "Error message is not correct" + ANSI_RESET);
    }
}
