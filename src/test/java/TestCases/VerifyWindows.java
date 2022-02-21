package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyWindows extends TestBase
{
    @Test
    @Parameters({"name"})
    public void Test1(String name)
    {
        pageFactory.getTextBoxPage().elements();
        pageFactory.getTextBoxPage().VerifyTextBoxPage();
        pageFactory.getTextBoxPage().enterdetails(name);
        pageFactory.getCheckBoxPage().SelectCheckBox();
    }
    @Test(dependsOnMethods = "Test1")
    public void Test2(){
        pageFactory.getbrowserwindows().handlebrowserwindow();
        pageFactory.getbrowserwindows().verifywindowpage();
        pageFactory.getbrowserwindows().window_tab();
        pageFactory.getbrowserwindows().new_window();
        pageFactory.getbrowserwindows().window_message_button();
    }
}
