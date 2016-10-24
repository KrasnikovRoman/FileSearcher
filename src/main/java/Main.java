import windows.FirstWindow;

import javax.swing.SwingUtilities;

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

