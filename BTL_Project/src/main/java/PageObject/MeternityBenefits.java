package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MeternityBenefits extends BtlBasePage{

//    protected WebDriver driver;

    public MeternityBenefits(WebDriver driver) {
        super(driver);
    }

    public String GetPage(String s) {
        String str = driver.findElement(By.className("active breadcrumbs-item")).getText();
        return str;
    }
    public String GetCurrentItem(){
        String current = driver.findElement(By.id("lblSearchTitle")).getText();
        return current;
    }


}
