package pageobjectmodel.user.editcontactdetails;

import pageobjectmodel.base.BaseTest;
import org.testng.annotations.Test;
import pageobjectmodel.user.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditContactDetailsTest extends BaseTest {
    @Test
    public void testEditContactsWithInvalidHomeTelephone() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();
        contactDetails.clickEdit();
        contactDetails.setHomePhoneInput("1@rrr12rrrrrrrrrr");
        contactDetails.clickSave();

        assertEquals(contactDetails.getHomeTelephoneValidationMessage(), "Allows numbers and only + - / ( )");
    }

    @Test
    public void testEditContactDetailsWithInvalidMobileNumber() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();
        contactDetails.clickEdit();
        contactDetails.setMobilePhoneInput("12345fg679");
        contactDetails.clickSave();

        assertEquals(contactDetails.getMobileValidationMessage(), "Allows numbers and only + - / ( )");
    }

    @Test
    public void testEditContactDetailsWithInvalidWorkTelephone() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();
        contactDetails.clickEdit();
        contactDetails.setWorkTelephone("123456df6677");
        contactDetails.clickSave();

        assertEquals(contactDetails.getWorkTelephoneValidationMessage(), "Allows numbers and only + - / ( )");
    }

    @Test
    public void testEditContactDetailsWithInvalidWorkEmailFormat() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();
        contactDetails.clickEdit();
        contactDetails.setWorkEmail("asdx");
        contactDetails.clickSave();

        assertEquals(contactDetails.getWorkEmailValidationMessage(), "Expected format: admin@example.com");
    }

    @Test
    public void testEditContactsWithInvalidOtherEmailFormat() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();
        contactDetails.clickEdit();
        contactDetails.setOtherEmail("fedfer");
        contactDetails.clickSave();

        assertEquals(contactDetails.getOtherEmailValidationMessage(), "Expected format: admin@example.com");
    }

    @Test
    public void testEditContactDetailsAndSuccessfullySaveThem() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();

        contactDetails.clickEdit();
        contactDetails.setAddressStreetFirstLine("Zagorodnoye sh., 5, building 1,");
        contactDetails.setAddressStreetSecondLine("edcxecxe");
        contactDetails.setCityInput("Moscow");

        contactDetails.setZipPostalCodeInput("117152");
        contactDetails.setCountryAndStateProvince("Russian Federation", "");
        contactDetails.setHomePhoneInput("+7 495 126-75-12");
        contactDetails.setMobilePhoneInput("2345678903(");
        contactDetails.setWorkTelephone("15426598475125");
        contactDetails.setWorkEmail("linda78@yahoo.com");
        contactDetails.setOtherEmail("anderson@gmail.com");
        contactDetails.clickSave();

        String message = "Successfully Saved";
        assertTrue(contactDetails.getSuccessfullySavedMessage().contains(message));
    }

    @Test
    public void testEditContactDetailsWhenCountryIsUnitedState() {
        Dashboard dashboard = login.loginWithEssUser();
        PersonalDetails personalDetails = dashboard.getHeaderNavigation().clickMyInfo();
        ContactDetails contactDetails = personalDetails.getMyInfoSideNavigation().navigateToContactDetails();
        contactDetails.clickEdit();

        contactDetails.setAddressStreetFirstLine("202 N Main ");
        contactDetails.setAddressStreetSecondLine("edcxecxe");
        contactDetails.setCityInput("Logan");
        contactDetails.setCountryAndStateProvince("United States", "Utah");
        contactDetails.setZipPostalCodeInput("117152");
        contactDetails.clickSave();

        String message = "Successfully Saved";
        assertTrue(contactDetails.getSuccessfullySavedMessage().contains(message));
    }
}
