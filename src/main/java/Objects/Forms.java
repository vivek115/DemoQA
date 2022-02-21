package Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Forms {
    WebDriver driver;

    public Forms(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Forms')]")
    private WebElement Click_On_forms;
    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    private WebElement Click_On_practiceform;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstname;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastname;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;
    @FindBy(xpath = "//label[contains(text(),'Male')]")
    private WebElement select_gender;
    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement mobile_number;
    @FindBy(xpath = "//div[@class='react-datepicker__input-container']/child::input[@id='dateOfBirthInput']")
    private WebElement Click_on_calender;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
    private WebElement subject_container;
    @FindBy(xpath = "(//label[@class='custom-control-label'])[4]")
    private WebElement select_hobbies;
    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement select_picture;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement current_address;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[1]")
    private WebElement select_state_city_;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit_button;
    // private static final String DROPDOWN_VALUES = "(//div[@class=' css-1uccc91-singleValue'])[%s]";
    @FindBy(xpath = "//div[contains(text(),'Uttar Pradesh')]")
    private WebElement select_dropdown;
    @FindBy(xpath = "//button[@id='closeLargeModal']")
    private WebElement close_button;

    public void forms(String emails) throws InterruptedException {
        Actions actions = new Actions(driver);
        String abc = getalphanumerString();
        String cde = getalphaString();
        String fgh = getnumericvalue();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Click_On_forms.click();
        Click_On_practiceform.click();
        firstname.sendKeys(cde);
        lastname.sendKeys(cde);
        email.sendKeys(emails);
        select_gender.click();
        mobile_number.sendKeys(fgh);
//        String bookingdate = "17-January-2023";
//        String[] temp = bookingdate.split("-");
//        String date = temp[0];
//        String month = temp[1];
//        String year = temp[2];
//        String newdate = month + " " + year;
//        Click_on_calender.click();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='react-datepicker__month-container']")));
//        while (true) {
//            if (driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"))
//                    .getText().equals(newdate)) {
//                driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", date))).click();
//                break;
//            } else {
//                driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
//            }
        subject_container.click();
        actions.sendKeys(cde).build().perform();
        select_hobbies.click();
        select_picture.sendKeys("C:\\Users\\VivekJoshi\\Downloads\\Book 13.xlsx");
        current_address.sendKeys(cde);
        //select_state_city_.click();
//        for (StateCity ele : StateCity.values()) {
//            WebElement io = driver.findElement(By.xpath(String.format(DROPDOWN_VALUES, ele.ChallengeName())));
//            Assert.assertEquals(io.getText(), ele.ChallengeId(), "Values are not same");
//        }
        select_state_city_.click();
//        Select sel = new Select(select_state_city_);
//        sel.selectByVisibleText("Uttar Pradesh");
        select_dropdown.click();
        submit_button.click();
        close_button.click();

//            Alert simpleAlert = driver.switchTo().alert();
//            simpleAlert.accept();
    }

    public String getalphanumerString() {
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