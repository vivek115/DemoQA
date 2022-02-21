package TestCases;
import PageFactory.Pages;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class VerifyElement extends TestBase{
    @Test
    @Parameters({"name"})
    public void Test1(String name)
    {
        pageFactory.getTextBoxPage().elements();
        pageFactory.getTextBoxPage().VerifyTextBoxPage();
        pageFactory.getTextBoxPage().enterdetails(name);
        pageFactory.getCheckBoxPage().SelectCheckBox();
    }

}
