package andrzej.slowinski.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarRepository {
    private List<Car> list;

    CarRepository() {
        list = new ArrayList<Car>();
        list.add(new Car("Ford", "fiesta", 120, 2007));
        list.add(new Car("Audi", "4", 220, 2009));

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
}
