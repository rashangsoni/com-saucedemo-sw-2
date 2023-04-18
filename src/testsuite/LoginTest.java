package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

        String baseURL = "https://www.saucedemo.com/";
        @Before
        public void setUp(){
            openBrowser(baseURL);
        }
        @Test
        public void userShouldLoginSuccessfullyWithValidCredentials(){
            //Enter "standard_user" username
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

            //Enter "secret_sauce" password
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

            //Click on 'Login' button
            driver.findElement(By.xpath("//input[@id='login-button']")).click();

            //Verify the text "Products"
            String textToVerify = driver.findElement(By.xpath("//span[@class='title']")).getText();
            Assert.assertEquals("Text displayed does not match", "Products",textToVerify);
        }
        @Test
        public void verifyThatSixProductsAreDisplayedOnPage(){
            //Enter "standard_user" username
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

            //Enter "secret_sauce" password
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

            //Click on 'Login' button
            driver.findElement(By.xpath("//input[@id='login-button']")).click();

            //Verify that six products are displayed on page
            List<WebElement> productList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
            Assert.assertEquals(6,productList.size());
        }
        @After
        public void tearDown(){
            closeBrowser();
        }


    }
