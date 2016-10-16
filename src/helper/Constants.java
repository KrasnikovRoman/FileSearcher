package helper;

/**
 * Created by roman on 11.08.16.
 * Интерфейс для хранения констант
 */
public interface Constants {
    int height = 115;
    int width = 400;
    int secondWindowWidth = 500;
    int secondWindowHeight = 700;
    int textFieldX = 10;
    int textFieldY = 30;
    int textFieldWidth = 300;
    int textFieldHeight = 20;
    int labelX = 10;
    int labelY = 10;
    int labelWidth = 300;
    int labelHeight = 15;
    int buttonX = 315;
    int buttonY = 30;
    int buttonWidth = 50;
    int buttonHeight = 20;
    int radioButtonX = 12;
    int radioButtonY = 60;
    int radioButtonWidth = 200;
    int radioButtonHeight = 20;

    String applicationName = "File searcher";
    String labelName = "Enter name of file for searching";
    String buttonName = "Search";
    String radioButtonName = "Additional information";
    String secondWindowName = "Information";

    String workingDir = System.getProperty("user.dir");
}
