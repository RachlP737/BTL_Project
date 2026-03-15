import PageObject.BachurYeshiva;
import PageObject.BtlBasePage;
import PageObject.BtlContributions;
import PageObject.MeternityBenefits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public static void BeforeAllTest() {
        System.out.println("לפני הכל");
        // לוודא ש-WebDriverManager מתקין את ה-ChromeDriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void BeforeEachTest() {
        // לא צריך עוד setup כאן כי כבר נעשה ב-BeforeAll
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il/Pages/default.aspx");
    }

    @AfterEach
    public void AfterEachTest() throws InterruptedException {
        Thread.sleep(3000);
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void AfterAllTest() {
        System.out.println("אחרי הכל");
    }

    @Test
    public void testSearchMaternityBenefits() {
        String s = "חישוב סכום דמי לידה ליום";
        BtlBasePage bbp = new BtlBasePage(driver);
        bbp.search(s);

        String expectedTitle = "תוצאות חישוב עבור חישוב סכום דמי לידה ליום";
        MeternityBenefits mb = new MeternityBenefits(driver);
        String current = mb.GetCurrentItem();
        Assertions.assertEquals(expectedTitle, current, "הכותרת בדף התוצאות אינה תואמת לצפי!");
    }

    @Test
    public void calculatingForBachurTeshiva() {
        BtlBasePage bbp = new BtlBasePage(driver);
        String s1 = "דמי ביטוח";
        String s2 = " דמי ביטוח לאומי";
        bbp.negetive(s1, s2);

        BtlContributions bc = new BtlContributions(driver);
        bc.GotoCalculator();

        String s3 = "חישוב דמי ביטוח עבור עצמאי, תלמיד, שוהה בחוץ לארץ ומי שלא עובד";
        BachurYeshiva by = new BachurYeshiva(driver);
        String current = by.GetPage();
        Assertions.assertEquals(s3, current, "הכותרת בדף התוצאות אינה תואמת לצפי!");

        by.FirstStep();
        String s4 = "צעד שני";
        String s5 = by.AssertStep();
        Assertions.assertEquals(s4, s5, "הכותרת בדף התוצאות אינה תואמת לצפי!");

        String s6 = by.AssertStep();
        String s7 = "סיום";
        Assertions.assertEquals(s7, s6, "הכותרת בדף התוצאות אינה תואמת לצפי!");

        String sum = "171";
        String sum2 = by.SumEnd();
        Assertions.assertEquals(sum, sum2, "הכותרת בדף התוצאות אינה תואמת !");
    }
}