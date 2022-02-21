package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton {
    WebDriver driver;

    public RadioButton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='yesRadio']")
    private WebElement yesradio;
    @FindBy(xpath = "//input[@id='impressiveRadio']")
    private WebElement impressiveradio;
//    @FindBy(xpath = "//input[@id='noRadio']")
//    private WebElement noradio;

    public void radiobutton() {
        yesradio.click();
        impressiveradio.click();
//        noradio.click();

    }
}
