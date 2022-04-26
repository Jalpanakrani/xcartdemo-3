package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class TopMenuTest extends BaseTest {
    String baseUrl = " https://mobile.x-cart.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //Click on shipping Tab
        clickOnElement(By.className("active"));
        //This is from requirement
        String expectedMessage = "Shipping";
        // Validate actual and expected message
        String actualMessage=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);

    }

    private String getTextFromElement(By xpath) {
    }

    private void clickOnElement(By active) {
    }

    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //Click on New! Tab
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/a[1]/span[1]"));

        //This is from requirement
        String expectedMessage = "New arrivals";
        // Validate actual and expected message
        String actualMessage=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        //This is from requirement
        String expectedMessage = "Coming soon";
        // Validate actual and expected message
        String actualMessage=getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){

        String expectedMessage;
        clickOnElement(By.xpath("clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[5]/a[1]/span[1]"));
                //This is from requirement


        String expectedMessage = "Contact us";
        // Validate actual and expected message
        String actualMessage=getTextFromElement(By.id("page-title"));
    Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);}
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //reverse the actual product list
        List<WebElement> originalProdctList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/descendant::h5/child::a"));
        //create the list object
        List reverseProdtcuList = new ArrayList();
        //covert web element object to List Object
        //add all web element value to list object
        for(
                WebElement element : originalProdctList){
            reverseProdtcuList.add(element.getText());
        }
        //sorting on descending order all list elements value
        Collections.sort(reverseProdtcuList,Collections.reverseOrder());
        //thread sleep
        sleep(1000);
        //1.3
        //Mouse hove mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));r on “Sort By”
        //select “Name Z-A”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Name Z - A')]"));
        sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/descendant::h5/child::a"));
        //create the list object
        List actualProductList = new ArrayList();
        //covert web element object to List Object
        //add all web element value to list object
        for(WebElement element : actualProductListElements){
            actualProductList.add(element.getText());
        }
        //1.5
        //verify the arrange on Z to A
        Assert.assertArrayEquals(reverseProdtcuList.toArray(), actualProductList.toArray());

    }

    private void clickOnMouseHoverOnElement(By xpath) {
    }
}
