package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import sample.Controller.cell.SystemMsgItem;
import sample.bean.SystemMsg;

import java.net.URL;
import java.util.ResourceBundle;

public class SystemMsgController implements Initializable {
    @FXML
    private ListView<SystemMsg> lv_msg;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
    public void init(){
        ObservableList<SystemMsg> listdata = FXCollections.observableArrayList(new SystemMsg("1","关于十一放假通知","关于十一放假通知","2017-09-25")
                ,new SystemMsg("2","关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25"),
                new SystemMsg("3","关于十一放假通知关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25"),
        new SystemMsg("4","关于十一放假通知关于十一放假通知关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25"),
        new SystemMsg("5","关于十一放假通知关于十一放假通知关于十一放假通知关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25"));

        lv_msg.setItems(listdata);
        lv_msg.setCellFactory(param ->{
        return new SystemMsgItem();}
        );
        lv_msg.getSelectionModel().selectionModeProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue.getDeclaringClass().getName());
        });
    }
}
