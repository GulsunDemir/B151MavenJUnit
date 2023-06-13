package techproed.day10_TestBase_AlertNT;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Üç saniye bekle
        bekle(3);

        //Basligin Bootcamp icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //assert actualTitle.contains(expectedTitle);

    }

}
