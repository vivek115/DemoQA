package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Frames {
    WebDriver driver;

    public Frames(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement Alerts_TAB;
    @FindBy(xpath = "(//span[contains(text(),'Frames')])[1]")
    private WebElement Click_on_frame;
    @FindBy(xpath = "(//span[contains(text(),'Frames')])[2]")
    private WebElement Click_on_nestedframe;
    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement See_alert;
    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement Confirm_ALert;
    public void handle_frame(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Alerts_TAB.click();
        Click_on_frame.click();
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        String actual = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(actual);
        String expected = "This is a sample page";
        Assert.assertEquals(actual, expected, "page is not verified");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        String actual1 = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(actual);
        String expected1 = "This is a sample page";
        Assert.assertEquals(actual, expected, "page is not verified");
        driver.switchTo().defaultContent();
    }
    public void nested_frame(){
        Click_on_nestedframe.click();
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        String actual = driver.findElement(By.xpath("//body")).getText();
        System.out.println(actual);
        String expected = "Parent frame";
        Assert.assertEquals(actual, expected, "page is not verified");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        String actual1 = driver.findElement(By.xpath("//body")).getText();
        System.out.println(actual);
        String expected1 = "Child Iframe";
        Assert.assertEquals(actual, expected, "page is not verified");
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

    }
}
