import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BooksSite;
import java.util.*;



public class myapp {
    WebDriver webDriver;
    BooksSite website;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","E:\\Files\\chromedriver_win322\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(webDriver, 30,500);
        website = new BooksSite(webDriver);
        webDriver.get("https://it-ebooks.info/");

        //System.out.println(webDriver.getTitle());
        //System.out.println(webDriver.getCurrentUrl());

//        website.mainPage().switchSearchToTitle();
        website.mainPage().enterSearchableText("automation");
        website.mainPage().clickSearchButton();
        website.searchResultsPage().waitForSearchResults();

    }

    @Test
    public void testSearchBookUrl(){
        System.out.println("checking url");
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertTrue(webDriver.getCurrentUrl().contains("automation"));
    }

    @Test
    public void testBooksSearch(){
            Assert.assertTrue(webDriver.findElements(By.cssSelector(".gsc-webResult.gsc-result")).size() == 10);
    }

    @After
    public void tearDown(){
            if(webDriver != null){
            webDriver.quit();
            }
    }


}
