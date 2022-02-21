package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class WebTables {
    WebDriver driver;

    public WebTables(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul[@class='menu-list']//li)[4]")
    private WebElement Click_On_webtable;
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement Click_On_addbutton;
    @FindBy(xpath = "//div[contains(text(),'Registration Form')]")
    private WebElement verifyform;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstname;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastname;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement useremail;
    @FindBy(xpath = "//input[@id='age']")
    private WebElement age;
    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salary;
    @FindBy(xpath = "//input[@id='department']")
    private WebElement department;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitbutton;
    @FindBy(xpath = "(//div[@class='action-buttons']//span)[2]")
    private WebElement deleteuser;
    @FindBy(xpath = "(//div[@class='action-buttons']//span)[1]")
    private WebElement edituser;
    @FindBy(xpath = "(//div[@class='header-wrapper'])[1]")
    private WebElement Click_On_Elements;
    public void webtables(String email) {
        String abc = getSaltString();
        String cde = getalphaString();
        String fgh = getnumericvalue();
        Click_On_webtable.click();
        Click_On_addbutton.click();
        String ActualTitle = verifyform.getText();
        String ExpectedTitle = "Registration Form";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Registration page  is not verified");
        firstname.sendKeys(cde);
        lastname.sendKeys(cde);
        useremail.sendKeys(email);
        age.sendKeys(fgh);
        salary.sendKeys(fgh);
        department.sendKeys(cde);
        submitbutton.click();
    }

    public void deleteuser() {
        deleteuser.click();
        edituser.click();
        submitbutton.click();
        Click_On_Elements.click();
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

    public String getalphaString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr1 = salt.toString();
        return saltStr1;
    }

    public String getnumericvalue() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr2 = salt.toString();
        return saltStr2;
    }
}
