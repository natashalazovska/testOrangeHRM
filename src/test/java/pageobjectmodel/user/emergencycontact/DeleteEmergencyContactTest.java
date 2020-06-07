package pageobjectmodel.user.emergencycontact;

import org.testng.annotations.Test;
import pageobjectmodel.base.BaseTest;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.EmergencyContact;
import pageobjectmodel.user.PersonalDetails;

public class DeleteEmergencyContactTest extends BaseTest {

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

    @Test
    public void deleteAllEmergencyContact() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        EmergencyContact emergencyContact = personalDetails.getMyInfoSideNavigation().navigateToEmergencyContact();

        EmergencyContactHelper.createEmergencyContacts(emergencyContact);

        emergencyContact.selectAllContacts();
        emergencyContact.deleteContact();
        EmergencyContactHelper.assertValidationMessage(emergencyContact, "Successfully Deleted");
    }
}
