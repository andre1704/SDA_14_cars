package andrzej.slowinski.cars;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarRepository {
    private List<Car> list;

    CarRepository() {
        list = new ArrayList<Car>();
//        list.add(new Car("Ford", "fiesta", 120, 2007));
//        list.add(new Car("Audi", "4", 220, 2009));

    }

    public List<Car> getCarList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }

    public void addCar(Car car) {

        list.add(car);
    }
    public void setListFromFile(String file) throws IOException {
        list.clear();
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while((line=bufferedReader.readLine())!=null){
            Car car=new Car(line);
            addCar(car);
        }
        bufferedReader.close();
        fileReader.close();
        for(Car el:list){
            System.out.println(el.toString());
        }
    }
    public void deleteFromList(Car car){
        list.remove(car);
    }
    public void saveToFIle() throws IOException {
        FileWriter fileWriter=new FileWriter("car.txt",false);
        for(Car el:list){
            fileWriter.write(el.toString()+System.lineSeparator());
            fileWriter.flush();
        }
        fileWriter.close();
    }
}
