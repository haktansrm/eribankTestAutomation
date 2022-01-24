package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import resources.BaseTest;

import java.time.Duration;

public class PersonelInformation extends BaseTest {

    public PersonelInformation() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "phoneTextField")
    MobileElement txtPhone;
    @AndroidFindBy(id = "nameTextField")
    MobileElement txtName;
    @AndroidFindBy(id = "amount")
    MobileElement txtAmount;

    @AndroidFindBy(id = "countryButton")
    MobileElement btnSelectCountry;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Greenland']")
    MobileElement btnGreenland;

    @AndroidFindBy(id = "sendPaymentButton")
    MobileElement btnSendPayment;
    @AndroidFindBy(id = "android:id/button1")
    MobileElement btnYes;





    public void setInformation() throws InterruptedException {
    txtPhone.sendKeys("5555444666");
    txtName.sendKeys("dadsdsa");
    txtAmount.setValue("5.0");
    btnSelectCountry.click();
    btnGreenland.click();
    btnSendPayment.click();
    Thread.sleep(2000);
    btnYes.click();


    }
}
