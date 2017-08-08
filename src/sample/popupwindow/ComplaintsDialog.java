package sample.popupwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ComplaintsDialog {

    public ComplaintsDialog()  {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("投诉申诉");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/root_dialog_complaints.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,410,520);
        dialog.setScene(scene);
        dialog.show();
        init();
    }

    private void init() {

    }
}
