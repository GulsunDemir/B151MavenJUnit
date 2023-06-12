package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_AllertMethods extends TestBase {
    /*
       https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.



       Bir metod olusturun: acceptAlert
       1. butona tıklayın,
       uyarıdaki OK butonuna tıklayın
       ve result mesajının "You successfully clicked an alert" oldugunu test edin.



       Bir metod olusturun: dismissAlert
       2. butona tıklayın,
       uyarıdaki Cancel butonuna tıklayın
       ve result mesajının "successfuly" icermedigini test edin.



       Bir metod olusturun: sendKeysAlert
       3. butona tıklayın,
       uyarıdaki mesajı konsolda yazdırın,
       uyarıdaki metin kutusuna isminizi yazin,
       OK butonuna tıklayın
       ve result mesajında isminizin görüntülendiğini doğrulayın.

       */
    @Test
    public void acceptAlert() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //        Bir metod olusturun: acceptAlert
        //        1. butona tıklayın,

        driver.findElement(By.xpath("(//button)[1]")).click();

        bekle(2);

        //        uyarıdaki OK butonuna tıklayın
        alertAccept();
        bekle(2);

        //        ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actualResult = driver.findElement(By.cssSelector("*[id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void dismissAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // Bir metod olusturun: dismissAlert
        //        2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        bekle(2);

        //        uyarıdaki Cancel butonuna tıklayın
        alertDismiss();
        bekle(2);

        //        ve result mesajının "successfuly" icermedigini test edin.
        String actualSonuc = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedSonuc = "successfuly";
        Assert.assertFalse(actualSonuc.contains(expectedSonuc));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //   Bir metod olusturun: sendKeysAlert
        //        3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        bekle(2);

        //        uyarıdaki mesajı konsolda yazdırın,
        alertText();
        // getText() uyaridaki mesaji String olarak getirir.
        bekle(2);

        //        uyarıdaki metin kutusuna isminizi yazin,
        alertPrompt("Gülsün");
        bekle(2);

        //        OK butonuna tıklayın
        alertAccept();
        bekle(2);

        //        ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertTrue(actualResult.contains("Gülsün"));


    }
}
