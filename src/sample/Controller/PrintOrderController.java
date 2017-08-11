package sample.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sample.bean.Order;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * 打印自提
 */

public class PrintOrderController implements Initializable {
    @FXML
    private TableView<Order> tv_cancel;
    @FXML
    private TableColumn<Order,String> orderNo;
    @FXML
    private TableColumn<Order,String> goodCode;
    @FXML
    private TableColumn<Order,String> goodName;
    @FXML
    private TableColumn<Order,String> inOrOut;
    @FXML
    private TableColumn<Order,String> money;
    @FXML
    private TableColumn<Order,String> num;
    @FXML
    private TableColumn<Order,String> noDeal;
    @FXML
    private TableColumn<Order,String> state;
    @FXML
    private TableColumn<Order,String> createTime;
    @FXML
    private TableColumn<Order,String> cencal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            getData();
    }
    public void init(){

    }

    @FXML
    private  void getData() {
        final ObservableList<Order> datas = FXCollections.observableArrayList(
                new Order("20170807","60008","木糖醇","买入",20.2D,3,2,1,"2017-08-07 00:00:00"),
                new Order("20170807","60008","木糖醇","买入",20.2D,4,2,1,"2017-08-07 00:00:00"),
                new Order("20170807","60008","木糖醇","买入",20.2D,5,2,1,"2017-08-07 00:00:00"),
                new Order("20170807","60008","木糖醇","买入",20.2D,6,2,1,"2017-08-07 00:00:00")
        );
        tv_cancel.setEditable(false);
        tv_cancel.setItems(datas);
        orderNo.setCellValueFactory(data->data.getValue().orderNoProperty());
        goodCode.setCellValueFactory(data->data.getValue().goodCodeProperty());
        goodName.setCellValueFactory(data->data.getValue().goodNameProperty());
        inOrOut.setCellValueFactory(data->data.getValue().inOrOutProperty());
        money.setCellValueFactory(data->data.getValue().moneyProperty().asString());
        num.setCellValueFactory(data->data.getValue().numProperty().asString());
        noDeal.setCellValueFactory(data->data.getValue().noDealProperty().asString());
        state.setCellValueFactory(data->{if(data.getValue().stateProperty().asString().equals("1")){
            return new SimpleStringProperty("已成交");
        }else{
            return new SimpleStringProperty("未成交");
        }
        });
        createTime.setCellValueFactory(data->data.getValue().createTimeProperty());

        Callback<TableColumn<Order,String>,TableCell<Order,String>> cellCallback = new Callback<TableColumn<Order,String>,TableCell<Order,String>>() {
            @Override
            public TableCell<Order, String> call(TableColumn<Order, String> param) {
                final Button btn = new Button("撤销");
                final TableCell<Order, String> cell = new TableCell<Order, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction(event -> {
                            Order order = getTableView().getItems().get(getIndex());
                            //这里进行撤销委托的操作
                            System.out.println("撤销委托为"+order.numProperty()+datas.remove(order));
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
                return cell;
            }
        };

        cencal.setCellFactory(cellCallback);
    }
}
