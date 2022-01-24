package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import resources.BaseTest;

import java.time.Duration;

public class PaymentPage extends BaseTest {

    public PaymentPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(12)),this);
    }

    @AndroidFindBy(id="makePaymentButton")
    MobileElement btnMakePayment;
    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View[contains(@text,'Your balance is')]")
    MobileElement amountArea;



    public String ValidateValue(){
        String balance = amountArea.getText().replace("Your balance is: ","")
                .replace(".00$","");

          return balance;
    }

    public PaymentPage compareBalance(int initialBalance,int consumeBalance){
        String finalBalance = ValidateValue();
        int expectedBalance = initialBalance - consumeBalance;
        Assert.assertEquals(Integer.parseInt(finalBalance),expectedBalance,"Yaptığın işlem yanlış");
        return this;
    }




    public void setPayment(){
        btnMakePayment.click();
    }
}
