package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * 成交查询
 */

public class DealQueryController implements Initializable {
    @FXML
    private TableView<String> tb_weituo;
    @FXML
    private TableView<String> tb_deal;
    @FXML
    private TableView<String> tb_shengou;
    @FXML
    private TableView<String> tb_peishou;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     *
     * @param type 0.委托查询，1.成交查询，2.申购记录,3.配售查询
     */
    public void init(int type){
        switch (type){
            case 0:
                hideTableView();
                tb_weituo.setVisible(true);
                break;
            case 1:
                hideTableView();
                tb_deal.setVisible(true);
                break;
            case 2:
                hideTableView();
                tb_shengou.setVisible(true);
                break;
            case 3:
                hideTableView();
                tb_peishou.setVisible(true);
                break;
        }

    }

    @FXML
    private void hideTableView(){
        tb_weituo.setVisible(false);
        tb_deal.setVisible(false);
        tb_shengou.setVisible(false);
        tb_peishou.setVisible(false);
    }
    /**
     * 委托查询tableview初始化
     */
    private void weiTuo() {

    }
}
