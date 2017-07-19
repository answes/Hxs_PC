package sample.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.bean.Commodity;
import sample.util.Constant;
import sample.util.ControlledStage;
import sample.util.StageController;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bigshark on 2017/7/11.
 */
public class MainController implements ControlledStage,Initializable {
   private  StageController myController;

    @FXML
    private ImageView quotesBt;//商品列表
    @FXML
    private ImageView chartAnalysis;//图表分析
    @FXML
    private ImageView productInformation;//商品信息
    @FXML
    private ImageView dealDetails;//成交明细
    @FXML
    private ImageView systemSet;//系统设置
    @FXML
    private ImageView logo;//logo
    @FXML
    private WebView web;//k线图
    @FXML
    private TableView<Commodity> tableview;//商品列表
    @FXML
    private Pane titleMove; //窗口的拖动

    private double xOffset = 0;
    private double yOffset = 0;
    private  WebEngine webEngine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initToolbar();
        initView();
        initTabelView();
        webEngine  = web.getEngine();
        web.setContextMenuEnabled(false);
    }


    private void initToolbar() {
        titleMove.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                event.consume();
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        titleMove.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                event.consume();
                myController.getStage(Constant.mainViewID).setX(event.getScreenX() - xOffset);
                //根据自己的需求，做不同的判断
                if (event.getScreenY() - yOffset < 0) {
                    myController.getStage(Constant.mainViewID).setY(0);
                } else {
                    myController.getStage(Constant.mainViewID).setY(event.getScreenY() - yOffset);
                }
            }
        });
    }

    private void initTabelView() {
        //设置数据源
        final ObservableList<Commodity> datas = FXCollections.observableArrayList(new Commodity(1, "80008", "人参糖", 12.0, 10.3, 30, 0.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(2, "80008", "芝麻糖", 12.0, 10.3, 20, 1.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(3, "80009", "百度糖", 22.0, 20.3, 30, 2.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(4, "80010", "不知糖", 32.0, 30.3, 40, 3.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(5, "80011", "砂糖糖", 42.0, 40.3, 50, 4.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(6, "80012", "人参糖", 52.0, 50.3, 60, 5.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00));

        //设置列表
        TableColumn number = new TableColumn("编号");
        number.setMinWidth(100);
        number.setCellValueFactory(
                new PropertyValueFactory<>("number"));

        TableColumn commNum = new TableColumn("商品代码");
        commNum.setMinWidth(100);
        commNum.setCellValueFactory(
                new PropertyValueFactory<>("commNum"));

        TableColumn commName = new TableColumn("商品名称");
        commName.setMinWidth(100);
        commName.setCellValueFactory(
                new PropertyValueFactory<>("commName"));

        TableColumn openPrice = new TableColumn("开盘价");
        openPrice.setMinWidth(100);
        openPrice.setCellValueFactory(
                new PropertyValueFactory<>("openPrice"));

        TableColumn newPrice = new TableColumn("最新价");
        newPrice.setMinWidth(100);
        newPrice.setCellValueFactory(
                new PropertyValueFactory<>("newPrice"));

        TableColumn count = new TableColumn("现量");
        count.setMinWidth(100);
        count.setCellValueFactory(
                new PropertyValueFactory<>("count"));

        TableColumn upDown = new TableColumn("涨跌");
        upDown.setMinWidth(100);
        upDown.setCellValueFactory(
                new PropertyValueFactory<>("upDown"));

        TableColumn extent = new TableColumn("幅度%");
        extent.setMinWidth(100);
        extent.setCellValueFactory(
                new PropertyValueFactory<>("extent"));

        TableColumn maxPrice = new TableColumn("最高价");
        maxPrice.setMinWidth(100);
        maxPrice.setCellValueFactory(
                new PropertyValueFactory<>("maxPrice"));

        TableColumn mixPrice = new TableColumn("最低价");
        mixPrice.setMinWidth(100);
        mixPrice.setCellValueFactory(
                new PropertyValueFactory<>("mixPrice"));

        TableColumn yestedayPrice = new TableColumn("昨收盘价");
        yestedayPrice.setMinWidth(100);
        yestedayPrice.setCellValueFactory(
                new PropertyValueFactory<>("yestedayPrice"));

        TableColumn comePrice = new TableColumn("买价");
        comePrice.setMinWidth(100);
        comePrice.setCellValueFactory(
                new PropertyValueFactory<>("comePrice"));

        TableColumn comeNumber = new TableColumn("买量");
        comeNumber.setMinWidth(100);
        comeNumber.setCellValueFactory(
                new PropertyValueFactory<>("comeNumber"));

        TableColumn outPrice = new TableColumn("卖价");
        outPrice.setMinWidth(100);
        outPrice.setCellValueFactory(
                new PropertyValueFactory<>("outPrice"));

        TableColumn outNumber = new TableColumn("卖量");
        outNumber.setMinWidth(100);
        outNumber.setCellValueFactory(
                new PropertyValueFactory<>("outNumber"));

        TableColumn overNumber = new TableColumn("成交量");
        overNumber.setMinWidth(100);
        overNumber.setCellValueFactory(
                new PropertyValueFactory<>("overNumber"));

        TableColumn overMoney = new TableColumn("成交金额");
        overMoney.setMinWidth(100);
        overMoney.setCellValueFactory(
                new PropertyValueFactory<>("overMoney"));

        TableColumn avgPrice = new TableColumn("均价");
        avgPrice.setMinWidth(100);
        avgPrice.setCellValueFactory(
                new PropertyValueFactory<>("avgPrice"));

        TableColumn stockNumber = new TableColumn("库存量");
        stockNumber.setMinWidth(100);
        stockNumber.setCellValueFactory(
                new PropertyValueFactory<>("stockNumber"));

        TableColumn numberScale = new TableColumn("量比%");
        numberScale.setMinWidth(100);
        numberScale.setCellValueFactory(
                new PropertyValueFactory<>("numberScale"));

        TableColumn trustScale = new TableColumn("委比%");
        trustScale.setMinWidth(100);
        trustScale.setCellValueFactory(
                new PropertyValueFactory<>("trustScale"));

        TableColumn exchangeScale = new TableColumn("换手率%");
        exchangeScale.setMinWidth(100);
        exchangeScale.setCellValueFactory(
                new PropertyValueFactory<>("exchangeScale"));
        tableview.setItems(datas);
        tableview.getColumns().setAll(number, commNum, commName, openPrice, newPrice,
                count, upDown, extent, maxPrice, mixPrice, yestedayPrice, comePrice, comeNumber, outPrice,
                outNumber, overNumber, overMoney, avgPrice, stockNumber, numberScale, trustScale, exchangeScale);
        tableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //双击事件，进去图标详情
                if (event.getClickCount() == 2) {
                    setTableviewAndWebShowAndHide(false);
                    webEngine.load(getClass().getResource("../html/trend.html").toExternalForm());
                }
            }
        });
    }

    private void initView() {
        quotesBt.setImage(new Image(this.getClass().getResource("../image/list.png").toExternalForm()));
        chartAnalysis.setImage(new Image(this.getClass().getResource("../image/fenxi.png").toExternalForm()));
        productInformation.setImage(new Image(this.getClass().getResource("../image/file.png").toExternalForm()));
        dealDetails.setImage(new Image(this.getClass().getResource("../image/details.png").toExternalForm()));
        systemSet.setImage(new Image(this.getClass().getResource("../image/seting.png").toExternalForm()));
        logo.setImage(new Image(this.getClass().getResource("../image/logo.png").toExternalForm()));

        quotesBt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setTableviewAndWebShowAndHide(true);
            }
        });
        chartAnalysis.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setTableviewAndWebShowAndHide(false);
                webEngine.load(getClass().getResource("../html/kLine.html").toExternalForm());
            }
        });
        String string = "hello word";
        productInformation.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                webEngine.executeScript("show()");
            }
        });
    }

    public void a(){

    }


    private void setTableviewAndWebShowAndHide(boolean tabIsShow){
        tableview.setVisible(tabIsShow);
        if(tabIsShow){
            web.setPrefHeight(0.0);
            web.setPrefWidth(0.0);
            tableview.setPrefHeight(400.0);
            tableview.setPrefWidth(1100.0);
            web.setVisible(false);
        }else{
            web.setPrefHeight(400.0);
            web.setPrefWidth(1100.0);
            tableview.setPrefHeight(0.0);
            tableview.setPrefWidth(0.0);
            web.setVisible(true);
        }

    }
    //关闭应用
    public void close(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }

}
