package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Controller.cell.SystemMsgItem;
import sample.bean.SystemMsg;

import java.net.URL;
import java.util.ResourceBundle;

public class SystemMsgController implements Initializable {
//    @FXML
//    private ListView<SystemMsg> lv_msg;
    @FXML
    private TableView<SystemMsg> tb_msg;
    @FXML
    private TableColumn<SystemMsg,String> msgId;
    @FXML
    private TableColumn<SystemMsg,String> msgDate;
    @FXML
    private TableColumn<SystemMsg,String> msgTitle;
    @FXML
    private TableColumn<SystemMsg,String> msgType;
    @FXML
    private TableColumn<SystemMsg,String> msgUser;
    @FXML
    private TableColumn<SystemMsg,String> msgState;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
    public void init(){
        ObservableList<SystemMsg> listdata = FXCollections.observableArrayList(
                new SystemMsg("1","关于十一放假通知","关于十一放假通知","2017-09-25","已读","国际放假")
                ,new SystemMsg("2","关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25","已读","国际放假"),
                new SystemMsg("3","关于十一放假通知关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25","已读","国际放假"),
        new SystemMsg("4","关于十一放假通知关于十一放假通知关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25","已读","国际放假"),
        new SystemMsg("5","关于十一放假通知关于十一放假通知关于十一放假通知关于十一放假通知关于十一放假通知","关于十一放假通知","2017-09-25","已读","国际放假"));
//
//        lv_msg.setItems(listdata);
//        lv_msg.setCellFactory(param -> new SystemMsgItem());
//        //添加事件的监听
//        lv_msg.setOnMouseClicked(event ->{
//            SystemMsg msg =  lv_msg.getSelectionModel().getSelectedItem();
//            //这里打开一个浏览器网页  还是用原生的打开网页？
//        });
        tb_msg.setItems(listdata);
        msgId.setCellValueFactory(data->data.getValue().idProperty());
        msgDate.setCellValueFactory(data->data.getValue().timeProperty());
        msgTitle.setCellValueFactory(data->data.getValue().titleProperty());
        msgType.setCellValueFactory(data->data.getValue().typeProperty());
        msgUser.setCellValueFactory(data->data.getValue().contentProperty());
        msgState.setCellValueFactory(data->data.getValue().stateProperty());
    }
}
