package windows;

import helper.Constants;
import logic.Searching;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by roman on 11.08.16.
 */
public class FirstWindow extends JFrame implements ActionListener {
    private Searching searching;
    private JTextField textField;
    private JLabel label;
    private JButton button;
    private JRadioButton radioButton1, radioButton2;

    HashMap<String, String> information;


    public FirstWindow() {
        super();
        information = new HashMap<>();
        searching = new Searching();
        this.setSize(Constants.width, Constants.height);
        this.setTitle(Constants.applicationName);
        this.getContentPane().setLayout(null);
        this.add(createTextField(), null);
        this.add(createLabel(), null);
        this.add(createButton(), null);
        this.add(creareRadioButton1(), null);
        this.add(createRadioButton2(), null);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

    }

    private JTextField createTextField() {
        if (textField == null) {
            textField = new JTextField();
            textField.setBounds(Constants.textFieldX, Constants.textFieldY, Constants.textFieldWidth, Constants.textFieldHeight);
        }
        return textField;
    }

    private JLabel createLabel() {
        if (label == null) {
            label = new JLabel(Constants.labelName);
            label.setBounds(Constants.labelX, Constants.labelY, Constants.labelWidth, Constants.labelHeight);
        }
        return label;
    }

    private JButton createButton() {
        if (button == null) {
            button = new JButton(Constants.buttonName);
            button.setBounds(Constants.buttonX, Constants.buttonY, Constants.buttonWidth, Constants.buttonHeight);
            button.addActionListener(this);
        }
        return button;
    }

    private JRadioButton creareRadioButton1() {
        if (radioButton1 == null) {
            radioButton1 = new JRadioButton(Constants.radioButtonName1,false);
            radioButton1.setBounds(Constants.radioButton_1_X, Constants.radioButton_1_Y, Constants.radioButton_1_Width, Constants.radioButton_1_Height);
            radioButton1.addActionListener(this);
        }
        return radioButton1;
    }

    private JRadioButton createRadioButton2() {
        if (radioButton2 == null) {
            radioButton2 = new JRadioButton(Constants.getRadioButtonName2, false);
            radioButton2.setBounds(Constants.radioButton_2_X, Constants.radioButton_2_Y, Constants.radioButton_2_Width, Constants.radioButton_2_Height);
            radioButton2.addActionListener(this);
        }
        return radioButton2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Constants.buttonName) && !textField.getText().equals("")) {
            new SecondWindow();
        }
    }


}
