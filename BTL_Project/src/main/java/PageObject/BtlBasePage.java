package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BtlBasePage extends BasePage{

//    protected WebDriver driver;

    public BtlBasePage(WebDriver driver) {
        super(driver);
    }

    public void negetive(String mainmenu, String SUBMENUE) {
        driver.findElement(By.xpath("//a[text()='" + mainmenu + "']")).click();
        driver.findElement(By.xpath("//a[text()='" + SUBMENUE + "']")).click();
    }

    public void search(String searchValue) {
        driver.findElement(By.id("TopQuestions")).sendKeys(searchValue);
        driver.findElement(By.id("ctl00_SiteHeader_reserve_btnSearch")).click();
    }

}
