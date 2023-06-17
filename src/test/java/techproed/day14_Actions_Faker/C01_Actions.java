package techproed.day14_Actions_Faker;

import com.google.errorprone.annotations.Keep;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class C01_Actions  extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ////actions.sendKeys(Keys.END) -->Sayfanın sonuna gider

        bekle(2);

        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);

        //sayfanin en altina scroll yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(3);

        //sayfanin en ustune scroll yapalim
        actions.sendKeys(Keys.HOME).perform();
       // actions.sendKeys(Keys.HOME).build().perform();
        //build() --> metodu action'lari birlestirmek icin kullanilan methoddur. Birden fazla olusturdugumuz action
        //objesini birbirine baglar.
        //Eger yapilan islemin cok hizli olmasini istemiyorsak build() kullanmak yerine her action'dan sonra perform()
        // kullanmamiz gerekir.
        //release() --> methodu mouse'u serbest birakir

    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();


        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();
    }
}
