package techproed.day08Junit;

import org.junit.*;

public class C02_BeforeClassAfterClass {
     /*
     @BeforeClass class'da en once calisan methoddur.
     @AfterClass class'da en son calisan methoddur.
     @BeforeClass ve @AfterClass metodlari sadece static metodlar ile calisir.
     */
     @BeforeClass
    public static void beforeClass() throws Exception {
         System.out.println("Class'da en once calisan metoddur. Bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'da en son calisan metoddur. Bir kez calisird");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test metodundan once calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test metodundan sonra calisir.");
    }

    @Test
    public void test01() {
        System.out.println("ilk Test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci Test");
    }
}
