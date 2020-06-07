package pageobjectmodel.user.editpersonaldetails;

import org.testng.annotations.Test;
import pageobjectmodel.base.BaseTest;
import pageobjectmodel.user.Dashboard;
import pageobjectmodel.user.PersonalDetails;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DatePickerTest extends BaseTest {

    @Test
    public void enterDateFromKeyboardWithValidFormat() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();
        personalDetails.enterDateForLicenseExpiryDateFromKeyboard("2020-05-12");
        personalDetails.clickSave();

        String message = "Successfully Saved";
        assertTrue(personalDetails.getSuccessfulSaveMessage().contains(message));
    }

    @Test
    public void enterDateFromKeyboardWithInvalidFormat() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();
        personalDetails.enterDateForLicenseExpiryDateFromKeyboard("10-12-2020");
        personalDetails.clickSave();

        String message = "Should be a valid date in yyyy-mm-dd format";
        assertEquals(personalDetails.getDateValidationMessage(), message);
    }

    @Test
    public void chooseDateFromDatePicker() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        personalDetails.clickEdit();
        personalDetails.openCalendar();

        personalDetails.chooseMonth("9");
        personalDetails.chooseYear("2012");
        personalDetails.chooseDay("13");
        personalDetails.clickSave();

        String message = "Successfully Saved";
        assertTrue(personalDetails.getSuccessfulSaveMessage().contains(message));
    }
}