package pageobjectmodel.user.emergencycontact;

import org.testng.annotations.Test;
import pageobjectmodel.base.BaseTest;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.EmergencyContact;
import pageobjectmodel.user.PersonalDetails;

public class AddEmergencyContactTest extends BaseTest {

    @Test
    public void assignEmergencyContact() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        EmergencyContact emergencyContact = personalDetails.getMyInfoSideNavigation().navigateToEmergencyContact();
        emergencyContact.clickAddContact();
        emergencyContact.setContactName("linda");
        emergencyContact.setRelationship("mam");
        emergencyContact.setHomePhone("1234345");
        emergencyContact.clickSaveButton();

        EmergencyContactHelper.assertValidationMessage(emergencyContact, "Successfully Saved");
    }

    @Test
    public void deleteAllEvenEmergencyContact() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        EmergencyContact emergencyContact = personalDetails.getMyInfoSideNavigation().navigateToEmergencyContact();

        EmergencyContactHelper.createEmergencyContacts(emergencyContact);

        emergencyContact.selectAllEvenContact();
        emergencyContact.deleteContact();

        EmergencyContactHelper.assertValidationMessage(emergencyContact, "Successfully Deleted");
    }
}
