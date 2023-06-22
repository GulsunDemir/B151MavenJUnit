package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    /*
        NoSuchElementException:

        Sayfada bulunmayan bir elemente erisim saglanmaya calisildiginde NoSuchElementException hatasi aliriz
         */
    @Test
    public void NoSuchElementException() {
        //techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");

        //reklami kapatiniz
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//*[@id='HATAelementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER); // C01_NoSuchElementException.java:23


    }
}
