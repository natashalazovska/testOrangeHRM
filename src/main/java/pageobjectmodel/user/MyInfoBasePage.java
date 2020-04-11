package pageobjectmodel.user;

import org.openqa.selenium.WebDriver;

public abstract class MyInfoBasePage {

    private Header headerNavigation;
    private MyInfoSideNavigation myInfoSideNavigation;


    protected MyInfoBasePage(WebDriver driver) {
        this.headerNavigation = new Header(driver);
        this.myInfoSideNavigation = new MyInfoSideNavigation(driver);
    }

    public Header getHeaderNavigation() {
        return headerNavigation;
    }

    public MyInfoSideNavigation getMyInfoSideNavigation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myInfoSideNavigation;
    }
}
