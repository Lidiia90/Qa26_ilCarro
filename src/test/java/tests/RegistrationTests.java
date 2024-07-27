package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);

        User user = new User()
                .setName("Liza")
                .setLastName("Snow")
                .withEmail("snow" + z + "@gmail.com")
                .withPassword("Snow123456$");

        logger.info("Test start with test data --->" + user.toString());

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }
    @Test
    public void registrationEmptyName() {
        User user = new User()
                .setName("")
                .setLastName("Petrov")
                .withEmail("petrov@gmail.com")
                .withPassword("petroV12*");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");

    }
    @Test
    public void registrationEmptyLastName() {
        User user = new User()
                .setName("Ivan")
                .setLastName("")
                .withEmail("ivanov@gmail.com")
                .withPassword("ivanoV12*");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");

    }
    @Test
    public void registrationWrongEmail() {
        User user = new User()
                .setName("Ivan")
                .setLastName("Petrov")
                .withEmail("ivanovgmail.com")
                .withPassword("ivanoV12*");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));

    }
    @Test
    public void registrationWrongPassword() {
        User user = new User()
                .setName("Ivan")
                .setLastName("Petrov")
                .withEmail("ivanov@gmail.com")
                .withPassword("ivanoV12");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");

    }

    @Test
    public void registrationEmptyEmail() {
        User user = new User()
                .setName("Ivan")
                .setLastName("Petrov")
                .withEmail("")
                .withPassword("ivanoV12*");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");

    }

    @Test
    public void registrationEmptyPassword() {
        User user = new User()
                .setName("Ivan")
                .setLastName("Petrov")
                .withEmail("ivanov@gmail.com")
                .withPassword("");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");

    }

    @Test
    public void registrationWithoutCheckbox() {
        User user = new User()
                .setName("Ivan")
                .setLastName("Petrov")
                .withEmail("ivanov@gmail.com")
                .withPassword("ivanoV12*");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public void postCondition() {
        if (app.getHelperUser().isOkButtonPresent()) {
            app.getHelperUser().clickOkButton();
        }
    }
}

