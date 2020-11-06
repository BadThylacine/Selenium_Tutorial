package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 70);
    }

   public void waitForSearchResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("gsc-expansionArea")));
    }
}
