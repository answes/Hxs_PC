package sample.Controller.cell.cellController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.bean.SystemMsg;

import java.io.IOException;

public class SystemMsgItemController {
    @FXML
    private AnchorPane root;
    @FXML
    private Label lb_id,lb_title,lb_date;
    public SystemMsgItemController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../../fxml/item_system_msg.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setData(SystemMsg msg){
        lb_id.setText(msg.getId());
        lb_title.setText(msg.getTitle());
        lb_date.setText(msg.getTime());
    }

    public AnchorPane getRoot(){
        return  root;
    }
}
