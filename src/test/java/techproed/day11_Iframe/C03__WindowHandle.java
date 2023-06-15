package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03__WindowHandle extends TestBase {
    //  https://www.techproeducation.com adresine gidiniz
    //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

    //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

    //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

    //  techproeducation sayfasına geçiniz
    //  youtube sayfasına geçiniz
    //  linkedIn sayfasına geçiniz:

    @Test
    public void WindowHandle() {
        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        bekle(2);
        /*
        techproeducation sayfasinin handle degerini getWindowHandle(); metodu ile elde edebiliriz.
         */
        String techproWindowHandle = driver.getWindowHandle();
        System.out.println("TECHPROEDUCATİON HANDLE: "+techproWindowHandle); //TECHPROEDUCATİON HANDLE: EDD0887A63673FE8BDE3E3B97C9D8CB5
//Her sayfanın handle degeri uniq tir sayfalar arasinda gecis yapabilmek icin handle degerine ihtiyacim var

        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);  //Yeni bir pencereye driver'i tasir.
        //WindowType.TAB ==> yeni sekme acar. sayfanin tipini belirleriz eger sekme olsaydi WindowType.TAB kullanacaktik


        driver.get("https://www.youtube.com");
        bekle(2);

        String youtubeWindowHandle = driver.getWindowHandle();
        System.out.println("YOUTUBE HANDLE: "+youtubeWindowHandle);//YOUTUBE HANDLE: C830E097DA7EBBB0FE1DF5E910EBB15A

        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);  //Yeni bir pencereye driver'i tasir. Parantez icine tipini belirtiriz
        driver.get("https://www.linkedin.com");
        bekle(2);


        /*
        linkedin sayfasinin handle degerini getWindowHandle() metodu ile elde edecegiz.
         */
        String linkedinWindowHandle = driver.getWindowHandle();
        System.out.println("LINKEDİN HANDLE: "+ linkedinWindowHandle);  //LINKEDİN HANDLE: 2459BCAFCEBF03A2B4BB8B90C22A97EC

        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        bekle(2);

        //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);
        bekle(2);

        //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);

    }
}
