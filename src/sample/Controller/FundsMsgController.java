package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import sample.Controller.cell.FundsListViewCell;
import sample.bean.Funds;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 资金信息
 */
public class FundsMsgController implements Initializable {
    @FXML
    private ListView<Funds> list1;
    @FXML
    private ListView<Funds> list2;
    @FXML
    private ListView<Funds> list3;

    ObservableList<Funds> listdata1 = FXCollections.observableArrayList(new Funds("上日余额", 413.0)
            , new Funds("+出入金", 413.0), new Funds("-出入金手续费", 413.0)
            , new Funds("+卖出贷款", 413.0), new Funds("-买入贷款", 413.0),
            new Funds("-当日发行冻结资金", 413.0), new Funds("+发行解冻资金", 413.0),
            new Funds("-委托冻结资金", 413.0));

    ObservableList<Funds> listdata2 = FXCollections.observableArrayList(new Funds("-日杂费", 413.0),
            new Funds("-发行手续费", 413.0), new Funds("-交易手续费", 413.0),
            new Funds("-提货单费用", 413.0)
            , new Funds("-其他冻结资金", 413.0), new Funds("-其他费用", 413.0),
            new Funds("+资金内转", 413.0));

    ObservableList<Funds> listdata3 = FXCollections.observableArrayList(new Funds("当前可用资金", 413.0),
            new Funds("+持有市值", 413.0), new Funds("+委托冻结资金", 413.0)
            , new Funds("+当日发行冻结资金", 413.0), new Funds("+历史发行冻结资金", 413.0),
            new Funds("+当日其他冻结资金", 413.0), new Funds("=当前权益", 413.0));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initList();

    }

    private void initList() {
        list1.setItems(listdata1);
        list1.setCellFactory(param -> {
            return new FundsListViewCell();
        });
        list2.setItems(listdata2);
        list2.setCellFactory(param -> {
            return new FundsListViewCell();
        });
        list3.setItems(listdata3);
        list3.setCellFactory(param -> {
            return new FundsListViewCell();
        });


    }

    public void init() {

    }
}
