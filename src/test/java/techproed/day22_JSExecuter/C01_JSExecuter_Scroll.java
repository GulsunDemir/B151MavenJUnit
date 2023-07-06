package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter_Scroll extends TestBase {

    //  https://techproeducation.com sayfasına gidin
    // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
    // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Sayfayi en üste scroll et (sayfayı kaydır)
    // Sayfayı en alta scroll et (sayfayı kaydır)

    JavascriptExecutor js;

    @Test
    public void JSExecuterScrollTest() {
        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(2);

        WebElement reklam = driver.findElement(By.xpath("//*[@class='eicon-close']"));
        reklam.click();

        bekle(4);

        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("//span[text()='we offer']"));

         js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);// weOffer elementi gorene kadar git kay

        scroll(weOffer);
        bekle(4);

        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));

//        js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);

        scroll(enrollFree);
        bekle(4);

        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);

        bekle(4);

        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)

        // scroll(enrollFree);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);

        bekle(4);

        ///// Sayfayi en üste scroll et (sayfayı kaydır)
//        WebElement search = driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));
//
//        js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",search);

//        js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, -document.body.scrollHeiht)");

        scrollHome();

        bekle(4);


        // Sayfayı en alta scroll et (sayfayı kaydır)

//        js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        scrollEnd();

    }
}
