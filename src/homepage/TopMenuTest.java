package homepage;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    public void selectMenu(String menu){
        String menuTab = "Books";
        clickOnElement(By.xpath("//div[@class='header-menu']"));

    }

    //
    @Test
    public void verifyPageNavigation(){
        String menuTab = "Top Menu";
        System.out.println("Verifying navigate to : " +menuTab);
}

}