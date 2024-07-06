package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//*[text()=' Log in ']"));
    }
    public void fillLoginForm(String email, String password){
type(By.id("email"), email);
type(By.id("password"), password);
    }
    public void submitLogin() {
        click(By.xpath("//*[@type='submit']"));
    }
    public void clickOkButton() {
        pause(1000);
        click(By.xpath("//button[text()='Ok']"));
    }
    public String getMessage() {
        pause(1000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }
    public void logout(){
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public boolean isEmailClassInvalid() {
        return wd.findElement(By.id("email")).getAttribute("class").contains("ng-invalid");
    }
    public boolean isSubmitLoginInvalid() {
        WebElement submitButton = wd.findElement(By.xpath("//*[@type='submit']"));
        String disabledAttribute = submitButton.getAttribute("disabled");
        return disabledAttribute != null;
    }
    public boolean isPasswordClassInvalid() {
        return wd.findElement(By.id("password")).getAttribute("class").contains("ng-invalid");
    }

    public void openSignupForm(){
        click(By.xpath("//*[text()=' Sign up ']"));
    }
    }

