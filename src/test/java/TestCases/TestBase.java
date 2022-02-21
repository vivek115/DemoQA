package TestCases;

import PageFactory.Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    private static WebDriver driver;
    protected Pages pageFactory;
    @BeforeClass
    public void testbase() {
        Properties prop = new Properties();

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekJoshi\\IdeaProjects\\Framework\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pageFactory = new Pages(driver);
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\VivekJoshi\\IdeaProjects\\DemoQA\\src\\main\\java\\Config\\Configprop.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get(prop.getProperty("url"));
//        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void screenshotAndDeleteCookies(ITestResult testResult) throws IOException {

        //Taking screenshot in case of failure
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) + ".jpg"));
        }
        driver.manage().deleteAllCookies();
    }
//
//    @AfterClass
//    public void closeBrowser() {
//        driver.quit();
//    }
}



