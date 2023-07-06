package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {

    @Test
    public void jsgetValueTest() {

        // "https://www.carettahotel.com/" sayfasina gidin
        driver.get("https://www.carettahotel.com/");

        WebElement gelismis = driver.findElement(By.xpath("//*[@id='details-button']"));
        gelismis.click();

        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //Check-In Date kısmını JS ile locate ediniz
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        //    CSS SELECTOR KULLANARAK'DA LOCATE ALINABİLİR'
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");



         /*
         Eger bir web sayfasinda webElementler olusturulurken JS kullanılmıssa, normal olarak locate almakta zorlanabiliriz
         Bu gibi durumlarda JSExecuter kullanarak webelementi locate edebiliriz.
          */

        /////Check-In Date kısmına 5/25/2023 tarihini yazınız.
        date.clear();
        date.sendKeys("5/25/2023");

        ////Check-In Date kısmının degerini yazdırın.
        String valueAttribute = (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println(valueAttribute);

    }
}
