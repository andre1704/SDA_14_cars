package andrzej.slowinski.cars;

import java.io.FileReader;
import java.io.InputStream;

/**
 * Created by RENT on 2017-03-11.
 */
public class Car {
    String brand;
    String model;
    double power;
    int year;


    public Car(String csv) {
        if(csv==null){
            throw new IllegalArgumentException("pusty csv");
        }
        String[] strings = csv.split(",");
        if(strings.length<4){
            throw new IllegalArgumentException("niepoprawny format");
        }
        setBrand(strings[0].trim());
        setModel(strings[1].trim());
        setPower(Double.parseDouble(strings[2].trim()));
        setYear(Integer.parseInt(strings[3].trim()));
    }

    public Car(String brand, String model, double power, int year) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.year = year;
    }

    @Override
    public String toString() {
        String out = brand + "," + model + "," + power + "," + "," + year;
        return out;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {

        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }
}
