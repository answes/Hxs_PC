package sample.popupwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.util.Constant;

import java.io.IOException;

public class SignedDialog {

    public SignedDialog(int type)  {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        if(type == Constant.SIGNED){
            dialog.setTitle("签约");
        }else{
            dialog.setTitle("解约");
        }
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxml/root_dialog_signed.fxml"));
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
