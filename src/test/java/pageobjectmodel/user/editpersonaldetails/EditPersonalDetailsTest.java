package pageobjectmodel.user.editpersonaldetails;

import pageobjectmodel.base.BaseTest;
import org.testng.annotations.Test;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.PersonalDetails;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditPersonalDetailsTest extends BaseTest {

    @Test
    public void testEditPersonalDetailSuccessfully() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();

        personalDetails.editFirstName("Kristina");
        personalDetails.editMiddleName("K");
        personalDetails.editLastName("Lim");
        personalDetails.editOtherID("12345678901234567890");
        personalDetails.chooseMaleFromGender();
        personalDetails.selectMaritalStatusFromDropDown("Single");
        personalDetails.selectNationalityFromDropDown("Zambian");
        personalDetails.clickSave();
        String message = "Successfully Saved";

        assertTrue(personalDetails.getSuccessfulSaveMessage().contains(message));
    }

    @Test
    public void testCheckIsNationalitySelected() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();

        personalDetails.selectNationalityFromDropDown("Zambian");
        personalDetails.clickSave();

        assertEquals(personalDetails.getSelectedNationality(), "Zambian");
    }

    @Test
    public void testEditPersonalDetailsWithoutFirstName() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();

        personalDetails.editFirstName("");
        personalDetails.editMiddleName("Ina");
        personalDetails.editLastName("Anderson");
        personalDetails.editOtherID("12345678901234567890");
        personalDetails.chooseFemaleFromGender();
        personalDetails.selectMaritalStatusFromDropDown("Other");
        personalDetails.clickSave();

        assertEquals(personalDetails.getFirstNameValidationMessage(), "Required");
    }

    @Test
    public void testEditPersonalDetailsWithoutLastName() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();

        personalDetails.editFirstName("Linda");
        personalDetails.editMiddleName("Ina");
        personalDetails.editLastName("");
        personalDetails.editOtherID("123456677");
        personalDetails.chooseMaleFromGender();
        personalDetails.selectMaritalStatusFromDropDown("Married");
        personalDetails.clickSave();

        assertEquals(personalDetails.getLastNameValidationMessage(), "Required");
    }

    @Test
    public void testCheckIfMaritalStatusCanBeChanged() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();

        personalDetails.selectMaritalStatusFromDropDown("Married");
        personalDetails.clickSave();
        assertEquals(personalDetails.getMaritalStatusDropDown(), "Married");

        personalDetails.clickEdit();
        personalDetails.selectMaritalStatusFromDropDown("Other");
        personalDetails.clickSave();
        assertEquals(personalDetails.getMaritalStatusDropDown(), "Other");
    }


}
