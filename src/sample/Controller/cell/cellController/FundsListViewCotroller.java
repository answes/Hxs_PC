package sample.Controller.cell.cellController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FundsListViewCotroller {
    @FXML
    private AnchorPane root;
    @FXML
    private Label lb_name;
    @FXML
    private Label lb_value;

    public FundsListViewCotroller()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../../fxml/funds_list_view.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void initData(String name,double value){
        lb_name.setText(name);
        lb_value.setText(String.valueOf(value));
    }

    public AnchorPane getRoot(){
        return  root;
    }

}
