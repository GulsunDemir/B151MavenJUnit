package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_TumSayfaResmi extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ekran goruntusunu alalim
       tumSayfaResmi();

    }
}
