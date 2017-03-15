package andrzej.slowinski.cars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by RENT on 2017-03-13.
 */
public class CarGuiPanel extends JPanel {
    private Car editedCar;
    private CarsManageGui managerWindow;

    private JLabel jLabelBrand;
    private JLabel jLabelModel;
    private JLabel jLabelYear;
    private JLabel jLabelPower;
    private JTextField jTextFieldBrand;
    private JTextField jTextFieldModel;
    private JTextField jTextFieldYear;
    private JTextField jTextFieldPower;

    private JButton jButtonCreateCar;
    private JButton jButtonSave;

    CarGuiPanel(CarsManageGui window,CarRepository carRepository) {
        this.managerWindow=window;
        setVisible(true);
        setLayout(null);
        setBackground(Color.lightGray);
        jLabelBrand = new JLabel("Brand");
        jLabelBrand.setLocation(0, 0);
        jLabelBrand.setSize(120, 20);
        add(jLabelBrand);
        jTextFieldBrand = new JTextField();
        jTextFieldBrand.setLocation(0, 40);
        jTextFieldBrand.setSize(120, 20);
        add(jTextFieldBrand);
        jLabelModel = new JLabel("Model");
        jLabelModel.setSize(120, 20);
        jLabelModel.setLocation(0, 80);
        add(jLabelModel);
        jTextFieldModel = new JTextField();
        jTextFieldModel.setLocation(0, 120);
        jTextFieldModel.setSize(120, 20);
        add(jTextFieldModel);
        jLabelPower = new JLabel("Power");
        jLabelPower.setLocation(0, 160);
        jLabelPower.setSize(120, 20);
        add(jLabelPower);
        jTextFieldPower = new JTextField();
        jTextFieldPower.setSize(120, 20);
        jTextFieldPower.setLocation(0, 180);
        add(jTextFieldPower);
        jLabelYear = new JLabel("Year");
        jLabelYear.setLocation(0, 220);
        jLabelYear.setSize(120, 20);
        add(jLabelYear);
        jTextFieldYear = new JTextField();
        jTextFieldYear.setSize(120, 20);
        jTextFieldYear.setLocation(0, 260);
        add(jTextFieldYear);
        jButtonSave = new JButton("zapisz");
        jButtonSave.setSize(120, 20);
        jButtonSave.setLocation(150, 280);
        add(jButtonSave);
        jButtonCreateCar = new JButton("add car");
        jButtonCreateCar.setSize(120, 20);
        jButtonCreateCar.setLocation(20,280);
        add(jButtonCreateCar);



        jButtonCreateCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand=jTextFieldBrand.getText();
                String model=jTextFieldModel.getText();
                int year= Integer.parseInt(jTextFieldYear.getText());
                double power= Double.parseDouble(jTextFieldPower.getText());
                carRepository.addCar(new Car(brand,model,power,year));
                java.util.List<Car> carList = carRepository.getCarList();
                Car[] cars = managerWindow.getCars();
                JList<Car> list= managerWindow.getCarJList();
                list.setListData(cars);
                window.repaint();
            }
        });
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (editedCar!= null) {
                    editedCar.setYear(Integer.parseInt(jTextFieldYear.getText()));
                    editedCar.setPower(Double.parseDouble(jTextFieldPower.getText()));
                    editedCar.setModel(jTextFieldModel.getText());
                    editedCar.setBrand(jTextFieldBrand.getText());
                    window.repaint();
                }

            }
        });

    }


    public void setEditedCar(Car editedCar) {
        this.editedCar = editedCar;
        jTextFieldModel.setText(editedCar.getModel());
        jTextFieldYear.setText(String.valueOf(editedCar.getYear()));
        jTextFieldPower.setText(String.valueOf(editedCar.getPower()));
        jTextFieldBrand.setText(editedCar.getBrand());
    }

    public JTextField getjTextFieldBrand() {
        return jTextFieldBrand;
    }

    public void setjTextFieldBrand(JTextField jTextFieldBrand) {
        this.jTextFieldBrand = jTextFieldBrand;
    }

    public JTextField getjTextFieldModel() {
        return jTextFieldModel;
    }

    public void setjTextFieldModel(JTextField jTextFieldModel) {
        this.jTextFieldModel = jTextFieldModel;
    }

    public JTextField getjTextFieldYear() {
        return jTextFieldYear;
    }

    public void setjTextFieldYear(JTextField jTextFieldYear) {
        this.jTextFieldYear = jTextFieldYear;
    }

    public JTextField getjTextFieldPower() {
        return jTextFieldPower;
    }

    public void setjTextFieldPower(JTextField jTextFieldPower) {
        this.jTextFieldPower = jTextFieldPower;
    }

    public JButton getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(JButton jButtonSave) {
        this.jButtonSave = jButtonSave;

    }


}
