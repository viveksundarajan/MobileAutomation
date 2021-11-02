package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;

import java.time.temporal.ChronoUnit;

public class StatisticsPage extends PageDriver{


    public StatisticsPage(AndroidDriver driver) {
        super(driver);
    }

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Active tasks:')]")
    public WebElement activeTask;

    @WithTimeout(time=10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Completed tasks:')]")
    public WebElement completedTask;

}
