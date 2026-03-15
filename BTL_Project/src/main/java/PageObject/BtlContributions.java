package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BtlContributions extends BtlBasePage {
    public BtlContributions(WebDriver driver) {
        super(driver);
    }
    public void GotoCalculator(){
        driver.findElement(By.xpath("//a[contains(@href,'Insurance_NotSachir')]")).click();
    }
}
