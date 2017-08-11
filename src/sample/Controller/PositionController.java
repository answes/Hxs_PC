package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * 持仓
 */
public class PositionController implements Initializable {
    @FXML
    private TableView tb_deal;  //已成交申购
    @FXML
    private TableView tb_sum;   //持仓汇总
    @FXML
    private TableView tb_detail;//持仓明细
    @FXML
    private CheckBox cb_now;
    @FXML
    private CheckBox cb_history;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * @param type 0.已成交申购，1.持仓汇总，2.持仓明细
     */
    public void init(int type) {
        hideTableView();
        switch (type) {
            case 0:
                cb_now.setVisible(false);
                cb_history.setVisible(false);
                tb_deal.setVisible(true);
                break;
            case 1:
                cb_now.setVisible(true);
                cb_history.setVisible(true);
                tb_sum.setVisible(true);
                break;
            case 2:
                cb_now.setVisible(true);
                cb_history.setVisible(true);
                tb_detail.setVisible(true);
                break;
        }
    }


    @FXML
    private void hideTableView() {
        tb_deal.setVisible(false);
        tb_sum.setVisible(false);
        tb_detail.setVisible(false);
    }
}
