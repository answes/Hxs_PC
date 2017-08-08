package sample.popupwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SystemSetDialog{

    public SystemSetDialog()  {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/dialog_system_set.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,400,250);
        dialog.setScene(scene);
        dialog.show();
        init();
    }

    private void init() {

    }
}
