package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.bean.Commodity;
import sample.bean.Trading;

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
    private TextField tf_can_buynum;
    @FXML
    private Label lb_byy_price;
    @FXML
    private Label lb_can_buy;

    /**
     * TableView
     */
    @FXML
    private TableView<Trading> tb_details;
    @FXML
    private TableColumn<Trading,String> goodNum;
    @FXML
    private TableColumn<Trading,String> goodName;
    @FXML
    private TableColumn<Trading,String> avgPrice;
    @FXML
    private TableColumn<Trading,String> nowPrice;
    @FXML
    private TableColumn<Trading,String> count;
    @FXML
    private TableColumn<Trading,String> loan;
    @FXML
    private TableColumn<Trading,String> useNum;
    @FXML
    private TableColumn<Trading,String> postionWin;
    @FXML
    private TableColumn<Trading,String> winScale;
    @FXML
    private TableColumn<Trading,String> marketValue;

    /**
     *
     * @param type 1 买入  2卖出
     *
     */
    public void initData(int type){
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
        tf_can_buynum.setText(String.valueOf(commodity.getOutNumber()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    private void init() {
        final ObservableList<Trading> datas = FXCollections.observableArrayList(
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30"),
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30"),
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30"),
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30"),
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30"),
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30"),
                new Trading("60008","木糖醇","203","200","3","50","2","0","0.56","30")
        );
        tb_details.setItems(datas);
        tb_details.setEditable(false);
        goodNum.setCellValueFactory(data-> data.getValue().goodNumProperty());
        goodName.setCellValueFactory(data-> data.getValue().goodNameProperty());
        avgPrice.setCellValueFactory(data-> data.getValue().avgPriceProperty());
        nowPrice.setCellValueFactory(data-> data.getValue().nowPriceProperty());
        count.setCellValueFactory(data-> data.getValue().countProperty());
        loan.setCellValueFactory(data-> data.getValue().loanProperty());
        useNum.setCellValueFactory(data-> data.getValue().useNumProperty());
        postionWin.setCellValueFactory(data-> data.getValue().postionWinProperty());
        winScale.setCellValueFactory(data-> data.getValue().winScaleProperty());
        marketValue.setCellValueFactory(data-> data.getValue().marketValueProperty());

    }

}
