package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    WebDriver wd;
    private By locator;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
        // WebElement element = wd.findElement(locator);
        //element.click();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text != null) {
        element.sendKeys(text);
        }
    }

    public void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void clearTextField(By locator){
        WebElement element = wd.findElement(locator);
        String os = System.getProperty("os.name");
        if (os.startsWith("Win")){
            element.sendKeys(Keys.CONTROL,"a");
        }else {
            element.sendKeys(Keys.COMMAND,"a");
        }
        element.sendKeys(Keys.DELETE);
    }

    public String getMessage() {
        pause(3000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void submit() {
        click(By.xpath("//*[@type='submit']"));
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements(locator);
        return list.size() > 0;
    }

    public String getErrorText() {
        pause(3000);
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

}
