package sample.popupwindow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class OutMoneyDialog {
    @FXML
    private TextField name;
    @FXML
    private Button submit;
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> market;
    @FXML
    private ComboBox<String> bank;
    @FXML
    private TextField money;
    @FXML
    private Label canOutMoney;
    @FXML
    private TextField capital;
    @FXML
    private TextField remarks;

    public OutMoneyDialog()  {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("出金");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/root_dialog_out_money.fxml"));
        fxmlLoader.setController(this);
        Parent root = null;
        try {
            root =  fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,410,520);
        dialog.setScene(scene);
        dialog.show();
        init();
    }

    private void init() {
        ObservableList<String > marketData= FXCollections.observableArrayList("发售市场");
        market.setItems(marketData);
        ObservableList<String > bankData= FXCollections.observableArrayList("中吉商品");
        bank.setItems(bankData);
        onClick();
    }

    private void onClick() {

    }
}
