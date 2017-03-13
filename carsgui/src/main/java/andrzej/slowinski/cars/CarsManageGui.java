package andrzej.slowinski.cars;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField jTextFieldBrand;
    private JTextField jTextFieldModel;
    private JTextField jTextFieldYear;
    private JTextField jTextFieldPower;
    private JButton jButtonSave;

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
        JButton jButton = new JButton("wczytaj");
        jButton.setLocation(222, 20);
        jButton.setSize(120, 20);
        add(jButton);
        carRepository = new CarRepository();
        editButton = new JButton("edytuj");
        editButton.setLocation(360, 20);
        editButton.setSize(120, 20);
        add(editButton);
        jLabelBrand = new JLabel("Brand");
        jLabelBrand.setLocation(360, 80);
        jLabelBrand.setSize(120, 20);
        add(jLabelBrand);
        jTextFieldBrand = new JTextField();
        jTextFieldBrand.setLocation(360, 100);
        jTextFieldBrand.setSize(120, 20);
        add(jTextFieldBrand);
        jLabelModel = new JLabel("Model");
        jLabelModel.setSize(120, 20);
        jLabelModel.setLocation(360, 140);
        add(jLabelModel);
        jTextFieldModel = new JTextField();
        jTextFieldModel.setLocation(360, 160);
        jTextFieldModel.setSize(120, 20);
        add(jTextFieldModel);
        jLabelPower = new JLabel("Power");
        jLabelPower.setLocation(360, 200);
        jLabelPower.setSize(120, 20);
        add(jLabelPower);
        jTextFieldPower = new JTextField();
        jTextFieldPower.setSize(120, 20);
        jTextFieldPower.setLocation(360, 220);
        add(jTextFieldPower);
        jLabelYear = new JLabel("Year");
        jLabelYear.setLocation(360, 260);
        jLabelYear.setSize(120, 20);
        add(jLabelYear);
        jTextFieldYear = new JTextField();
        jTextFieldYear.setSize(120, 20);
        jTextFieldYear.setLocation(360, 280);
        add(jTextFieldYear);
        jButtonSave = new JButton("zapisz");
        jButtonSave.setSize(120, 20);
        jButtonSave.setLocation(360, 350);
        add(jButtonSave);

        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = carJList.getSelectedIndex();
                Car car = carJList.getSelectedValue();

                if (i >= 0) {
                    String brand = jTextFieldBrand.getText();
                    String model = jTextFieldModel.getText();
                    int year = Integer.parseInt(jTextFieldYear.getText());
                    double power = Double.parseDouble(jTextFieldPower.getText());
                    car.setYear(year);
                    car.setPower(power);
                    car.setModel(model);
                    car.setBrand(brand);
                    carJList.repaint();
                }
            }
        });

        carJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int i = carJList.getSelectedIndex();

                if (i >= 0) {
                    jTextFieldModel.setText(carJList.getModel().getElementAt(i).getModel());
                    jTextFieldYear.setText(String.valueOf(carJList.getModel().getElementAt(i).getYear()));
                    jTextFieldPower.setText(String.valueOf(carJList.getModel().getElementAt(i).getPower()));
                    jTextFieldBrand.setText(carJList.getModel().getElementAt(i).getBrand());

                }

            }
        });

//        editButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int i = carJList.getSelectedIndex();
//
//                if (i >= 0) {
//                    jTextFieldModel.setText(carJList.getModel().getElementAt(i).getModel());
//                    jTextFieldYear.setText(String.valueOf(carJList.getModel().getElementAt(i).getYear()));
//                    jTextFieldPower.setText(String.valueOf(carJList.getModel().getElementAt(i).getPower()));
//                    jTextFieldBrand.setText(carJList.getModel().getElementAt(i).getBrand());
//
//                }
//            }
//        });
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
