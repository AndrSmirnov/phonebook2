package levelone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @AfterMethod
    public void methodPostCondition() {
        driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button"))
                .click();
        driver.navigate().to("https://telranedu.web.app/home");
    }


    @Test
    public void positiveLoginTest(){
        // 1.  click on login btn by:   //a[@href='/login']
       driver.findElement(By.xpath("//a[@href='/login']")).click();

        //2.   fill email by:       //input[@name='email']
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("asmirnoff.74@mail.ru");
        //3.  fill password by:    //input[@name='password']
        WebElement inputPassword = driver.findElement(By
                .xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Qwerty12$");


        //4.  click login btn by:    //button[@name='login']
        driver.findElement(By.xpath(" //button[@name='login']")).click();

        //5. validation - verification by sign out //div[contains(@class,'navbar-logged')]//button

        WebElement signOutBtn = driver.findElement(
                By.xpath("//div[contains(@class,'navbar-logged')]//button")
        );
        String actualRes = signOutBtn.getText().trim();
        System.out.println(actualRes);

        Assert.assertEquals(
                driver.findElement(
                                By.xpath("//div[contains(@class,'navbar-logged')]//button"))
                        .getText().trim(),
                "Sign Out");


        //6.  text: Sign Out
     //  Assert.assertEquals(actualRes,"Sign Out");
    }
}
