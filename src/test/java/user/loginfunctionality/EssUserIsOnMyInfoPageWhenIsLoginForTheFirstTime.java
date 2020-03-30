package user.loginfunctionality;

import base.BaseTest;
import org.testng.annotations.Test;

public class EssUserIsOnMyInfoPageWhenIsLoginForTheFirstTime extends BaseTest {
    @Test
    public void EssUserLoginForTheFirstTime() {
        login.setUserName("linda.45");
        login.setPassword("Linda@!1234567834");
        login.clickMyInfoHeader();
    }
}
