package Widgets;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Tabs {
    WebDriver driver;

    public Tabs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    private WebElement Widgets_TAB;
    @FindBy(xpath = "//span[contains(text(),'Tabs')]")
    private WebElement Click_on_tabs;
    @FindBy(xpath = "//a[contains(text(),'Origin')]")
    private WebElement Click_on_Origin;
    @FindBy(xpath = "//a[contains(text(),'Use')]")
    private WebElement Click_on_use;

    public void verifytab() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Widgets_TAB.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", Click_on_tabs);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0,250)");
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        Click_on_tabs.sendKeys(Keys.CONTROL, Keys.END);
        Click_on_tabs.click();
        Click_on_Origin.click();
        Click_on_use.click();
        Widgets_TAB.click();
    }
}
