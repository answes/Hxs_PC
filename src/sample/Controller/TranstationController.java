package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import sample.bean.Commodity;

import java.net.URL;
import java.util.ResourceBundle;

public class TranstationController implements Initializable {
    @FXML
    private Label lb_transcation_title;
    @FXML
    private TextField tf_commNum;
    @FXML
    private TextField tf_commName;
    @FXML
    private TextField tf_buy_price;
    @FXML
    private TextField tf_can_butnum;
    @FXML
    private Label lb_byy_price;
    @FXML
    private Label lb_can_buy;

    /**
     *
     * @param type 1 买入  2卖出
     * @param transcationTitle
     */
    public void initData(int type,String transcationTitle){
        if(type == 1){
            lb_byy_price.setText("买入价格");
            lb_can_buy.setText("可买数量");
            lb_transcation_title.setText("买入商品");
        }else{
            lb_byy_price.setText("卖出价格");
            lb_can_buy.setText("可卖数量");
            lb_transcation_title.setText("卖出商品 ");
        }
    }

    public void setTableViewOneClick(Commodity commodity){
        tf_commNum.setText(commodity.getCommNum());
        tf_commName.setText(commodity.getCommName());
        tf_buy_price.setText(String.valueOf(commodity.getNewPrice()));
        tf_can_butnum.setText(String.valueOf(commodity.getCount()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
