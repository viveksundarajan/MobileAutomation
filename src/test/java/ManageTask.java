import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StatisticsPage;
import pages.TodoPage;

import java.net.MalformedURLException;

public class ManageTask extends BaseInit{


    @BeforeTest
    public void openApp() throws MalformedURLException {
        driver = invokeApp();
    }

    @Test
    public void verifyCompletedTaskAndActiveTask() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.createTask.click();
        todoPage.taskTitle.sendKeys("Task1");
        todoPage.taskDescription.sendKeys("Automation");
        todoPage.saveTask.click();

        todoPage.createTask.click();
        todoPage.taskTitle.sendKeys("Task2");
        todoPage.taskDescription.sendKeys("Manual");
        todoPage.saveTask.click();

        todoPage.markTaskCompletion.click();
        todoPage.settingsView.click();
        todoPage.statistics.click();

        StatisticsPage statisticsPage = new StatisticsPage(driver);
        Assert.assertTrue(statisticsPage.activeTask.getText().contains("50.0%"));
        Assert.assertTrue(statisticsPage.completedTask.getText().contains("50.0%"));

        todoPage.settingsView.click();
        todoPage.taskList.click();
        todoPage.moreOptions.click();
        todoPage.clearCompletedTask.click();

        Assert.assertTrue(!todoPage.remainingTask.getText().contains("Task1"));
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
