package sample.Controller.cell;

import javafx.scene.control.ListCell;
import sample.Controller.cell.cellController.FundsListViewCotroller;
import sample.Controller.cell.cellController.SystemMsgItemController;
import sample.bean.SystemMsg;

public class SystemMsgItem extends ListCell<SystemMsg> {
    @Override
    protected void updateItem(SystemMsg item, boolean empty) {
        super.updateItem(item, empty);
        if(null != item) {
            SystemMsgItemController cotroller = new SystemMsgItemController();
            cotroller.setData(item);
            setGraphic(cotroller.getRoot());
        }
    }
}
