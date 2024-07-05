package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

@Test
        public void loginSuccess() {
    app.getHelperUser().openLoginForm();
    app.getHelperUser().fillLoginForm("liza24@gmail.com", "liT45#kit");
    app.getHelperUser().submitLogin();
    app.getHelperUser().pressOkButton();

    Assert.assertTrue(app.getHelperUser().isLogged());
    //Assert --> if element with text "Logged in success" is present
        }

        @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail.com", "liT45#kit");
        app.getHelperUser().submitLogin();
            app.getHelperUser().pressOkButton();
            app.getHelperUser().logOut();

    }
}
