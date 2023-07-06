package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {
    // https://techproeducation.com sayfasına gidin
    // Arama kutusuna "QA" yazıp aratın

    @Test
    public void typeTest() {
        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(2);

        WebElement reklam = driver.findElement(By.xpath("//*[@class='eicon-close']"));
        reklam.click();

        bekle(4);

        //// Arama kutusuna "QA" yazıp aratın

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));

        //aramaKutusu.sendKeys("QA"); //1.yol.

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='QA'",aramaKutusu);

        sendKeysJS(aramaKutusu, "QA");
        aramaKutusu.submit();

      /*
        //Diger yol:

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('value','QA')", aramaKutusu);

        sendAttributeJS(aramaKutusu,"QA");

       */


    }
}
