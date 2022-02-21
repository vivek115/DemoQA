package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserWindow {
    WebDriver driver;

    public BrowserWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement Window_TAB;
    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement Click_on_browserwindows;
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement new_window;
    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement window_button;
    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement new_window_message;

    public void handlebrowserwindow() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Window_TAB.click();
        Click_on_browserwindows.click();
    }

    public void verifywindowpage() {
        String actual = driver.getCurrentUrl();
        String expected = "https://demoqa.com/browser-windows";
        Assert.assertEquals(actual, expected, "Window page is not verified");
    }

    public void window_tab() {
        new_window.click();
        String MainWindow = driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                // we give (//h1) to get the heading of the page
                String actual = driver.findElement(By.xpath("//h1")).getText();
                String expected = "This is a sample page";
                Assert.assertEquals(actual, expected, "child page is not verified");
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
    public void new_window(){
        window_button.click();
        String MainWindow = driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                // we give (//h1) to get the heading of the page
                String actual = driver.findElement(By.xpath("//h1")).getText();
               // String actual = driver.findElement(By.xpath("//h1")).getText();
                String expected = "This is a sample page";
                Assert.assertEquals(actual, expected, "child page is not verified");
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);

    }
    public void window_message_button(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String MainWindow = driver.getWindowHandle();
        new_window_message.click();
        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                // we give (//h1) to get the heading of the page
//                String actual = driver.findElement(By.tagName("body")).getText();
                //String actual = driver.findElement(By.xpath("//h1")).getText();
                String actual = driver.findElement(By.xpath("//h1")).getText();
               // String actual = driver.getPageSource();
                String expected = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
                Assert.assertEquals(actual, expected, "child page is not verified");
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
}


