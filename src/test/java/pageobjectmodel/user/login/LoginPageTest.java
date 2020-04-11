package pageobjectmodel.user.login;

import pageobjectmodel.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void validUsernameAndPassword() {
        login.setUserName("admin");
        login.setPassword("admin123");
        login.clickLoginButton();
    }

    @Test
    public void invalidUsernameAndValidPassword() {
        login.setUserName("jana");
        login.setPassword("admin123");
        login.clickLoginButton();
        assertEquals(login.getValidationText(), "Invalid credentials");
    }

    @Test
    public void invalidUsernameAndInvalidPassword() {
        login.setUserName("kiki");
        login.setPassword("jana");
        login.clickLoginButton();
        assertEquals(login.getValidationText(), "Invalid credentials");
    }

    @Test
    public void emptyUsernameAndValidPassword() {
        login.setUserName("");
        login.setPassword("admin123");
        login.clickLoginButton();
        assertEquals(login.getValidationText(), "Username cannot be empty");
    }

    @Test
    public void validUsernameAndEmptyPassword() {
        login.setUserName("admin");
        login.setPassword("");
        login.clickLoginButton();
        assertEquals(login.getValidationText(), "Password cannot be empty");
    }

    @Test
    public void invalidUsernameAndEmptyPassword() {
        login.setUserName("kiki");
        login.setPassword("");
        login.clickLoginButton();
        assertEquals(login.getValidationText(), "Password cannot be empty");
    }

    @Test
    public void emptyUsernameAndEmptyPassword() {
        login.setUserName("");
        login.setPassword("");
        login.clickLoginButton();
        assertEquals(login.getValidationText(), "Username cannot be empty");
    }
}
