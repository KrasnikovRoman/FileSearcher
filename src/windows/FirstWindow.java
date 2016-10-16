package windows;

import helper.Constants;
import logic.Searching;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by roman on 11.08.16.
 * Окно поиска приложения
 */
public class FirstWindow extends JFrame implements ActionListener {
    private JTextField textField;
    private JLabel label;
    private JButton button;
    private JRadioButton radioButton;

    public FirstWindow() {
        super();
        this.setSize(Constants.width, Constants.height);
        this.setTitle(Constants.applicationName);
        this.getContentPane().setLayout(null);
        this.add(createTextField(), null);
        this.add(createLabel(), null);
        this.add(createButton(), null);
        this.add(createRadioButton(), null);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

    private JRadioButton createRadioButton() {
        if (radioButton == null) {
            radioButton = new JRadioButton(Constants.radioButtonName, false);
            radioButton.setBounds(Constants.radioButtonX, Constants.radioButtonY, Constants.radioButtonWidth, Constants.radioButtonHeight);
            radioButton.addActionListener(this);
        }
        return radioButton;
    }

    /**
     * Слушатель событий от кнопки.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Constants.buttonName) && !textField.getText().equals("")) {
            Thread searchingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Searching searching;
                    if (textField.getText().equals("*"))
                        searching = new Searching("." + textField.getText(), radioButton.isSelected());
                    else
                        searching = new Searching(textField.getText(), radioButton.isSelected());
                    Path startDirectory = Paths.get(Constants.workingDir);
                    try {
                        Files.walkFileTree(startDirectory, searching);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    new SecondWindow(searching.getInformation());

                }
            });
            searchingThread.start();
            try {
                searchingThread.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }


        }
    }


}
