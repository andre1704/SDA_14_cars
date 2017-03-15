package andrzej.slowinski.cars;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
/**
 * Created by RENT on 2017-03-14.
 */
public class CarRepositoryTest {
    @Test
    public void saveToFIle_test_save_many_lines() throws IOException {
        CarRepository carRepository = new CarRepository();
        carRepository.addCar(new Car("Ford", "fiesta", 120, 2007));
        carRepository.addCar(new Car("Audi", "A5", 220, 2009));
        carRepository.addCar(new Car("Audi", "A4", 220, 2009));
        carRepository.saveToFIle();
        ArrayList<Car> list=new ArrayList<>();
        ArrayList<Car> pom= (ArrayList<Car>) carRepository.getCarList();
        loadFromFileToArray(list);
        checkAssertion(list, pom);
    }

    @Test
    public void setListFromFile_Test_many_lines_in_file() throws IOException {
        CarRepository carRepository=new CarRepository();
        carRepository.setListFromFile("car.txt");
        ArrayList<Car> pom= (ArrayList<Car>) carRepository.getCarList();
        ArrayList<Car> list=new ArrayList<>();
        loadFromFileToArray(list);
        checkAssertion(list, pom);



    }

    private void checkAssertion(ArrayList<Car> list, ArrayList<Car> pom) {
        for(int i=0;i<list.size();i++){
            assertEquals(list.get(i).brand,pom.get(i).brand);
            assertEquals(list.get(i).model,pom.get(i).model);
            assertEquals(list.get(i).year,pom.get(i).year);
            assertEquals(list.get(i).power,pom.get(i).power,0.0000001);
        }
    }

    private void loadFromFileToArray(ArrayList<Car> list) throws IOException {
        FileReader fileReader=new FileReader("car.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            Car car=new Car(line);
            list.add(car);
        }
    }
}
