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

    public void initData(String transcationTitle){
        setType(transcationTitle);
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

    public void setType(String type) {
        switch (type){
            case "买入":
                lb_transcation_title.setText("买入商品");
                break;
            case "卖出":
                lb_transcation_title.setText("卖出商品 ");
                break;
            case "撤单":
                break;
            case "预埋单":
                break;
            case "资金信息":
                break;
            case "委托查询":
                break;
            case "成交查询":
                break;
            case "持仓汇总":
                break;
            case "持仓明细":
                break;
            case "系统公告":
                break;
            case "申购":
                break;
            case "确认配售":
                break;
            case "申购记录":
                break;
            case "已成交申购":
                break;
            case "配售查询":
                break;
            case "托管申请":
                break;
            case "托管申请查询":
                break;
            case "支付挂牌费":
                break;
            case "提货申请":
                break;
            case "自提打印":
                break;
            case "撤销提货":
                break;
            case "提货查询":
                break;
        }
    }
}
