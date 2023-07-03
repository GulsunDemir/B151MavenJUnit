package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void ReadExcelTest01() throws IOException {
        //3. Satır 1. Sutun degerini yazdırın ve "France" oldugunu test edin
        //Excel dosyasından veri okuyabilmemiz icin;
        //1- Dosya yolunu alırız.
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        //2- Capitals dosyasını bizim sistemimize(java) input etmeliyiz (getirmeliyiz). Dosyayı okuyabilmek icin akısa almalıyız.

        FileInputStream fis = new FileInputStream(dosyaYolu); //Hangi dosyayı bizim sistemimize getirmek istiyorsak onun ismini yazarız

        //3- Dosyayı workbook'a atamalıyız. Java ortamında bir excel dosyası olusturmalıyız
        Workbook workbook = WorkbookFactory.create(fis);    //Calisma kitabi fabrikasi



        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3Sutun1);

        Assert.assertEquals("France", satir3Sutun1);




        // Son satır sayısını bulunuz
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son Satir Sayisi = " + sonSatirSayisi);

        // Excel tablosundaki son satır sayısını getLastRowNum() metodu ile alabiliriz.
        // (index olarak verir)



        //Kullanılan satır sayısını bulunuz.
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir Sayisi = " + kullanilanSatirSayisi);

        //Excel tablosundaki kullanılan satır sayisını getPhysicalNumberOfRows() metodu ile alabiliriz.
        //(index olarak vermez)


    }

    @Test
    public void readExcelTest02() throws IOException {
        //Capitals dosyasındaki tum verileri yazdırın

        Map<String,String> capitalsMap = new HashMap<>();
        //Capitals dosyasındaki tüm verileri koyabilecegimiz en uygun java objesi map'dir.

        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        //for loop son satir sayisinda durmali bu sebeple önce son satir sayisini bulmaliyiz
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i < sonSatirSayisi; i++) {
            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            capitalsMap.put(key,value);
            //System.out.println(key+""+value);
        }

        System.out.println(capitalsMap);



    }
}
