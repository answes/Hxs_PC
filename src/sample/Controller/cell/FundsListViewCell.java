package sample.Controller.cell;

import javafx.scene.control.ListCell;
import sample.Controller.cell.cellController.FundsListViewCotroller;
import sample.bean.Funds;

public class FundsListViewCell extends ListCell<Funds> {

    @Override
    protected void updateItem(Funds item, boolean empty) {
        super.updateItem(item, empty);
        if(null != item) {
            FundsListViewCotroller cotroller = new FundsListViewCotroller();
            cotroller.initData(item.getName(), item.getValue());
            setGraphic(cotroller.getRoot());
        }
    }
}
