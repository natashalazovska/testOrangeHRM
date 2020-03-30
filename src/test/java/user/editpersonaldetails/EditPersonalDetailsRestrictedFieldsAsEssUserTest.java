package user.editpersonaldetails;

import base.BaseTest;
import org.testng.annotations.Test;
import page.user.Dashboard;
import page.user.PersonalDetails;

import static org.testng.Assert.assertFalse;

public class EditPersonalDetailsRestrictedFieldsAsEssUserTest extends BaseTest {

    @Test
    public void testEditRestrictedFields() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();

        assertFalse(personalDetails.isEmployeeIdEditable());
        assertFalse(personalDetails.isDriverLicenseNumberIsEditable());
        assertFalse(personalDetails.isDateOfBirthEditable());
    }
}

