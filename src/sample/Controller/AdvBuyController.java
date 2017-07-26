package sample.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onClick();
    }

    private void onClick() {
    }

    public void init(){
        priceGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton chk = (RadioButton)newValue.getToggleGroup().getSelectedToggle(); // Cast object to radio button
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
            }
        });
    }

}
