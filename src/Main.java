import javax.swing.*;

/**
 * Created by roman on 11.08.16.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstWindow();

            }
        });
    }
}

// TODO: 11.08.16 Реализовать локигу поиска
