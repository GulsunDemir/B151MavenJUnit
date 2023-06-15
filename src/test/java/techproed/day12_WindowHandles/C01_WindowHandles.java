package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    //  https://the-internet.herokuapp.com/windows adresine gidin.
    //  ilk sayfasının Handle degerini alın yazdırın
    //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
    //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
    //  "Click Here" butonuna tıklayın.
    //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
    //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
    //  ikinci sayfaya tekrar geçin.
    //  ilk sayfaya tekrar dönün.
    @Test
    public void windowHandles() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        bekle(2);

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("Sayfa 1 Handle Degeri : "+ ilkSayfaHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement openingANew = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertTrue(openingANew.isDisplayed());
       // Assert.assertEquals("Opening a new window",openingANew.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String  theInternetTitle = driver.getTitle();
        Assert.assertTrue(theInternetTitle.contains("The Internet"));
        //Assert.assertEquals("The Internet",theInternetTitle);

        bekle(2);

        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        /*
        Eger bir butona tikladigimiz da bizim kontrolumuz disinda ikinci sayfa aciliyorsa otomatik acilan 2. sayfaya
        driver'i gecirmemiz gerekir. Ikinci sayfaya driver'i gecirebilmemiz icin 2. sayfanin Handle degerini bulmaliyiz
        getWindowHandles(); metodu sayesinde 2. sayfanın handle degerini tespit edebiliriz.Daha sonra
        driver.switchTo.window(sayfa2Handle);  diyerek 2. sayfa'ya driver'i gecirebiliriz.
         */

        Set<String> windowHandleSeti = driver.getWindowHandles();
      //   System.out.println(windowHandleSeti);  //tüm sekmelerin sirasiyla handle degerini verir. [2B803B2EAD41332A6CEA1610DC887D31, 26ABBF16F05E3040FE11D4DF361CC075]

        String sayfa2Handle="";
        for (String each: windowHandleSeti){
            if (!each.equals(ilkSayfaHandle)){
                sayfa2Handle = each;
            }
        }
        System.out.println("Sayfa2 Handle Degeri = " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("New Window"));

        bekle(2);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        bekle(2);

        String ilkSayfaTitle = driver.getTitle();
        //Assert.assertTrue(ilkSayfaTitle.contains("The Internet"));
        Assert.assertEquals("The Internet", ilkSayfaTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);

        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);
        bekle(2);
    }
}
