package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyTabs extends TestBase {
    @Test
    @Parameters({"name"})
    public void Test1(String name) {
        pageFactory.getTextBoxPage().elements();
        pageFactory.getTextBoxPage().VerifyTextBoxPage();
        pageFactory.getTextBoxPage().enterdetails(name);
        pageFactory.getCheckBoxPage().SelectCheckBox();
    }
    @Test(dependsOnMethods = "Test1")
    public void Test2(){
        pageFactory.gettabs().verifytab();
    }
}
