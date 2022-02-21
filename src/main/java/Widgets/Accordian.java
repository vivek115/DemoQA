package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
public class Accordian {
    WebDriver driver;

    public Accordian(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    private WebElement Widgets_TAB;
    @FindBy(xpath = "//span[contains(text(),'Accordian')]")
    private WebElement Click_on_accordians;
    @FindBy(xpath = "//div[contains(text(),'Where does it come from?')]")
    private WebElement Click_on_Wherefield;
    @FindBy(xpath = "//div[contains(text(),'Why do we use it?')]")
    private WebElement Click_on_Usefield;
    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement Prompt_alert;

    public void click_accordiantab() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Widgets_TAB.click();
        Click_on_accordians.click();
    }
    public void verifyaccordianpage(){
        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/accordian";
        Assert.assertEquals(actual,expected,"Accordian page is not verified");
    }
    public void accordian(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String message = driver.findElement(By.xpath("(//div[@class='card-body'])[1]")).getText();
        System.out.println(message);
        Click_on_Wherefield.click();
        String message1 = driver.findElement(By.xpath("(//div[@class='card-body'])[2]")).getText();
        System.out.println(message);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Click_on_Wherefield.click();
        Click_on_Usefield.click();
        String message2 = driver.findElement(By.xpath("(//div[@class='card-body'])[3]")).getText();
        System.out.println(message);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Click_on_Usefield.click();
    }
}