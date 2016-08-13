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
    private JRadioButton radioButton;

    HashMap<String, String> information = new HashMap<>();


    public FirstWindow() {
        super();
        searching = new Searching();
        this.setSize(Constants.width, Constants.height);
        this.setTitle(Constants.applicationName);
        this.getContentPane().setLayout(null);
        this.add(createTextField(), null);
        this.add(createLabel(), null);
        this.add(createButton(), null);
        this.add(creareRadioButton(), null);
        this.setVisible(true);
        this.setResizable(false);
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
            label = new JLabel("Введите имя файла для поиска");
            label.setBounds(10, 10, 300, 15);
        }
        return label;
    }

    private JButton createButton() {
        if (button == null) {
            button = new JButton("Search");
            button.setBounds(315, 30, 50, 20);
            button.addActionListener(this);
        }
        return button;
    }

    private JRadioButton creareRadioButton() {
        if (radioButton == null) {
            radioButton = new JRadioButton("Additional information",false);
            radioButton.setBounds(12, 60, 200, 20);
            radioButton.addActionListener(this);
        }
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search") && !textField.getText().equals("")) {
            new SecondWindow(information);
        }
    }
}
