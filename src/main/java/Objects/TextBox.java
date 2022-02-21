package Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class TextBox {
    WebDriver driver;
    public TextBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    private WebElement Click_On_Elements;
    @FindBy(xpath = "(//ul[@class='menu-list']//li)[1]")
    private WebElement Click_On_TextBox;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement current_address;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanent_address;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit_button;
    public void elements() {
        Click_On_Elements.click();
        Click_On_TextBox.click();
    }
    public void VerifyTextBoxPage(){
        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/text-box";
        Assert.assertEquals(actual,expected,"TextBox page is not verified");
    }
public void enterdetails(String name){
    Actions actions = new Actions(driver);
    String abc = getSaltString();
    username.sendKeys(abc);
    email.sendKeys(name);
    current_address.sendKeys(abc);
    permanent_address.sendKeys(abc);
    submit_button.click();
}
    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
