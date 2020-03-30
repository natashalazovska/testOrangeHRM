package page.user;
import org.openqa.selenium.WebDriver;

public class Dashboard extends MyInfoBasePage {
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    
}
