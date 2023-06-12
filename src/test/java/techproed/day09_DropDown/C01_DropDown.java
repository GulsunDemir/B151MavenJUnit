package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class C01_DropDown extends TestBase {

   /*
     DropDown:
     Alt başlıkların olduğu açılır menu listesidir.

    3 adımda Handle edilir.

    1) drop down locate edilmelidir.
    2) select objesi oluşturulmalıdır.
    Select select = new Select(ddm);
    3)Options'lardan bir tanesi seçilir.
    -selectByVisibleText() -> options'a gorunur metinle ulaşmak için kullanılır
    -selectByIndex() -> option' a index ile ulaşmak için kullanılır
    -selectByValue() -> option' a value ile ulaşmak için kullanılır

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
    public void name() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        WebElement dropdownYil =driver.findElement(By.xpath("//select[@id='year']"));


        Select select = new Select(dropdownYil);

        //select.selectByVisibleText("2020");
        //select.selectByIndex(3);
        //select.selectByValue("2020");
        ddmVisibleText(dropdownYil,"2020");



        // Ay Dropdown'undan "August" seciniz
        WebElement dropdownAy = driver.findElement(By.xpath("//select[@id='month']"));

        Select select1 =new Select(dropdownAy);

        //select1.selectByVisibleText("August");
       //görünen sekilde yapistirdik/yazdik. karakter hatasi olmamali.
        //select1.selectByIndex(7);
        //index 0 ve en yukaridan baslar. august 8. sirada ve 7. indextedir.
        select1.selectByValue("7");
        //ay dropdown una sag click incele dedik, select html kodunun yaninda bulunan ok isaretine tikladik,
        // aylarin value degeri görünür, ayin yanindaki value degerini sayisal olarak paranteze ekledik

        // Gün Dropdown'undan "5" seciniz
        WebElement dropdownGun = driver.findElement(By.xpath("//select[@id='day']"));

        Select select2 = new Select(dropdownGun);
        //select2.selectByVisibleText("5");
        //select2.selectByIndex(4);
        select2.selectByValue("5");


    }

}
