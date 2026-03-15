package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.Random;

public class BachurYeshiva extends BtlBasePage {
    public BachurYeshiva(WebDriver driver) {
        super(driver);
    }


    public String GetPage() {

        String str = driver.findElement(By.id("mainContent")).getText();
        return str;
    }

    public void FirstStep() {
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2_lbl")).click();
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0_lbl")).click();
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date")).sendKeys("1/1/2000");
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton")).click();
    }

    public String AssertStep() {
        String s = driver.findElement(By.id("header")).getText();
        return s;
    }

    public void SecondStep() {
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1_lbl")).click();
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StepNavigationTemplateContainerID_StepNextButton")).click();

    }
    public String SumEnd(){
        String s= driver.findElement(By.xpath("//li[contains(text(),\"סך\")]//strong")).getText();
        return s;
    }
}
