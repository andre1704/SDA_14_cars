package andrzej.slowinski.cars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarsManageGui extends JFrame {


    private CarRepository carRepository;
    private JList<Car> carJList;
    private JButton editButton;
    private JLabel jLabelBrand;
    private JLabel jLabelModel;
    private JLabel jLabelYear;
    private JLabel jLabelPower;
    public CarsManageGui() {
        setTitle("cars manager");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(555, 300);
        setLayout(null);
        carJList = new JList<Car>();
        carJList.setSize(200, 200);
        carJList.setLocation(20, 20);
        add(carJList);

        JButton jButton = new JButton("wczytaj");
        jButton.setLocation(222, 20);
        jButton.setSize(120, 20);
        add(jButton);
        carRepository = new CarRepository();

        editButton =new JButton("edytuj");
        editButton.setLocation(360,20);
        editButton.setSize(120,20);
        add(editButton);
        jLabelBrand=new JLabel("Brand");








        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Car> carList = carRepository.getCarList();

                // ZAMIANA LISTY NA TABLICĘ
                Car[] cars = new Car[carList.size()];
                for (int i = 0; i < carList.size(); i++) {
                    cars[i] = carList.get(i);
                }

                carJList.setListData(cars);
            }
        });

    }

    public static void main(String[] args) {
        new CarsManageGui();
    }
}
