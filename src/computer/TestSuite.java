package computer;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']"));

        //Click on the Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));

        //Select Sort By option "Name: A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");

    }

    public void verifyProductAddedToShoppingCartSuccessFully(){

        //Click on the "Add To Cart" button of the product name ‘Build your own computer’
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));

        //Verify the Text "Build your own computer"
        String textBuildYourOwnComputer = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        verifyText("Invalid Text", "Build your own computer", textBuildYourOwnComputer);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_16_5_4"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //Select "8GB [+$60.00]" using the Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_16_6_5"), "8GB [+60.00]");

        //Select HDD radio button "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_16_3_6_19']"));

        //Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(By.id("product_attribute_16_4_7_21"));

        //Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        clickOnElement(By.id("product_attribute_16_8_8_22"));
        clickOnElement(By.id("product_attribute_16_8_8_24"));

        //Verify the price "1200.00"
        String priceVerify = getTextFromElement(By.xpath("//span[contains(text(),'1200.00')]"));
        verifyText("Invalid Price", "1200.00", priceVerify);

        //Click on the "Add to card" Button.
        clickOnElement(By.id("add-to-cart-button-16"));

        //Verify the Message "The product has been added to your shopping cart" on the
        //Top green Bar
        String productAddedToCart = getTextFromElement(By.xpath("//p[@class='content']")).trim().split("\n ")[0];
        verifyText("Invalid Text Display", "The product has been added to your shopping cart", productAddedToCart);

        //After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseHoverAndClickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

        //Verify the message "Shopping cart"
        String messageShoppingCart = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        verifyText("No message display", "Shopping cart", messageShoppingCart);

        //Change the Qty to "2" and Click on "Update shopping cart"
//        driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body div.order-summary-content table.cart tbody:nth-child(3) tr.cart-item-row:nth-child(2) td.qty.nobr > input.qty-input.valid")).clear();
//        sendTextElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body div.order-summary-content table.cart tbody:nth-child(3) tr.cart-item-row:nth-child(2) td.qty.nobr > input.qty-input.valid"), "2");
//        clickOnElement(By.name("updatecart"));

        //Verify the Total "2,950.00"
//        String totalAmount = getTextFromElement(By.xpath("//span[@class='product-price order-total']//strong[contains(text(),'2950.00')]"));
//        verifyText("Invalid Total", "2950.00", totalAmount);

        //click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //Click on “Checkout”
        clickOnElement(By.id("checkout"));

        //Verify the Text “Welcome, Please Sign In!”
        String welcomeText = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        verifyText("Invalid Display", "Welcome, Please Sign In!", welcomeText);

        //Click on the “Checkout as Guest” Tab
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));

        //Enter the First name
        sendTextElement(By.id("BillingNewAddress_FirstName"), "Alex");

        //Enter the Last name
        sendTextElement(By.id("BillingNewAddress_LastName"), "Dev");

        //Enter the email
        sendTextElement(By.id("BillingNewAddress_Email"), "AlexDev8@gmail.com");

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

        //Click on the Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/input[1]"));

        //Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_2']"));

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/input[1]"));

        //Select “Master card” From the Select credit card dropdown using the Select class
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //Enter the Cardholder's name
        sendTextElement(By.id("CardholderName"), "Alex");

        //Enter the Card number
        sendTextElement(By.id("CardNumber"), "1234567890123456");

        //Select the Expiration date using the select class
        selectByIndexFromDropDown(By.id("ExpireMonth"), 02);
        //selectByIndexFromDropDown(By.id("ExpireYear"), 2027);

        //Enter the code
        clickOnElement(By.id("CardCode"));

        //Click on the “Continue” button
        clickOnElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]"));

    }
}
