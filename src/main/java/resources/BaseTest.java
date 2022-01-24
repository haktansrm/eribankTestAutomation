package resources;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AndroidDriver driver;


    public void launchApp() throws MalformedURLException {

        File appDir = new File("src");
        File app = new File(appDir,"Eribank.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 29");
        cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        cap.setCapability(MobileCapabilityType.NO_RESET,true);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

    @BeforeMethod
    public void launchApplication() throws MalformedURLException {
        launchApp();
    }
public AndroidDriver getDriver(){
        return driver;
}

public static void getScreenShot(String s) throws IOException {
        File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\reports\\"+s+".png"));
}

}
