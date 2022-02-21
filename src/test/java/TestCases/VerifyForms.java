package TestCases;

        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class VerifyForms extends TestBase {
    @Parameters({"name"})
    @Test
    public void Test1(String name)
    {
        pageFactory.getTextBoxPage().elements();
        pageFactory.getTextBoxPage().VerifyTextBoxPage();
        pageFactory.getTextBoxPage().enterdetails(name);
        pageFactory.getCheckBoxPage().SelectCheckBox();
    }

    @Parameters({"email"})
    @Test(dependsOnMethods = "Test1")
    public void Test2(String email){

        pageFactory.getwebtables().webtables(email);
        pageFactory.getwebtables().deleteuser();
    }
    @Parameters({"emails"})
    @Test(dependsOnMethods = "Test2")
    public void Test3(String emails) throws InterruptedException {
        pageFactory.getForms().forms(emails);
    }
}
