package Test;

import Screens.LoginPage;
import Screens.PaymentPage;
import Screens.PersonelInformation;
import org.testng.annotations.Test;
import resources.BaseTest;

public class Test1 extends BaseTest {

    @Test
    public void onlinePayment() throws InterruptedException {
        LoginPage lp = new LoginPage();
        PaymentPage paymentPage = new PaymentPage();
        PersonelInformation personelInformation = new PersonelInformation();

        lp.LoginUser();
        String initialBalance = paymentPage.ValidateValue();
        paymentPage.setPayment();
        personelInformation.setInformation();
        paymentPage.compareBalance(Integer.parseInt(initialBalance),6);

    }
}
