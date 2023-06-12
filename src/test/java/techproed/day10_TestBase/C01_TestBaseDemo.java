package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {


    @Test
    public void test01() {
        //techproeducation sayfasina gidiniz
        driver.get("https://www.techproeducation.com");

        //Basligin "Bootcamp" icerdigini test ediniz
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamp"));

    }
}
