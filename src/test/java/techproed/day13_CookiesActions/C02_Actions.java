package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        //sag klik yapabilmek icin oncelikle Actions class'indan bir obje olusturmaliyiz.
        Actions actions =new Actions(driver);
        actions.contextClick(kutu). //sag klik yapma methodu kulandik. argumen icin webElementin locate'ini yazdik
        perform(); //actions objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz.
        bekle(2);

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals("You selected a context menu", alertText());   //TestBase deki getTextAlert() methodu kullandık --> driver.switchTo().alert().getText();
        bekle(2);

        //Tamam diyerek alert'i kapatın
        alertAccept();  //-->TestBase deki methodu kullandık --> driver.switchTo().alert().accept()
    }
}
