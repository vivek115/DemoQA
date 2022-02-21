package Widgets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DragDrop {
    WebDriver driver;

    public DragDrop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-wrapper'])[5]")
    private WebElement Interactions_TAB;
    @FindBy(xpath = "//span[contains(text(),'Droppable')]")
    private WebElement Click_on_droppable;
    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6']")
    private WebElement Click_on_frame;
    @FindBy(xpath = "(//div[@class='drag-box mt-4 ui-draggable ui-draggable-handle'])[1]")
    private WebElement Click_on_dragme;
    @FindBy(xpath = "(//div[@class='drop-box ui-droppable'])[1]")
    private WebElement Click_on_drop;

    public void drag_drop() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Interactions_TAB.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", Click_on_droppable);
        Actions action = new Actions(driver);
        action.dragAndDrop(Click_on_dragme, Click_on_drop).perform();
        Interactions_TAB.click();




    }
}
