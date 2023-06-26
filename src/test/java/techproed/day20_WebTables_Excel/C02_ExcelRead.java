package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead extends TestBase {
    @Test
    public void excelReadTest01() throws IOException {
        //excel dosyasindan veri okuyabilmemiz icin;
        //1- dosya yolunu aliriz
        String dosyaYolu ="src/test/java/resourses/Capitals (2).xlsx";

        //2- Capitals dosyasini bizim sistemimize getirmeliyiz. Dosyayi okuyabilmek icin akisa almaliyiz.
        FileInputStream fis = new FileInputStream(dosyaYolu);


        //3-dosyayi workbook'a atamaliyiz. Java ortaminda bir excel dosyası olusturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);


        //4- sayfayı(sheet) secmeliyiz.
        Sheet sheet = workbook.getSheet("Sheet1");


        //satırı(row) secmeliyiz
        Row row = sheet.getRow(0);   // 1. satir, index 0'dan baslar.


        //hücreyi(cell) secmeliyiz
        Cell cell = row.getCell(0);   //1. sütün, index 0'dan baslar.


    }

    @Test
    public void readExcelTest02() throws IOException {
        //KISA YÖNTEM

        //1.satır 1. sütündaki bilgiyi yazdırınız

        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();

        System.out.println(satir1Sutun1);

    }

    @Test
    public void readExcelTest03() throws IOException {
        //1. satır 2. sütün daki hücreyi yazdırın
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String satır1Sutun2 = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();

        System.out.println(satır1Sutun2);



    }
}
