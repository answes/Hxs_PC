package sample.Controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import sample.bean.ComeMsg;
import sample.bean.Commodity;
import sample.util.AppDatas;
import sample.util.Constant;
import sample.util.ControlledStage;
import sample.util.StageController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bigshark on 2017/7/17.
 */
public class RootController implements ControlledStage, Initializable {
    private StageController myController;

    @FXML
    private TableView<Commodity> tb_goods;
    @FXML
    private WebView web;//k线图
    @FXML
    private AnchorPane kView;


    @FXML
    private AnchorPane bottom_root;
    @FXML
    private BorderPane view_root;

    @FXML
    private AnchorPane bottom_details;

    private WebEngine webEngine;

    private boolean isKLine;

    private boolean isMinWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initData();
        onClick();
        web.setContextMenuEnabled(false);
        webEngine = web.getEngine();
    }

    private void initData() {
        initGoodTable();
        initTranstasionTable();
        initBottom();
    }

    private void initBottom() {
        AnchorPane loader = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/main_bottom.fxml"));
        try {
            loader = fxmlLoader.load();
            bottom_root.getChildren().add(loader);
            ((MainBottomController)fxmlLoader.getController()).initDate(webEngine,isKLine,view_root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化交易详情列表
     */
    private void initTranstasionTable() {
//        //设置数据源
//        final ObservableList<ComeMsg> datas = FXCollections.observableArrayList(new ComeMsg(8001,"木糖醇",23.0,25.0,11,300,100,500,0.02,5000)
//        ,new ComeMsg(8001,"木糖醇",23.0,25.0,11,300,100,500,0.02,5000)
//        ,new ComeMsg(8001,"木糖醇",23.0,25.0,11,300,100,500,0.02,5000));
//
//
//        TableColumn commNum = new TableColumn("商品代码");
//        commNum.setMinWidth(100);
//        commNum.setCellValueFactory(
//                new PropertyValueFactory<>("commNum"));
//
//        TableColumn commName = new TableColumn("商品名称");
//        commName.setMinWidth(100);
//        commName.setCellValueFactory(
//                new PropertyValueFactory<>("commName"));
//
//        TableColumn vagPrice = new TableColumn("平均价");
//        vagPrice.setMinWidth(100);
//        vagPrice.setCellValueFactory(
//                new PropertyValueFactory<>("vagPrice"));
//
//        TableColumn nowPrice = new TableColumn("最新价");
//        nowPrice.setMinWidth(100);
//        nowPrice.setCellValueFactory(
//                new PropertyValueFactory<>("nowPrice"));
//
//        TableColumn haveNum = new TableColumn("拥有量");
//        haveNum.setMinWidth(100);
//        haveNum.setCellValueFactory(
//                new PropertyValueFactory<>("haveNum"));
//
//        TableColumn loan = new TableColumn("贷款");
//        loan.setMinWidth(100);
//        loan.setCellValueFactory(
//                new PropertyValueFactory<>("loan"));
//
//        TableColumn canUseNumber = new TableColumn("可用数量");
//        canUseNumber.setMinWidth(100);
//        canUseNumber.setCellValueFactory(
//                new PropertyValueFactory<>("canUseNumber"));
//
//        TableColumn chichangyingkui = new TableColumn("持有亏损");
//        chichangyingkui.setMinWidth(100);
//        chichangyingkui.setCellValueFactory(
//                new PropertyValueFactory<>("chichangyingkui"));
//
//        TableColumn sclae = new TableColumn("盈亏比例");
//        sclae.setMinWidth(100);
//        sclae.setCellValueFactory(
//                new PropertyValueFactory<>("sclae"));
//
//        TableColumn maketValue = new TableColumn("市值");
//        maketValue.setMinWidth(100);
//        maketValue.setCellValueFactory(
//                new PropertyValueFactory<>("maketValue"));
//
//        tb_details.setItems(datas);
//        tb_details.getColumns().setAll( commNum, commName,vagPrice,nowPrice,haveNum,loan,canUseNumber,chichangyingkui,sclae,maketValue);
    }

    /**
     * 初始化商品列表
     */
    private void initGoodTable() {

        //设置数据源
        final ObservableList<Commodity> datas = FXCollections.observableArrayList(new Commodity(1, "80008", "人参糖", 12.0, 10.3, 30, 0.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(2, "80008", "芝麻糖", 12.0, 10.3, 20, 1.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(3, "80009", "百度糖", 22.0, 20.3, 30, 2.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(4, "80010", "不知糖", 32.0, 30.3, 40, 3.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(5, "80011", "砂糖糖", 42.0, 40.3, 50, 4.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
                , new Commodity(6, "80012", "人参糖", 52.0, 50.3, 60, 5.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00));

        //设置列表
        TableColumn number = new TableColumn("编号");
        number.setMinWidth(40);
        number.setCellValueFactory(
                new PropertyValueFactory<>("number"));

        TableColumn commNum = new TableColumn("商品代码");
        commNum.setMinWidth(80);
        commNum.setCellValueFactory(
                new PropertyValueFactory<>("commNum"));

        TableColumn commName = new TableColumn("商品名称");
        commName.setMinWidth(80);
        commName.setCellValueFactory(
                new PropertyValueFactory<>("commName"));

        TableColumn openPrice = new TableColumn("开盘价");
        openPrice.setMinWidth(120);
        openPrice.setCellValueFactory(
                new PropertyValueFactory<>("openPrice"));

        TableColumn newPrice = new TableColumn("最新价");
        newPrice.setMinWidth(80);
        newPrice.setCellValueFactory(
                new PropertyValueFactory<>("newPrice"));

        TableColumn count = new TableColumn("现量");
        count.setMinWidth(80);
        count.setCellValueFactory(
                new PropertyValueFactory<>("count"));

        TableColumn upDown = new TableColumn("涨跌");
        upDown.setMinWidth(80);
        upDown.setCellValueFactory(
                new PropertyValueFactory<>("upDown"));

        TableColumn extent = new TableColumn("幅度%");
        extent.setMinWidth(80);
        extent.setCellValueFactory(
                new PropertyValueFactory<>("extent"));

        TableColumn maxPrice = new TableColumn("最高价");
        maxPrice.setMinWidth(80);
        maxPrice.setCellValueFactory(
                new PropertyValueFactory<>("maxPrice"));

        TableColumn mixPrice = new TableColumn("最低价");
        mixPrice.setMinWidth(80);
        mixPrice.setCellValueFactory(
                new PropertyValueFactory<>("mixPrice"));

        TableColumn yestedayPrice = new TableColumn("昨收盘价");
        yestedayPrice.setMinWidth(80);
        yestedayPrice.setCellValueFactory(
                new PropertyValueFactory<>("yestedayPrice"));

        TableColumn comePrice = new TableColumn("买价");
        comePrice.setMinWidth(80);
        comePrice.setCellValueFactory(
                new PropertyValueFactory<>("comePrice"));

        TableColumn comeNumber = new TableColumn("买量");
        comeNumber.setMinWidth(80);
        comeNumber.setCellValueFactory(
                new PropertyValueFactory<>("comeNumber"));

        TableColumn outPrice = new TableColumn("卖价");
        outPrice.setMinWidth(80);
        outPrice.setCellValueFactory(
                new PropertyValueFactory<>("outPrice"));

        TableColumn outNumber = new TableColumn("卖量");
        outNumber.setMinWidth(80);
        outNumber.setCellValueFactory(
                new PropertyValueFactory<>("outNumber"));

        TableColumn overNumber = new TableColumn("成交量");
        overNumber.setMinWidth(80);
        overNumber.setCellValueFactory(
                new PropertyValueFactory<>("overNumber"));

        TableColumn overMoney = new TableColumn("成交金额");
        overMoney.setMinWidth(80);
        overMoney.setCellValueFactory(
                new PropertyValueFactory<>("overMoney"));

        TableColumn avgPrice = new TableColumn("均价");
        avgPrice.setMinWidth(80);
        avgPrice.setCellValueFactory(
                new PropertyValueFactory<>("avgPrice"));

        TableColumn stockNumber = new TableColumn("库存量");
        stockNumber.setMinWidth(80);
        stockNumber.setCellValueFactory(
                new PropertyValueFactory<>("stockNumber"));

        TableColumn numberScale = new TableColumn("量比%");
        numberScale.setMinWidth(80);
        numberScale.setCellValueFactory(
                new PropertyValueFactory<>("numberScale"));

        TableColumn trustScale = new TableColumn("委比%");
        trustScale.setMinWidth(80);
        trustScale.setCellValueFactory(
                new PropertyValueFactory<>("trustScale"));

        TableColumn exchangeScale = new TableColumn("换手率%");
        exchangeScale.setMinWidth(80);
        exchangeScale.setCellValueFactory(
                new PropertyValueFactory<>("exchangeScale"));
        tb_goods.setItems(datas);
        tb_goods.getColumns().setAll(number, commNum, commName, openPrice, newPrice,
                count, upDown, extent, maxPrice, mixPrice, yestedayPrice, comePrice, comeNumber, outPrice,
                outNumber, overNumber, overMoney, avgPrice, stockNumber, numberScale, trustScale, exchangeScale);
        tb_goods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //双击事件，进去图标详情
                if (event.getClickCount() == 2) {
                    kView.setVisible(true);
                    tb_goods.setVisible(false);
                    isKLine = true;
                    webEngine.load(getClass().getResource("../html/kLine.html").toExternalForm());
                }
            }
        });
    }

    private void onClick() {

    }



    public void toTranstion(ActionEvent e) {
        view_root.setBottom(bottom_root);
        if (isKLine) {
            //webEngine.load(getClass().getResource("../html/kLine.html").toExternalForm());
            webEngine.reload();
        }
    }


    /**
     * 分时
     *
     * @param event
     */
    public void fenshiKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine = true;
        webEngine.load(getClass().getResource("../html/trend.html").toExternalForm());
    }

    /**
     * 一分K线
     *
     * @param event
     */
    public void oneMinuteKLine(ActionEvent event) {

    }

    /**
     * 5分K线
     *
     * @param event
     */
    public void fiveMinuteKLine(ActionEvent event) {

    }

    /**
     * 十分K线
     *
     * @param event
     */
    public void tenMinuteKLine(ActionEvent event) {

    }

    /**
     * 十五分K线
     *
     * @param event
     */
    public void fifteenMinuteKLine(ActionEvent event) {

    }

    /**
     * 三十分K线
     *
     * @param event
     */
    public void thrityMinuteKLine(ActionEvent event) {

    }

    /**
     * 六十分K线
     *
     * @param event
     */
    public void sixtyMinuteKLine(ActionEvent event) {

    }

    /**
     * 一天K线
     *
     * @param event
     */
    public void dayKLine(ActionEvent event) {

    }

    /**
     * 一周K线
     *
     * @param event
     */
    public void weekKLine(ActionEvent event) {

    }

    /**
     * 一个月K线
     *
     * @param event
     */
    public void monthKLine(ActionEvent event) {

    }

    /**
     * 关闭应用
     *
     * @param event
     */
    public void closeWindow(ActionEvent event) {
        Platform.exit();
    }

    /**
     * 缩放窗口
     *
     * @param event
     */
    public void zoomWindow(ActionEvent event) {
        myController.getStage(Constant.rootViewID).setIconified(true);
        System.out.println("最小化");
    }

    /**
     * 最小化窗口
     *
     * @param event
     */
    public void scaleWindow(ActionEvent event) {
        if (isMinWindow) {
            myController.getStage(Constant.rootViewID).setMaximized(true);
        } else {
//            myController.getStage(Constant.rootViewID)
        }
        System.out.println("最大化");
    }


    @Override
    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }
}
