package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.firebaseapp.com/");
    }
    public void stop(){
        wd.quit();
    }
}
