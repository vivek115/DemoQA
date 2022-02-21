package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox {
    WebDriver driver;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul[@class='menu-list']//li)[2]")
    private WebElement Click_On_checkbox;
    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement Select_Checkbox;
    @FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
    private WebElement Click_On_addbutton;
    @FindBy(xpath = "//button[@class='rct-option rct-option-collapse-all']")
    private WebElement click_on_minusbutton;
    @FindBy(xpath = "//button[@class='rct-collapse rct-collapse-btn']")
    private WebElement click_on_backbutton;
    @FindBy(xpath = "(//button[@class='rct-collapse rct-collapse-btn'])[1]")
    private WebElement click_on_closebutton;
    @FindBy(xpath = "(//div[@class='header-wrapper'])[1]")
    private WebElement Click_On_Elements;
    public void SelectCheckBox() {
        Click_On_checkbox.click();
        Select_Checkbox.click();
        Click_On_addbutton.click();
        click_on_minusbutton.click();
        click_on_backbutton.click();
        click_on_closebutton.click();
        Click_On_Elements.click();
    }
}
