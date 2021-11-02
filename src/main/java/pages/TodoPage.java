package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;


import java.time.temporal.ChronoUnit;

public class TodoPage extends PageDriver{

    public TodoPage(AndroidDriver driver) {
        super(driver);
    }

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.ImageButton[contains(@resource-id,'add_task_fab')]")
    public WebElement createTask;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Title']")
    public WebElement taskTitle;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.EditText[contains(@text,'Enter')]")
    public WebElement taskDescription;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.ImageButton[contains(@resource-id,'save_task_fab')]")
    public WebElement saveTask;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.CheckBox[1]")
    public WebElement markTaskCompletion;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    public WebElement settingsView;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Statistics']")
    public WebElement statistics;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Task List']")
    public WebElement taskList;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(accessibility ="More options")
    public WebElement moreOptions;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Clear completed']")
    public WebElement clearCompletedTask;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Task')]")
    public WebElement remainingTask;
}
