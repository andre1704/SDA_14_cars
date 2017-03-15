package andrzej.slowinski.cars;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarsManageGui extends JFrame {


    private CarRepository carRepository;

    public JList<Car> getCarJList() {
        return carJList;
    }

    public void setCarJList(JList<Car> carJList) {
        this.carJList = carJList;
    }

    private JList<Car> carJList;
    private JButton saveToFile;
    private JButton jButtonLoadFromFile;
    private JButton jButtonDeleteFromFile;


    public CarsManageGui() {
        setTitle("cars manager");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        carJList = new JList<Car>();
        carJList.setSize(200, 200);
        carJList.setLocation(20, 20);
        add(carJList);
        JButton jButton = new JButton("Load");
        jButton.setLocation(222, 20);
        jButton.setSize(120, 20);
        add(jButton);
        carRepository = new CarRepository();
        CarGuiPanel carGuiPanel = new CarGuiPanel(this,carRepository);
        carGuiPanel.setLocation(250, 120);
        carGuiPanel.setSize(300, 300);
        add(carGuiPanel);
        saveToFile = new JButton("Save to file");
        saveToFile.setLocation(300, 500);
        saveToFile.setSize(200, 20);
        add(saveToFile);
        jButtonLoadFromFile = new JButton("load from file");
        jButtonLoadFromFile.setSize(120, 20);
        jButtonLoadFromFile.setLocation(20, 280);
        add(jButtonLoadFromFile);
        jButtonDeleteFromFile=new JButton(("delete selected"));
        jButtonDeleteFromFile.setSize(120,20);
        jButtonDeleteFromFile.setLocation(20,240);
        add(jButtonDeleteFromFile);
        jButtonDeleteFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car=carJList.getSelectedValue();
                carRepository.deleteFromList(car);
                showInFrame();
            }
        });

        jButtonLoadFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carRepository.setListFromFile("car.txt");
                    showInFrame();
                } catch (IOException e1) {
                    System.out.println("a");
                }
            }
        });
        saveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carRepository.saveToFIle();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        carJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Car selectedCar = carJList.getSelectedValue();
                if (selectedCar != null) {
                    carGuiPanel.setEditedCar(selectedCar);
                }
            }
        });
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInFrame();
            }
        });
    }

    private void showInFrame() {
        Car[] cars = getCars();
        carJList.setListData(cars);
    }

    public Car[] getCars() {
        List<Car> carList = carRepository.getCarList();
        Car[] cars = new Car[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            cars[i] = carList.get(i);
        }
        return cars;
    }


    public static void main(String[] args) {
        new CarsManageGui();
    }
}
