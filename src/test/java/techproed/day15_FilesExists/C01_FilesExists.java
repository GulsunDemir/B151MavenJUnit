package techproed.day15_FilesExists;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
        Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
    kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
    için;
        Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
    dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
    Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
    assing ederiz.

        NOT:
    Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
    yolunu almak istediğimiz dosyanun üzerine gelip shift+sagKlik tusuna basarak yol olarak kopyala
    seçeneği ile dosya yolunu kopyalayabiliriz.
 */
        String dosyaYolu = "C:/Users/ASUS/OneDrive/Masaüstü/SELENIUM JUNIT 2023 TR.pdf";
        System.out.println(Files.exists(Paths.get(dosyaYolu))); //Dosya varsa True yoksa False doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02() {
        String dosyaYolu = "C:\\Users\\ASUS\\OneDrive\\Masaüstü\\Ders01 _ Kullanım Senaryosu (Use Case) Örneği.STLCpdf.pdf";
        //--> C'den once ve en sondaki cift tirnaktan once /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() throws InterruptedException {
      /*
   Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
   olmasi acisindan System.getProperty("os.name") bu sekilde isletim sistemini alir
   her isletim sisteminin kullanici yolu farkli olacagindan System.getProperty("user.home") bilgisayarimizdaki
   kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProperty("user.home") atayarak
   her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
   bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz


 */
        //--

        String farkliYol = "";
        String isletimSistemiAdi =System.getProperty("os.name"); //-->Isletim Sistemimizin adini verir.
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));  //-->Bilgisayarinizdaki kullanici yolunu verir.

        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home"); //Windows 10/--> C:\Users\ASUS
        } else if (isletimSistemiAdi.contains("mac")) {
            farkliYol = "/Users/aycapolatkamali ";  //mac isletim sistemi yolu
        }
        String ortakYol ="/OneDrive/Masaüstü/SELENIUM JUNIT 2023 TR.pdf";
        String dosyaYolu = farkliYol + ortakYol;

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu)); //--> Bu sekilde belirtmis oldugumuz dosyayi sileriz deleteIfExists
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));  //-->Sildigimiz icin assertFalse kullandik

        Thread.sleep(3);
        //Sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu)); //-->Belirtmis oldugumuz dosyayi olusturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
    Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
    yukardaki delete islemini kullanabiliriz
 */

    }

    @Test
    public void test04() {
        /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
 */
        String dosyaYolu = "C:/Users/ASUS/OneDrive/Masaüstü/SELENIUM JUNIT 2023 TR.pdf";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        //System.out.println(new File(dosyaYolu).exists());

        file.delete();
    }
}
