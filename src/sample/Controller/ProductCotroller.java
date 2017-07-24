package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductCotroller implements Initializable {
    @FXML
    private WebView web;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebEngine engine = web.getEngine();
        engine.load("https://baike.baidu.com/item/%E4%BA%BA%E5%8F%82/6226?fr=aladdin");
    }
}
