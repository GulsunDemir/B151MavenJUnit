package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    // thead --> Tablonun Basligi   //tbody-->tablonun ici(body)
    //tr-->satir                    //tr--> satır
    //th-->sütün                    //td-->sütün


    @Test
    public void webTablesTest01() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //tablo 1 i yazdirin
        WebElement tablo1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println("tablo1 = " + tablo1.getText());


        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");

    }

    @Test
    public void webTablesTest02() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // 3. satir verilerini yazdırın.
        List<WebElement> list = driver.findElements(By.xpath("(//table[1])//tbody//tr[3]//td"));

        list.stream().forEach(t -> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTableTest03() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //son satirin verilerini yazdirin
        //List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr[4]//td"));
        List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td"));

        sonSatirVerileri.stream().forEach(t -> System.out.print(t.getText() + " - "));

    }

    @Test
    public void webTablesTest04() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // 5. sütün basligini yazdırın
        WebElement besincisutunBasligi = driver.findElement(By.xpath("//table[1]//thead//tr[1]//th[5]"));
        System.out.println(besincisutunBasligi.getText());


        // 5. Sütün verilerini yazdırın
        List<WebElement> besinciSutunverileri = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));

        besinciSutunverileri.stream().forEach(t -> System.out.println(t.getText() + " - "));

    }

    @Test
    public void webTablesTest05() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // iki parametreli bir java methodu olusturalım

        // Parametre 1 => satır numarasını
        // Parametre 2 => sutun numarası

        // prinData(2,3) ==> 2. satır, 3. sutundaki veriyi yazdırın

        printData(2,3);
        printData(2,5);
        printData(3,2);
        //printData(1,7); 7. Sütün olmadigi icin NoSuchElementException hatasi aliriz


    }//Test05

    public void printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(satirSutun.getText());

    }//class
}
