package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method logout finish ");
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ---> email: " + email + "& password: " + password);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
        //Assert --> if element with text "Logged in success" is present
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess1(String email, String password) {
        User user = new User().withEmail("liza24@gmail.com").withPassword("liT45#kit");
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ---> email: " + email + "& password: " + password);

        //user.setEmail("liza24@gmail.com");
        //user.setPassword("liT45#kit");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
        //Assert --> if element with text "Logged in success" is present
    }
    @Test
    public void loginSuccessModel() {
        logger.info("Test start with test data --->" + " email : 'liza24@gmail.com' & password : 'liT45#kit'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail.com", "liT45#kit");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //  app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test start with test data --->" + " email : 'liza24gmail.com' & password : 'liT45#kit'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24gmail.com", "liT45#kit");
        Assert.assertTrue(app.getHelperUser().isEmailClassInvalid());
        Assert.assertTrue(app.getHelperUser().isSubmitLoginInvalid());
    }

    @Test
    public void loginWrongEmail1() {
        logger.info("Test start with test data --->" + " email : 'liza24@gmail' & password : 'liT45#kit'");
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail", "liT45#kit");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
      //  app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test start with test data --->" + " email : 'liza24@gmail.com' & password : 'likit'");
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail.com", "likit");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
       // app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginEmptyPassword() {
        logger.info("Test start with test data --->" + " email : 'liza24@gmail.com' & password : 'likit'");
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("liza24@gmail.com", "");
        Assert.assertTrue(app.getHelperUser().isPasswordClassInvalid());
        Assert.assertTrue(app.getHelperUser().isSubmitLoginInvalid());
    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test start with test data --->" + " email : 'lida24@gmail.com' & password : 'daT45#li''");
        app.getHelperUser().openSignupForm();
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lida24@gmail.com", "daT45#li");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        //app.getHelperUser().clickOkButton();

    }

    @AfterMethod
    public void postCondition() {
        if (app.getHelperUser().isOkButtonPresent()) {
            app.getHelperUser().clickOkButton();
        }
    }
}



