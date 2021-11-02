import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseInit {

    public static AppiumDriverLocalService service;
    public AndroidDriver<AndroidElement> driver;

    public AndroidDriver<AndroidElement> invokeApp() throws MalformedURLException {

        File appDir = new File("src//main//resources");
        File app = new File(appDir,"app-mock-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;
    }

  @BeforeSuite
    public void startAppiumServer()
  {

      service =  AppiumDriverLocalService.buildDefaultService();
      if(service.isRunning()){
          service.stop();
      }
      service.start();
  }

    @AfterSuite
    public void stopServer()
    {
        service.stop();
    }

}
