package electronics;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {


    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

        //Mouse Hover on the “ELECTRONICS” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));

        //Mouse Hover on the “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));

        //Verify the text “Cell phones”
        String productName = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        verifyText("Invalid Name", "Cell phones", productName);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){

        //Mouse Hover on the “ELECTRONICS” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));

        //Mouse Hover on the “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));

        //Verify the text “Cell phones”
        String productName = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        verifyText("Invalid Name", "Cell phones", productName);

        //Select View as option ‘List’


        //Click on the product name “Smartphone” link
        clickOnElement(By.xpath("//a[contains(text(),'Smartphone')]"));

        //Verify the text “Smartphone”
        String phoneText = getTextFromElement(By.xpath("//h1[contains(text(),'Smartphone')]"));
        verifyText("Invalid Text", "Smartphone",phoneText);

        //Verify the price “100.00”
        String priceText = getTextFromElement(By.xpath("//span[contains(text(),'100.00')]"));
        verifyText("Invalid Price Text", "100.00", priceText);

        //Change the quantity to 2
        driver.findElement(By.xpath("//input[@id='addtocart_43_EnteredQuantity']")).clear();
        sendTextElement(By.xpath("//input[@id='addtocart_43_EnteredQuantity']"), "2");

        //Click on the “Add to cart” tab
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-43']"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String productAddedToCart = getTextFromElement(By.xpath("//p[@class='content']")).trim().split("\n ")[0];
        verifyText("Invalid Text Display", "The product has been added to your shopping cart", productAddedToCart);

        //After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseHoverAndClickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));


        //Verify the message "Shopping cart"
        String messageShoppingCart = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        verifyText("No message display", "Shopping cart", messageShoppingCart);

        //Verify the quantity is 2
//        String quantityTwo = getTextFromElement(By.xpath("//tbody/tr[1]/td[5]/input[1]")).trim().split("\n ")[0];
//        verifyText("Invalid Number", " 2 ", quantityTwo);

        //Verify the Total “200.00”
        String totalText = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[2]"));
        verifyText("Invalid Number", "200.00", totalText);

        //click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //Click on “Checkout”
        clickOnElement(By.id("checkout"));

        //Verify the Text “Welcome, Please Sign In!”
        String welcomeText = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        verifyText("Invalid Display", "Welcome, Please Sign In!", welcomeText);

        //Click on the “Register” tab
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[2]"));

        //Verify the text “Register”
        String registerText = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        verifyText("Invalid Text", "Register", registerText);

        //Select the Male radio button
        clickOnElement(By.xpath("//input[@id='gender-male']"));

        //Enter the First name
        sendTextElement(By.xpath("//input[@id='FirstName']"), "Alex");

        //Enter Last Name
        sendTextElement(By.xpath("//input[@id='LastName']"), "Parada");

        //Enter the Email
        sendTextElement(By.xpath("//input[@id='Email']"), "alexp026@gmail.com");

        //Enter the Password
        sendTextElement(By.xpath("//input[@id='Password']"), "alexp@");

        //Enter the Confirm password
        sendTextElement(By.xpath("//input[@id='ConfirmPassword']"), "alexp@");

        //Click on the “Register” button
        clickOnElement(By.xpath("//input[@id='register-button']"));

        //Verify the message “Your registration completed”
        String messageRegistration = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        verifyText("Invalid Message", "Your registration completed", messageRegistration);

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/input[1]"));

        //Verify the text “Shopping card”
        String textCardShopping = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        verifyText("Invalid Message", "Shopping cart", textCardShopping);

        //click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //Click on the “Checkout”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Select the Country “United Kingdom” using the select class
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");

        //Enter the city
        sendTextElement(By.id("BillingNewAddress_City"), "London");

        //Enter the Address1
        sendTextElement(By.id("BillingNewAddress_Address1"), "82 Epsom");

        //Enter the Zip/Postal code
        sendTextElement(By.id("BillingNewAddress_ZipPostalCode"), "kt1 8pe");

        //Enter the Phone number
        sendTextElement(By.id("BillingNewAddress_PhoneNumber"), "+447986738281");

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]"));

        //Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

        //Click on the Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/input[1]"));

        //Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_2']"));

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/input[1]"));

        //Select “Master card” From the Select credit card dropdown using the Select class
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");

        //Enter the Cardholder's name
        sendTextElement(By.id("CardholderName"), "Alex");

        //Enter the Card number
        sendTextElement(By.id("CardNumber"), "1234567890123456");

        //Select the Expiration date using the select class
        selectByIndexFromDropDown(By.id("ExpireMonth"), 02);
        //selectByIndexFromDropDown(By.xpath("//option[contains(text(),'2027')]"), 2027);

        //Enter the code
        sendTextElement(By.id("CardCode"), "552");

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]"));

    }


}
