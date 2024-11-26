package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {


    /**
     * this method will click on element
     */

    public void mouseHoverToElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void  clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }


    public void mouseHoverAndClickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

        /**
         * this method will get text from element
         */

        public String getTextFromElement (By by){
            return driver.findElement(by).getText();
        }

        /**
         * this method will send text on element
         */

        public void sendTextToElement (By by, String text){
            driver.findElement(by).sendKeys(text);
        }

        public void   selectByVisibleTextFromDropDown(By by,String text){
            driver.findElement(by).sendKeys();
        }
//*************************************Alert method ************************

        /**
         * this method will switchToAlert
         */




        /**
         * this method will select the option by value
         */

        public void selectByValueFromDown (By by, String value){
            WebElement dropdown = driver.findElement(by);
            Select select = new Select(dropdown);


        }
    }
}
