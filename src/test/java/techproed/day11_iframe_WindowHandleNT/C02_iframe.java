package techproed.day11_iframe_WindowHandleNT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_iframe extends TestBase {

    @Test
    public void name() {
        // https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editor = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
       driver.switchTo().frame("mce_0_ifr");

        WebElement texbox = driver.findElement(By.xpath("//p"));
        texbox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        texbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);
        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();

        WebElement elementelSelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementelSelenium.getText().contains("Elemental Selenium"));

    }
}
