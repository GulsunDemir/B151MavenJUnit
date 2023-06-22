package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {
     /*
    StaleElementReferanceException:

    bir web sayfasındaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.

    Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
    yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.

    Bunu handle edebilmek icin webelemente yeniden aynı locate'ı atamalıyız.
    (webelementin locate'ını hatırlatma gibi diyebiliriz.)


     */

    @Test
    public void StaleElementReferanceExceptionTest1() {
        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz


        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        //sayfayi yenileyelim
        driver.navigate().refresh();
        //navigate'den sonraki locate'ler bayatlar ve tekrar kullanamayiz.

        //LMS Login butonuna tiklayalim
        driver.findElement(By.xpath("(//*[@class='elementor-item'])[5]")).click();

    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz


        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        //LMS Login butonuna locate'ini alalim
        WebElement lmsLogin = driver.findElement(By.xpath("(//*[@class='elementor-item'])[5]"));

        //sayfayi yenileyelim
        driver.navigate().refresh();
        //navigate'den sonraki locate'ler bayatlar ve tekrar kullanamayiz.

        // LMS LOGIN butonuna tıklayalım
        lmsLogin.click();   //C04_StaleElementReferanceException.java:70 tekrar LMS LOGIN'in locator'unu almak zorundayiz
        /*
        LMS LOGIN webelementini locate ettikten sonra sayfayi yeniledigimiz icin LMS LOGIN webelementi eskidi(bayatladi)
        sonrasinda bayatlayan webelement'e click yaptigimiz icin  StaleElementReferanceException hatasi aldik.

         Bu exception'i handle edebilmek icin refresh yaptiktan sonra tekrar ayni locate'i webelemente atamamiz gerekir
         */
    }

    @Test
    public void StaleElementReferanceExceptionTest3() {

        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));




        // sayfayı yenileyelim
        driver.navigate().refresh();



        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();



    }
}
