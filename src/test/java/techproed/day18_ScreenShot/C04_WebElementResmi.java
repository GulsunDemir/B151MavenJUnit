package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WebElementResmi extends TestBase {
        /*
     Bir webelementin resmini almak için önce Webelementi locate edip bir webelemente assing ederiz.
    ve bu webelementi direk getScreenShotAs() methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.
     */

    @Test
    public void test01() throws IOException {
        //Amazon  sayfasina gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //iphone aratalim
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone"+ Keys.ENTER);

        //çıkan sonuc yazisinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}

