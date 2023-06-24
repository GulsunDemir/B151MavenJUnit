package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
 EXTENTREPORT;
    1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
 dependency'i pom.xml dosyamıza ekleriz.
    2- ExtentReports class'ından class seviyeninde obje oluştururuz
    3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
    4- ExtentTest class'ından class seviyeninde obje oluştururuz
  */
    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    ExtentTest extentTest;//--> Test adınlarına eklemek istediğimiz bilgileri bu class ile oluştururuz
    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);  //-->HTML formatinda raporlamayi baslatacak

        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Gülsün");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtentTest","Test Raporu");

         /*
    Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class'
    larini kullanrak raporla ilgili bilgileri rapora ekleyebiliriz
     */

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //Basligin Amazon icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        extentTest.info("Basligin amazon icerdigi test edildi");

        //Arama kutusunda ipohene aratalim
        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        extentTest.info("Arama kutusunda iphone aratildi");


        //sonuc yazisini konsola yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi : "+sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi konsola yazdirildi");
        extentTest.pass("Sayfa kapatildi");
        /*
        extentTest objesi ile info methodunu kullanarak her step'de ne yaptigimiz ile alakali bilgi yazabiliriz
    testimizin en sonunda testin bittigini ifade eden pass() methodu ile testimiz ile alakali son bilgiyi
    ekleyebiliriz
        Ve son olarak actions daki perform methodu gibi extentReport ile flush() methodu kullanarak raporu
        sonlandiririz
        */

        extentReports.flush(); //-->Bu metodu kullanmazsak raporumuz olusmaz.



    }
}
