package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite  {
    @Test
    public void excelWriteTest01() throws IOException {
        // Bir "Nüfus" sütunu olusturun
        // baskent nufuslarını excel dosyasına yazınız.
        // (D.C: 100, Paris:1500, London:1200, Ankara:1300)

        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        //Capitals dosyasını bizim sistemimize getirdik

        Workbook workbook = WorkbookFactory.create(fis);
        //dosyayı workbook'a atadık.

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("1200");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1300");


        //Excel'de bir hücre olusturmak için createCell() metodu kullanılır.
        //Hücre içine yazdıracagimiz deger için setCellValue() metodu kullanılır

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // dataları(verileri) bizim class'ımızdan Capitals dosyasına gönderecegiz

        workbook.write(fos);
        //workbook'daki dataları fos'a yazdık.



    }
}
