package windows;

import helper.Constants;
import logic.Searching;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by roman on 11.08.16.
 * Окно поиска приложения.
 */
public class FirstWindow extends JFrame implements ActionListener {
    private JTextField textField;
    private JLabel label;
    private JButton button;
    private JRadioButton radioButton;

    public FirstWindow() {
        super();
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setTitle(Constants.APPLICATION_NAME);
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
            textField.setBounds(Constants.TEXT_FIELD_X, Constants.TEXT_FIELD_Y, Constants.TEXT_FIELD_WIDTH, Constants.TEXT_FIELD_HEIGHT);
        }
        return textField;
    }

    private JLabel createLabel() {
        if (label == null) {
            label = new JLabel(Constants.LABEL_NAME);
            label.setBounds(Constants.LABEL_X, Constants.LABEL_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        }
        return label;
    }

    private JButton createButton() {
        if (button == null) {
            button = new JButton(Constants.BUTTON_NAME);
            button.setBounds(Constants.BUTTON_X, Constants.BUTTON_Y, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
            button.addActionListener(this);
        }
        return button;
    }

    private JRadioButton createRadioButton() {
        if (radioButton == null) {
            radioButton = new JRadioButton(Constants.RADIO_BUTTON_NAME, false);
            radioButton.setBounds(Constants.RADIO_BUTTON_X, Constants.RADIO_BUTTON_Y, Constants.RADIO_BUTTON_WIDTH, Constants.RADIO_BUTTON_HEIGHT);
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
        boolean isButtonPush = e.getActionCommand().equals(Constants.BUTTON_NAME);
        boolean isFileMaskEmpty = textField.getText().isEmpty();
        if (isButtonPush && !isFileMaskEmpty) {
            Thread searchingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Searching searching;
                    if (textField.getText().equals("*"))
                        searching = new Searching(Constants.ALL_SEARCHING, radioButton.isSelected());
                    else
                        searching = new Searching(textField.getText(), radioButton.isSelected());
                    Path startDirectory = Paths.get(Constants.WORKING_DIR);
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
