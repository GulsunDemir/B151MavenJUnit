package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
        /*
    -getFirstSelectedOption() ==> Dropdown`daki en son sectigimiz option`u bize dondurur.

    -getOptions() ==> Dropdown`daki tum optionlari bize dondurur.
     */
WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement selectStateDD = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(selectStateDD);

        //select.selectByVisibleText("Arizona");
        //select.selectByIndex(3);
        select.selectByValue("AZ");

        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement sonSecilenOption = select.getFirstSelectedOption();
        String sonSecilenOptionStr = sonSecilenOption.getText();
        Assert.assertEquals("Arizona",sonSecilenOptionStr);

        ////Assert.assertTrue(sonSecilenOption.getFirstSelectedOption().isDisplayed()); gorunuyor mu diye sorar


        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
       List<WebElement> tumOptionlar = select.getOptions();

       //for ile yazdirin
       for (WebElement w : tumOptionlar){
           System.out.println( w.getText());
       }
        System.out.println("****************");

       //Lambda ile yazdirin
       tumOptionlar.stream().forEach(t-> System.out.println(t.getText()));

/* 2.YOL:
        List<WebElement> tumOptionlar = driver.findElements(By.xpath("//select[@id='state']//option"));

        tumOptionlar.stream().forEach(t-> System.out.println(t.getText()));

  */ }

}
