package pageobjectmodel.user.emergencycontact;

import pageobjectmodel.user.EmergencyContact;

import static org.testng.Assert.assertTrue;

public class EmergencyContactHelper {

    static void createEmergencyContacts(EmergencyContact emergencyContact) {
        for (int i = 0; i < 4; i++) {
            emergencyContact.clickAddContact();
            emergencyContact.setContactName("linda");
            emergencyContact.setRelationship("mam");
            emergencyContact.setHomePhone("1232435456");
            emergencyContact.clickSaveButton();

            assertValidationMessage(emergencyContact, "Successfully Saved");
        }
    }

    static void assertValidationMessage(EmergencyContact emergencyContact, String message) {
        assertTrue(emergencyContact.getSuccessfulValidationMessage().contains(message));
    }
}
