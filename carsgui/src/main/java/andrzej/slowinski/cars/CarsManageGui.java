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
    private JList<Car> carJList;
    private JButton saveToFile;

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
        CarGuiPanel carGuiPanel = new CarGuiPanel(this);
        carGuiPanel.setLocation(250, 120);
        carGuiPanel.setSize(300, 300);
        add(carGuiPanel);
        saveToFile=new JButton("Save to file");
        saveToFile.setLocation(300,500);
        saveToFile.setSize(200,20);
        add(saveToFile);

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
