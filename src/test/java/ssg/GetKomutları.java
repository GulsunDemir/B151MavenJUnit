package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class GetKomutları extends TestBase {
    //https://www.kitapyurdu.com/ adresine gidiniz.
    //Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
    //Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
    //Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
    //Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
    //“Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
    //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
    //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
    //Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
    //quit() ve close() metotları arasındaki farkı inceleyelim.
    @Test
    public void getKomutlariTesti(){
        // Web sitesine git
        driver.get("https://www.kitapyurdu.com/");

        // URL ile doğrulama
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Title ile doğrulama
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Anasayfada bazı başlıkların bulunduğunun doğrulanması
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        // Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunun doğrulanması
        WebElement girisButonu = driver.findElement(By.xpath("//div[@class='menu-top-button login']"));
        String girisButonuMetni = girisButonu.getText();
        Assert.assertEquals("Giriş Yap", girisButonuMetni);

        // "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunun doğrulanması
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlHref = uyeOlButonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlHref);


        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunun doğrulanması
        List<WebElement> yazarIsmiListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi : yazarIsmiListesi){
            Assert.assertEquals("span", yazarIsmi.getTagName());
        }

        for (WebElement yazarIsmi : yazarIsmiListesi){
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));
        }
        //Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        WebElement ilkKitapGenislikYukseklik= driver.findElement(By.xpath("//*[@alt='Kurtuluş Günü']"));
        int height= ilkKitapGenislikYukseklik.getSize().getHeight();
        int width= ilkKitapGenislikYukseklik.getSize().getWidth();
        Assert.assertEquals(height,174);
        Assert.assertEquals(width,120);




    }
}
