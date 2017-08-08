package sample.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.bean.AdvBuy;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * 预埋单
 */
public class AdvBuyController implements Initializable {
    @FXML
    private ToggleGroup priceGroup;
    @FXML
    private Label lb_buy_price;
    @FXML
    private Label lb_can_buynum;
    @FXML
    private Label lb_buy_num;

    /**
     * Tableview
     */
    @FXML
    private TableView<AdvBuy> tb_details;
    @FXML
    private TableColumn<AdvBuy,String> number;
    @FXML
    private TableColumn<AdvBuy,String> goodNum;
    @FXML
    private TableColumn<AdvBuy,String> goodName;
    @FXML
    private TableColumn<AdvBuy,String> business;
    @FXML
    private TableColumn<AdvBuy,String> price;
    @FXML
    private TableColumn<AdvBuy,String> num;
    @FXML
    private TableColumn<AdvBuy,String> date;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableView();
    }

    private void initTableView() {
        final ObservableList<AdvBuy> datas = FXCollections.observableArrayList(
                new AdvBuy("1","60008","蚂蚁牙黑","卖","20","3","2017-08-07 00:00:00"),
                new AdvBuy("2","60008","蚂蚁牙黑","卖","20","3","2017-08-07 00:00:00"),
                new AdvBuy("3","60008","蚂蚁牙黑","卖","20","3","2017-08-07 00:00:00"),
                new AdvBuy("4","60008","蚂蚁牙黑","卖","20","3","2017-08-07 00:00:00"),
                new AdvBuy("5","60008","蚂蚁牙黑","卖","20","3","2017-08-07 00:00:00")
        );
        tb_details.setItems(datas);
        tb_details.setEditable(false);
        number.setCellValueFactory(data-> data.getValue().numberProperty());
        goodNum.setCellValueFactory(data-> data.getValue().goodNumProperty());
        goodName.setCellValueFactory(data-> data.getValue().goodNameProperty());
        business.setCellValueFactory(data-> data.getValue().businessProperty());
        price.setCellValueFactory(data-> data.getValue().priceProperty());
        num.setCellValueFactory(data-> data.getValue().numProperty());
        date.setCellValueFactory(data-> data.getValue().dateProperty());

    }

    public void init(){
        priceGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton chk = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
            switch (chk.getText()){
                case "预埋卖出":
                    lb_buy_price.setText("卖出价格");
                    lb_can_buynum.setText("可卖数量");
                    lb_buy_num.setText("卖出数量");
                    break;
                case "预埋买入":
                    lb_buy_price.setText("买入价格");
                    lb_can_buynum.setText("可买数量");
                    lb_buy_num.setText("买入数量");
                    break;
            }
        });
    }

}
