package andrzej.slowinski.cars;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarTest {
    @Test
    public void constructor_form_string(){
        String dane="toyota,yaris,140,2008";
        Car car=new Car(dane);
        String expectedBrand="toyota";
        String expectedModel="yaris";
        double expectedPower=140.0;
        int expectedYear=2008;
        assertEquals(expectedBrand,car.brand);
        assertEquals(expectedModel,car.model);
        assertEquals(expectedPower,car.power,0.00000001);
        assertEquals(expectedYear,car.year);
    }@Test
    public void constructor_form_non_trimmed_string(){
        String dane="toyota ,yaris , 140 , 2008";
        Car car=new Car(dane);
        String expectedBrand="toyota";
        String expectedModel="yaris";
        double expectedPower=140.0;
        int expectedYear=2008;
        assertEquals(expectedBrand,car.brand);
        assertEquals(expectedModel,car.model);
        assertEquals(expectedPower,car.power,0.00000001);
        assertEquals(expectedYear,car.year);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_null_string(){
        Car car=new Car(null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_inncorectInput(){
        Car car=new Car("abcd");
    }


}