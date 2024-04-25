package levelone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends BaseTest {

    @BeforeClass
    public void preconditions() {
        // TODO login

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

    }

    @Test
    public void positiveAddContact() throws InterruptedException {
        // click on //a[@href='/add'] - open add contact page
        driver.findElement(By.xpath("//a[@href='/add'] ")).click();
        // fill name in //input[@placeholder='Name']
        WebElement name =
                driver.findElement(By.xpath("//input[@placeholder='Name']"));
        name.click();
        name.clear();
        name.sendKeys("zzz");

        // fill last name //input[@placeholder='Last Name']
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("xxx");

        // fill phone //input[@placeholder='Phone']
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.clear();
        phone.click();
        String numberPhone = "5554567890";
        phone.sendKeys(numberPhone);

        // fill email //input[@placeholder='email']
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.click();
        email.clear();
        email.sendKeys("ccc@vv.com");
        // fill address //input[@placeholder='Address']
        WebElement address = driver.findElement(By.xpath("//input[@placeholder='Address']"));
        address.click();
        address.clear();
        address.sendKeys("nnnn");
        // fill description //input[@placeholder='description']
        WebElement description = driver.findElement(By.xpath("//input[@placeholder='description']"));
        description.click();
        description.clear();
        description.sendKeys("mmmm");

        // click save //div[contains(@class,'add_form')]//button
        driver.findElement(By.xpath("//div[contains(@class,'add_form')]//button")).click();

        Thread.sleep(3000);

        List<WebElement> allPhones = driver.findElements(By.xpath("//div[contains(@class,'contact-item_card')]//h3"));
        boolean res = false;
        for (WebElement el:allPhones){
            if(el.getText().trim().equals(numberPhone)){
                res = true;
                break;
            }
        }
        Assert.assertTrue(res);
    }

}
