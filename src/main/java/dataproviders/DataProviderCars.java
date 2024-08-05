package dataproviders;

import models.Car;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderCars {
@DataProvider
    public Iterator<Object[]> example(){
    List<Object[]> list = new ArrayList<>();

    return list.iterator();
}
@DataProvider
    public Iterator<Object[]> CarSuccess(){
    int i  = new Random().nextInt(1000)+1000;
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{Car.builder()
            .location("Tel Aviv, Israel")
            .manufacture("Mazda")
            .model("M3")
            .year("2022")
            .fuel("Petrol")
            .seats(4)
            .carClass("C")
            .carRegNumber("678-900-5"+i)
            .price(50)
            .about("Nice car")
            .build()});

    list.add(new Object[]{Car.builder()
            .location("Bat Yam, Israel")
            .manufacture("Nissan")
            .model("L3")
            .year("2021")
            .fuel("Petrol")
            .seats(4)
            .carClass("C")
            .carRegNumber("678-900-6"+i)
            .price(100)
            .about("Nice car")
            .build()});

    return list.iterator();
}
@DataProvider
    public Iterator<Object[]> carCSV() throws IOException{
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/files_csv/cars.csv")));
    String line = reader.readLine();
    while(line!=null){
        String[] all = line.split(",");
        list.add(new Object[]{Car.builder()
                .location(all[0])
                .manufacture(all[1])
                .model(all[2])
                .year(all[3])
                .fuel(all[4])
                .seats(Integer.parseInt(all[5]))
                .carClass(all[6])
                .carRegNumber(all[7])
                .price(Double.parseDouble(all[8]))
                .about(all[9])
                .photoLink(all[10])
                .build()});
        line = reader.readLine();
    }
    return list.iterator();
}
}
