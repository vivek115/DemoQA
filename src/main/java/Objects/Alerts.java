package Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Alerts {
    WebDriver driver;

    public Alerts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement Alerts_TAB;
    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    private WebElement Click_on_alert;
    //    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']/child::div[contains(text(),'Alerts')]")
//    private WebElement verify_page;
    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement See_alert;
    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement Confirm_ALert;
    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement Prompt_alert;


    public void handing_alerts() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Alerts_TAB.click();
        Click_on_alert.click();
    }
    public void VerifyAlertPage() {
        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/alerts";
        Assert.assertEquals(actual, expected, "Alert page is not verified");
    }

    public void verifyallalerts() {
        See_alert.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        alert.accept();
        Confirm_ALert.click();
        String alertMessage1 = driver.switchTo().alert().getText();
        System.out.println(alertMessage1);
        alert.accept();
        Prompt_alert.click();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        alert.sendKeys("hello everyone");
        alert.accept();
    }
}

