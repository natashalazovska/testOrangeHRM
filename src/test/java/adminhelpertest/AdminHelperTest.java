package adminhelpertest;

import page.adminhelper.AddUsers;
import page.adminhelper.Admin;
import page.adminhelper.EditUser;
import page.adminhelper.Header;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * This is helper test.database of orangeHrm is resetting every 2 hours.
 */
public class AdminHelperTest extends BaseTest {
    @Test
    public void testChangePasswordForLindaAnderson() {
        Header header = login.loginWithAdmin();
        Admin adminAddUser = header.clickSystemUser();
        EditUser edit = adminAddUser.searchUser("linda.anderson");
        edit.changePasswordForEssUser("linda123", "linda123");
        assertTrue(adminAddUser.isAddButtonDisplayed());
    }

    @Test
    public void testCreateNewUserWithValidEmployeeNameUsernameAndPassword() {
        Header header = login.loginWithAdmin();

        Admin adminAddUser = header.clickSystemUser();
        AddUsers addNewUser = adminAddUser.addUsers();
        addNewUser.setUserRoleDropDown("ESS");
        addNewUser.setEmployeeNameInput("Steven Edwards");
        addNewUser.setUserNameInput("linda.45");
        addNewUser.setStatusDropDown("Enabled");
        addNewUser.setPasswordInput("Linda@!1234567834");
        addNewUser.setConfirmPasswordInput("Linda@!1234567834");
        addNewUser.clickSaveButton();
    }
}
