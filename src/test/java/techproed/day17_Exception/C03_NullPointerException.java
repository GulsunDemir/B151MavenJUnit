package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException  {
    /*
    NullPointerException:
    degisken ya da obje olusturup bu degiskene atama yapmadigimizda ya da esitlemedigimizde NullPointerException
    hatasi aliriz.

     */
    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;

    @Test
    public void NullPointerException() {
        /*
        driver = new ChromeDriver(); atamasini yapmadigimiz icin NullPointerException hatasini aldik.
         */
       driver.get("https://amazon.com");
    }

    @Test
    public void NullPointerExceptionTest2() {
        System.out.println(faker.name().firstName());  //C03_NullPointerException.java:36
        //faker = new Faker(); atamasini yapmadigimiz icin NulPointerException hatasi aldik.
    }

    @Test
    public void NullPointerExceptionTest3() {

        actions.doubleClick().perform();   //C03_NullPointerException.java:43
         /*
        actions = new Actions(); atamasini yapmadigimiz icin NullPointerException hatasini aldik
         */
    }

    @Test
    public void NullPointerExceptionTest4() {
        System.out.println(sayi+5);  //C03_NullPointerException.java:51
        /*
         sayi=6 sayi degiskenine atama yapmadigimiz icin NullPointerException hatasi aldik.
         */

    }

    @Test
    public void NullPointerExceptionTest5() {
        System.out.println(isim.charAt(0));  //C03_NullPointerException.java:60
        /*
        isim = "Gülsün" ; isim degiskenine atama yapilmadigi icin NullPointerException hatasi aldik.
         */
    }
}
