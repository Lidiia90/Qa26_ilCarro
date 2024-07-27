package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

        @BeforeClass
                public void preCondition(){
            if(!app.getHelperUser().isLogged()){
                app.getHelperUser().login(new User().withEmail("liza24@gmail.com").withPassword("liT45#kit"));
                logger.info("Logout complete");
            }
        }

    @Test
    public void AddNewCarSuccess(){
        int i  = new Random().nextInt(1000)+1000;

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-6" + i)
                .price(50)
                .about("Nice car")
                .build();
        logger.info("Test start with test data --->" + car.toString());

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().getScreen("src/test/screenshots/screen.png");
        app.getHelperCar().attachPhoto("/Users/lidashpektorovska/GitHub/Qa26_ilCarro/Cross7.jpg");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car.getManufacture()+" "+car.getModel()+" added successful");
    }

    @Test
    public void AddNewCarSuccessReq(){
        int i  = new Random().nextInt(1000)+1000;

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("KIA")
                .model("Sportage")
                .year("2021")
                .fuel("Gas")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-6" + i)
                .price(50)
                .about("Nice car")
                .build();
        logger.info("Test start with test data --->" + car.toString());

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car.getManufacture()+" "+car.getModel()+" added successful");
    }
    @AfterMethod
    public void postCondition(){
            app.getHelperCar().returnToHomePage();
    }
}