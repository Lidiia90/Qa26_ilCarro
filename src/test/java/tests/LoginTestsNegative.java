package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsNegative extends TestBase {

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24gmail.com", "liT45#kit");
        Assert.assertTrue(app.getHelperUser().isEmailClassInvalid());
        Assert.assertTrue(app.getHelperUser().isSubmitLoginInvalid());
    }

    @Test
    public void loginWrongEmail1() {
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail", "liT45#kit");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail.com", "likit");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongPassword1() {
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail.com", "");
        Assert.assertTrue(app.getHelperUser().isPasswordClassInvalid());
        Assert.assertTrue(app.getHelperUser().isSubmitLoginInvalid());
    }
        @Test
        public void loginUnregisteredUser() {
            app.getHelperUser().openSignupForm();
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("lida24@gmail.com", "daT45#li");
            app.getHelperUser().submitLogin();
            Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
            app.getHelperUser().clickOkButton();

        }
    }

