package pagefactory.user.login;

import org.testng.annotations.Test;
import pagefactory.base.BaseTest;
import pagefactory.user.Dashboard;
import pagefactory.user.EmergencyContact;
import pagefactory.user.PersonalDetails;

public class EmergencyContactTest extends BaseTest {

    @Test
    public void assignEmergencyContact() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.clickMyInfo();
        EmergencyContact emergencyContact = personalDetails.navigateToEmergencyContact();
        emergencyContact.setAddContact();
        emergencyContact.setContactName("linda");
        emergencyContact.setRelationship("mam");
        emergencyContact.setHomePhone(1234556);
        emergencyContact.setSaveButton();
    }

    @Test
    public void deleteAllEvenEmergencyContact() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.clickMyInfo();
        EmergencyContact emergencyContact = personalDetails.navigateToEmergencyContact();

        createEmergencyContacts(emergencyContact);

        emergencyContact.setSelectAllEvenContact();
        emergencyContact.deleteContact();
    }

    private void createEmergencyContacts(EmergencyContact emergencyContact) {
        for (int i = 0; i < 4; i++) {
            emergencyContact.setAddContact();
            emergencyContact.setContactName("linda");
            emergencyContact.setRelationship("mam");
            emergencyContact.setHomePhone(1234556);
            emergencyContact.setSaveButton();
        }
    }

    @Test
    public void deleteAllEmergencyContact() {

        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.clickMyInfo();
        EmergencyContact emergencyContact = personalDetails.navigateToEmergencyContact();

        createEmergencyContacts(emergencyContact);

        emergencyContact.selectAllContacts();
        emergencyContact.deleteContact();
    }
}
