package Widgets;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Slider {
    WebDriver driver;

    public Slider(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    private WebElement Widgets_TAB;
    @FindBy(xpath = "//span[contains(text(),'Slider')]")
    private WebElement Click_on_slidertab;
    @FindBy(xpath = "//div[@class='range-slider__tooltip__arrow']")
    private WebElement slider;

    public void Move_Slider() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Widgets_TAB.click();
        Click_on_slidertab.click();
        Actions move = new Actions(driver);
        move.moveToElement(slider).clickAndHold().moveByOffset(0, 250).release().perform();
//        Action action = move.dragAndDropBy(slider, 50, 50).build();
//        action.perform();
    }
}
