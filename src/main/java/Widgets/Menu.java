package Widgets;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Menu {
    WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    private WebElement Widgets_TAB;
    @FindBy(xpath = "(//span[contains(text(),'Menu')])[1]")
    private WebElement Click_on_menu;
    @FindBy(xpath = "//a[contains(text(),'Main Item 1')]")
    private WebElement Click_on_item1;
    @FindBy(xpath = "//a[contains(text(),'Main Item 2')]")
    private WebElement Click_on_item2;
    @FindBy(xpath = "//a[contains(text(),'SUB SUB LIST »')]")
    private WebElement sub_list;
    @FindBy(xpath = "//a[contains(text(),'Sub Sub Item 2')]")
    private WebElement Click_on_subitem2;
//    @FindBy(xpath = "//a[contains(text(),'Main Item 1')]")
//    private WebElement Click_on_item1;
//    @FindBy(xpath = "//a[contains(text(),'Main Item 2')]")
//    private WebElement Click_on_item2;

    @FindBy(xpath = "//a[contains(text(),'Main Item 3')]")
    private WebElement Click_on_item3;

    public void menu() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Widgets_TAB.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Click_on_menu.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(Click_on_item1).build().perform();
        actions.moveToElement(Click_on_item2).build().perform();
        actions.moveToElement(sub_list).build().perform();
        actions.moveToElement(Click_on_subitem2).click();
    }
}
