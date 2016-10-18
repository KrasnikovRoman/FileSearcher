package windows;

import helper.CellRenderer;
import helper.Constants;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman on 11.08.16.
 * Окно с выводимой информацией о файлах.
 */
public class SecondWindow {

    private final HashMap<String, String> info;
    private final String[] headers = {"File Name", "Information"};
    private final String[][] infoAboutFiles;
    private JTable table;

    public SecondWindow(HashMap<String, String> info) {
        this.info = info;
        infoAboutFiles = new String[info.size()][Constants.NUMBER_DATA_COLUMNS];
        getInfoFromHashMap();
        JFrame frame = createJFrame();
        JScrollPane panel = createTable();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void getInfoFromHashMap() {
        int i = 0;
        for (Map.Entry<String, String> entry : info.entrySet()) {
            infoAboutFiles[i][1] = entry.getKey();
            infoAboutFiles[i][0] = entry.getValue();
            i++;
        }
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame(Constants.SECOND_WINDOW_NAME);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(Constants.SECOND_WINDOW_WIDTH, Constants.SECOND_WINDOW_HEIGHT);
        return frame;
    }

    private JScrollPane createTable() {
        table = new JTable(infoAboutFiles, headers);
        JScrollPane panel = new JScrollPane(table);
        table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
        table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
        table.setPreferredScrollableViewportSize(new Dimension(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT));
        return panel;
    }


}
