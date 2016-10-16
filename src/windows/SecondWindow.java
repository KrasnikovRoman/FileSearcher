package windows;

import helper.CellRenderer;
import helper.Constants;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman on 11.08.16.
 * Окно с выводимой информацией о файлах
 */
public class SecondWindow {
    HashMap<String, String> info;
    String[] headers = {"File Name", "Information"};
    String[][] data;
    JTable table;

    public SecondWindow(HashMap<String, String> info) {
        this.info = info;
        data = new String[info.size()][headers.length];
        createTable();
        JFrame frame = new JFrame(Constants.secondWindowName);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(Constants.secondWindowWidth, Constants.secondWindowHeight);
        table = new JTable(data, headers);
        JScrollPane panel = new JScrollPane(table);
        table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
        table.setPreferredScrollableViewportSize(new Dimension(450, 630));
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void createTable() {
        int i = 0;
        for (Map.Entry<String, String> entry : info.entrySet()) {
            data[i][1] = entry.getKey();
            data[i][0] = entry.getValue();
            i++;
        }
    }
}
