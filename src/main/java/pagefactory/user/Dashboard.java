package pagefactory.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    private WebDriver driver;

    @FindBy(id = "menu_pim_viewMyDetails")
    WebElement myInfoButton;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PersonalDetails clickMyInfo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myInfoButton.click();
        return new PersonalDetails(driver);
    }
}


