package techproed.day10_TestBase_AlertNT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alerts extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//*[text()='Click me'])[1]")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Alert uzerindeki Yazı"+alertText()); //TestBase class'ında oluşturmuz oldugumuz method
        Assert.assertEquals("You clicked a button",alertText());
        bekle(3);

        //Ve alert'ü kapatalım
        alertAccept(); //TestBase class'ında oluşturmuz oldugumuz method
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//*[text()='Click me'])[3]")).click();
        bekle(2);
        //Çıkan alertte iptale basalım.
        alertDismiss();
        bekle(2);

        // Sonuç yazısında selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);

    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//*[text()='Click me'])[4]")).click();
        bekle(2);

        //çıkan alerte ismimizi girelim
        alertSendKeys("Gül");
        bekle(2);
        alertAccept();

        //ismi girdiğimizi doğrulayalım
        String sonucYazısı = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazısı.contains("Gül"));
        bekle(3);
    }
}
