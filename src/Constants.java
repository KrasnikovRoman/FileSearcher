/**
 * Created by roman on 11.08.16.
 */
public interface Constants {
    /*
    Сonstants for drawing the appearance of application
     */
    int height = 125;
    int width = 400;
    int secondWindowWidth = 400;
    int secondWindowHeight = 300;
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
    int radioButton_1_X = 12;
    int radioButton_1_Y = 60;
    int radioButton_1_Width = 200;
    int radioButton_1_Height = 20;
    int radioButton_2_X = 12;
    int radioButton_2_Y = 80;
    int radioButton_2_Width = 250;
    int radioButton_2_Height = 20;


    String applicationName = "File searcher";
    String labelName = "Enter name of file for searching";
    String buttonName = "Search";
    String radioButtonName1 = "Additional information";
    String getRadioButtonName2 = "Search from working directory";
    String secondWindowName = "Information";

    String root = "/";
    String workingDir = System.getProperty("user.dir");
}
