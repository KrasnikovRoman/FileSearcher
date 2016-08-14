package windows;

import helper.CellRenderer;
import helper.Constants;

import javax.swing.*;
import java.awt.*;


/**
 * Created by roman on 11.08.16.
 */
public class SecondWindow {
    String[] headers = {"File Name", "Information"};
    String[][] data = {};
    JTable table;

    public SecondWindow() {
        JFrame frame = new JFrame(Constants.secondWindowName);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(Constants.secondWindowWidth, Constants.secondWindowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new JTable(data, headers);
        table.setRowMargin(1);
        JScrollPane panel = new JScrollPane(table);
        table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
        table.setPreferredScrollableViewportSize(new Dimension(390, 290));
        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
}
