package helper;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by roman on 14.08.16.
 * Вспомогательный класс для правильной отрисовки таблицы. Он помогает переносить строки в пределах одной записи в таблице.
 */
public class CellRenderer extends JTextArea implements TableCellRenderer {
    public CellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object arg1, boolean isSelected, boolean hasFocus, int row, int column) {
        String data = arg1.toString();
        int lineWidth = this.getFontMetrics(this.getFont()).stringWidth(data);
        int lineHeight = this.getFontMetrics(this.getFont()).getHeight();
        int rowWidth = table.getCellRect(row, column, true).width;

        int newRowHeight = (int) ((lineWidth / rowWidth) * (lineHeight)) + lineHeight * 2 + 40;
        if (table.getRowHeight(row) != newRowHeight) {
            table.setRowHeight(row, newRowHeight);
        }

        this.setText(data);
        return this;
    }
}
