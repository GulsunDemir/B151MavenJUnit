package techproed.day23_Log4j;

import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C01_Log4j {
    @Test
    public void log4j() {
          /*
        Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api' dir
            Log4j ile bu bilgilendirmeleri hem konsolda tarih saat olarak hem de src>main>resources icine
        koydugumuz log4j.xml file da belirttigimiz .log uzantili dosyada yine tarih saat olarak kayit altina
        almis olacagiz.
            Log4j kullanabilmek icin oncelikle log4j-api ve log4j-core dependency lerini mvnrepository.com
        adresinden (ayni version numaralarina sahip ) alip pom.xml dosyamiza koymaliyiz.
            src>main>resources icine koydugumuz log4j.xml dosyasindaki kodlara pdf deki adresten ulasabilirsiniz

         */
        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("EROR");
        logger.fatal("FATAL");
        logger.warn("WARING");


        //Root level = "EROR"  olarak degistirdigimizde sonuc olarak eror ve fatal aldık
        //Root level = "DEBUG"  olarak degistirdigimizde sonuc olarak  HEPSINI göruruz
        //Root level = "INFO"  olarak degistirdigimizde sonuc olarak  debug harici hepsi gelir
    }
}
