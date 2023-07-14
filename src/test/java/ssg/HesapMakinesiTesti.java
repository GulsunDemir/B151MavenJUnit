package ssg;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

@Ignore("Bu clas atlandı") //class seviyesinde çalışır
public class HesapMakinesiTesti extends HesapMakinesi {
    private HesapMakinesi hesapMakinesi;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass: Her class'tan önce çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass: Her class'tan sonra çalışır");

    }

    @Before
    public void setUp()  {
        System.out.println("Before her testen önce çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After: Her testen sonra çalışır.");
    }

    @Test
    public void testTopla() {
        int sonuc = topla(3, 5);
        Assert.assertEquals(8, sonuc);
    }

    @Test
    public void testCıkar() {
        int sonuc = cikar(5, 3);
        Assert.assertEquals(2, sonuc);
    }

    @Test(timeout = 500)
    public void testCarp() {
        int sonuc = carp(2, 5);
        Assert.assertEquals(10, sonuc);
    }

    @Test(expected = IndexOutOfBoundsException.class)
//(expected = ArithmeticException.class) //exception fırlatırsa test gecer fırlatmazsa hata
    public void testBol() {
        //  bol(5,0);
        List<Integer> sayilar = new ArrayList<>();
        sayilar.add(48);//bu gecmez 0. index dolu oldugu icin
        sayilar.get(1);
    }

    @Ignore("Bu test atlandı")
    @Test
    public void atlananTest() {
        System.out.println("Bu test atlandı"); //testi tek çalıştırdıgımızda çalısır  class seviyesinde  ıgnor eder
    }

}
