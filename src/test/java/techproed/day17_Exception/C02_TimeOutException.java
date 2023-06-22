package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TimeOutException:

    Sayfada aradigimiz elementi wait ile belirttigimiz max. surede bulamadigi durumda TimeOutException hatasi aliriz.
     */
    /*
    TimeOutException alabilmek icin visibilityOfElementLocated metodunu kullanarak yanlis bir locate aldik.
    webelementi beklerken o webelementin locate'ini bulamadigi icin max. sure kadar bekledi ve TimeOutException
    hatasini verdi.
     */
    @Test
    public void TimeOutException() {
        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //reklami kapatiniz
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //searchBox'a gorunur oluncaya kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='YANLISelementor-search-form-9f26725']"))); // C02_TimeOutException.java:30 hatasi

    }

    @Test
    public void TimeOutException2() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//*[text()='Start']")).click();


             // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); //bekleme süresi kısa olduğu için hata verir
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        //  C02_TimeOutException.java:52)

        Assert.assertTrue(helloWorld.isDisplayed());

        /*
        Gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
        TimeOutException alabilmek icin Explicit Wait'e max. bekleme suresini 2 saniye verdik.
        Bu sebeple TimeOutException  hatasi aldik
         */

    }
}
