package sample.Controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.bean.Commodity;
import sample.util.Constant;
import sample.util.ControlledStage;
import sample.util.StageController;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private ImageView quotesBt;
    @FXML
    private ImageView chartAnalysis;
    @FXML
    private ImageView productInformation;
    @FXML
    private ImageView dealDetails;
    @FXML
    private ImageView systemSet;
    @FXML
    private AnchorPane bottom_root;
    @FXML
    private BorderPane view_root;

    @FXML
    private AnchorPane bottom_details;

    public static WebEngine webEngine;

    private boolean isKLine ;

    private boolean isMinWindow;
    private MainBottomController mainBottomController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initData();
        onClick();
        web.setContextMenuEnabled(false);
        webEngine = web.getEngine();
    }

    private void initData() {
        initGoodTable();
        initImage();
        initTranstasionTable();
        initBottom();
    }

    /**
     * 初始化图标控件
     */
    private void initImage() {
        quotesBt.setImage(new Image(getClass().getResource("../image/list.png").toExternalForm()));
        chartAnalysis.setImage(new Image(getClass().getResource("../image/fenxi.png").toExternalForm()));
        productInformation.setImage(new Image(getClass().getResource("../image/file.png").toExternalForm()));
        dealDetails.setImage(new Image(getClass().getResource("../image/details.png").toExternalForm()));
        systemSet.setImage(new Image(getClass().getResource("../image/seting.png").toExternalForm()));
    }

    private void initBottom() {
        AnchorPane loader = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/main_bottom.fxml"));
        try {
            loader = fxmlLoader.load();
            //这个是我把获取MainBottomController添加到这个Controller的底下布局，你不用管
            bottom_root.getChildren().add(loader);
            //获取MainBottomController
            mainBottomController =   fxmlLoader.getController();
            //执行获取MainBottomController更新的方法,以后tableview 点击的时候就可以调用这个方法来更新第二个Controller的数据了
            mainBottomController.initDate(webEngine,isKLine,view_root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        web.setOnMouseDragEntered(event -> System.out.println("不知道这个是什么"+event.getEventType().getName()));
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
        tb_goods.setRowFactory( tv -> {
            TableRow<Commodity> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(! row.isEmpty() && event.getButton() == MouseButton.PRIMARY ){
                    Commodity commodity = row.getItem();
                    if(event.getClickCount() == 2){
                        setRowOnTwoClick(commodity);
                    }else if(event.getClickCount() == 1){
                        setRowOnOneClick(commodity);
                    }

                }
            });
            return  row;
        });

    }


    /**
     * 单击设置数据到买入，卖出中
     * @param commodity
     */
    @FXML
    private void setRowOnOneClick(Commodity commodity) {
        mainBottomController.setTableViewOneClick(commodity);
    }

    /**
     * 双击进入分时图
     * @param commodity
     */
    @FXML
    private void setRowOnTwoClick(Commodity commodity) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        mainBottomController.setIsKLine(true);
        webEngine.load(getClass().getResource("../html/fenshi.html").toExternalForm());
    }

    private void onClick() {

    }


    /**
     *进入交易
     * @param e
     */
    public void toTranstion(ActionEvent e) {
        view_root.setBottom(bottom_root);
        if (isKLine) {
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
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/fenshi.html").toExternalForm());
    }

    /**
     * 一分K线
     *
     * @param event
     */
    public void oneMinuteKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 5分K线
     *
     * @param event
     */
    public void fiveMinuteKLine(ActionEvent event) {

        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 十分K线
     *
     * @param event
     */
    public void tenMinuteKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 十五分K线
     *
     * @param event
     */
    public void fifteenMinuteKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 三十分K线
     *
     * @param event
     */
    public void thrityMinuteKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }


    /**
     * 六十分K线
     *
     * @param event
     */
    public void sixtyMinuteKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 一天K线
     *
     * @param event
     */
    public void dayKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 一周K线
     *
     * @param event
     */
    public void weekKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 一个月K线
     *
     * @param event
     */
    public void monthKLine(ActionEvent event) {
        kView.setVisible(true);
        tb_goods.setVisible(false);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 列表
     * @param event
     */
    public void homeClick(MouseEvent event){
        kView.setVisible(false);
        isKLine=false;
        tb_goods.setVisible(true);
        mainBottomController.setIsKLine(isKLine);
    }

    /**
     * K线查看
     * @param event
     */
    public void kLineClick(MouseEvent event){
        tb_goods.setVisible(false);
        kView.setVisible(true);
        isKLine=true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/test.html").toExternalForm());
    }

    /**
     * 商品详情
     * @param event
     */
    public void productInformation(MouseEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/product.fxml"));
        try {
            Pane tempPane = loader.load();
            Scene scene = new Scene(tempPane,900,700); Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setScene(scene);
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 设置
     * @param event
     */
    public void setIng (MouseEvent event){

        List<String> choices = new ArrayList<>();
        choices.add("清空");
        choices.add("不清空");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("不清空", choices);
        dialog.setTitle("系统设置");
        dialog.setContentText("委托后界面设置:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your choice: " + result.get());
        }

        result.ifPresent(letter -> System.out.println("Your choice: " + letter));

    }

    /**
     *
     * @param event
     */
    public  void dealDetails(MouseEvent event){
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
