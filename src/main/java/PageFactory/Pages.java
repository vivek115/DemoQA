package PageFactory;

import Objects.*;
import Widgets.*;
import org.openqa.selenium.WebDriver;

public class Pages {
    WebDriver driver;
    private TextBox textBoxPage;
    private CheckBox checkBoxPage;
    private WebTables tables;
    private Forms forms;
    private Alerts alerts;
    private BrowserWindow window;
    private Frames frame;
    private ModalDialogs modalDialogs;
    private Accordian accordian;
    private Slider sliders;
    private Tabs tab;
    private  Menu menubar;
    private DragDrop dragdrops;

    public Pages(WebDriver driver) {
        this.driver = driver;
    }

    public TextBox getTextBoxPage() {
        if (textBoxPage == null) {
            textBoxPage = new TextBox(driver);
        }
        return textBoxPage;
    }

    public CheckBox getCheckBoxPage() {
        if (checkBoxPage == null) {
            checkBoxPage = new CheckBox(driver);
        }
        return checkBoxPage;
    }

    public WebTables getwebtables() {
        if (tables == null) {
            tables = new WebTables(driver);
        }
        return tables;
    }

    public Forms getForms() {
        if (forms == null) {
            forms = new Forms(driver);
        }
        return forms;
    }

    public Alerts getalerts() {
        if (alerts == null) {
            alerts = new Alerts(driver);
        }
        return alerts;
    }

    public BrowserWindow getbrowserwindows() {
        if (window == null) {
            window = new BrowserWindow(driver);
        }
        return window;
    }

    public Frames getframes() {
        if (frame == null) {
            frame = new Frames(driver);
        }
        return frame;
    }

    public ModalDialogs getmodaldialogs() {
        if (modalDialogs == null) {
            modalDialogs = new ModalDialogs(driver);
        }
        return modalDialogs;
    }

    public Accordian getaccordians() {
        if (accordian == null) {
            accordian = new Accordian(driver);
        }
        return accordian;
    }

    public Slider getSliders() {
        if (sliders == null) {
            sliders = new Slider(driver);
        }
        return sliders;
    }

    public Tabs gettabs() {
        if (tab == null) {
            tab = new Tabs(driver);
        }
        return tab;
    }
    public Menu getmenu(){
        if(menubar==null){
            menubar = new Menu(driver);
        }
        return menubar;
    }
    public DragDrop getdragdrop(){
        if(dragdrops==null){
            dragdrops = new DragDrop(driver);
        }
        return dragdrops;
    }
}

