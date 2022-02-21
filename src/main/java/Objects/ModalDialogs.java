package Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ModalDialogs {
    WebDriver driver;

    public ModalDialogs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement Alerts_TAB;
    @FindBy(xpath = "//span[contains(text(),'Modal Dialogs')]")
    private WebElement Click_on_modaldialogs;
    @FindBy(xpath = "//button[@id='showSmallModal']")
    private WebElement Click_on_smallmodal;
    @FindBy(xpath = "//button[@id='showLargeModal']")
    private WebElement Click_on_largemodal;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement Click_on_closebutton;

    public void small_modal() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Alerts_TAB.click();
        Click_on_modaldialogs.click();
        Click_on_smallmodal.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String Message = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(Message);
        Click_on_closebutton.click();
    }
    public void large_modal(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Click_on_largemodal.click();
        String Message = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(Message);
        Click_on_closebutton.click();
    }
}

