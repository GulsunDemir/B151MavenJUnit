package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
    //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
    //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
    //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
    @Test
    public void iframe() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        String actualResult = driver.findElement(By.xpath("(//p)[1]")).getText();
        String exceptedResult = "black border";
        Assert.assertTrue(actualResult.contains(exceptedResult));
        bekle(3);

        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
        WebElement iframe = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe);

        /*
        Applications lists yazisini dogru locate edip,
        dogru sekilde gorunur oldugunu test etmemize ragmen Failed oldu
        bunun uzerine HTML kodlarini inceleyince
        Applications lists yazisinin aslinda bir iframe icerisinde oldugunu gorduk
        bu durumda once iframe'i locate edip
        switchTo() ile iframe'e gecmeliyiz
         */

        WebElement aplicationsYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(aplicationsYazisi.isDisplayed());

        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().defaultContent();
        //parentFrame(): bir ust seviyedeki Iframe cikmak icin kullanilir
        //defaultContent():en üstteki web sayfasina(iframe) cikmak icin  kullanilir

        WebElement powerByYazisi = driver.findElement(By.xpath("(//p)[3]"));
        Assert.assertTrue(powerByYazisi.getText().contains("Povered"));
    }
}
