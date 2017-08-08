package sample.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.popupwindow.ComplaintsDialog;
import sample.popupwindow.OutMoneyDialog;
import sample.popupwindow.SignedDialog;
import sample.popupwindow.SystemSetDialog;
import sample.bean.Commodity;
import sample.util.Constant;
import sample.util.ControlledStage;
import sample.util.StageController;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private AnchorPane goods_root;
    @FXML
    private BorderPane view_root;
    @FXML
    private HBox good_type;
    @FXML
    private AnchorPane bottom_details;
    /**
     * tableview Column
     */
    @FXML
    private TableColumn<Commodity, String> number;
    @FXML
    private TableColumn<Commodity, String> commNum;
    @FXML
    private TableColumn<Commodity, String> commName;
    @FXML
    private TableColumn<Commodity, String> openPrice;
    @FXML
    private TableColumn<Commodity, String> newPrice;
    @FXML
    private TableColumn<Commodity, String> count;
    @FXML
    private TableColumn<Commodity, String> upDown;
    @FXML
    private TableColumn<Commodity, String> extent;
    @FXML
    private TableColumn<Commodity, String> maxPrice;
    @FXML
    private TableColumn<Commodity, String> mixPrice;
    @FXML
    private TableColumn<Commodity, String> yestedayPrice;
    @FXML
    private TableColumn<Commodity, String> comePrice;
    @FXML
    private TableColumn<Commodity, String> comeNumber;
    @FXML
    private TableColumn<Commodity, String> outPrice;
    @FXML
    private TableColumn<Commodity, String> outNumber;
    @FXML
    private TableColumn<Commodity, String> overNumber;
    @FXML
    private TableColumn<Commodity, String> overMoney;
    @FXML
    private TableColumn<Commodity, String> avgPrice;
    @FXML
    private TableColumn<Commodity, String> stockNumber;
    @FXML
    private TableColumn<Commodity, String> numberScale;
    @FXML
    private TableColumn<Commodity, String> trustScale;
    @FXML
    private TableColumn<Commodity, String> exchangeScale;

    public static WebEngine webEngine;
    @FXML
    private boolean isKLine;
    @FXML
    private boolean isMinWindow;
    @FXML
    private MainBottomController mainBottomController;

    private final ObservableList<Commodity> datas = FXCollections.observableArrayList(new Commodity(1, "80008", "人参糖", 12.0, 10.3, 30, 0.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
            , new Commodity(2, "80008", "芝麻糖", 12.0, 10.3, 20, 1.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
            , new Commodity(3, "80009", "百度糖", 22.0, 20.3, 30, 2.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
            , new Commodity(4, "80010", "不知糖", 32.0, 30.3, 40, 3.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
            , new Commodity(5, "80011", "砂糖糖", 42.0, 40.3, 50, 4.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00)
            , new Commodity(6, "80012", "人参糖", 52.0, 50.3, 60, 5.12, 0.03, 35.0, 9.5, 20.3, 25.5, 56, 25.6, 33, 80, 23.1, 22.3, 10000, 0.00, 0.00, 0.00));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initData();
        web.setContextMenuEnabled(false);
        webEngine = web.getEngine();
    }
    @FXML
    private void initData() {
        initGoodTable();
        initImage();
        initTranstasionTable();
        initBottom();
        initGoodBottom();
    }

    @FXML
    private void initGoodBottom() {
        ObservableList<Button> buttons = FXCollections.observableArrayList();
        for (int i = 0; i < 5; i++) {
            Button button = new Button("海香所" + i);
            button.setStyle(" -fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                    "    -fx-background-radius: 30;\n" +
                    "    -fx-background-insets: 0;\n" +
                    "    -fx-text-fill: white;");
            good_type.getChildren().add(button);
            buttons.add(button);
            button.setOnAction(event -> {
                buttons.forEach(b ->
                        b.setStyle(" -fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                                "    -fx-background-radius: 30;\n" +
                                "    -fx-background-insets: 0;\n" +
                                "    -fx-text-fill: white;")
                );
                button.setStyle("-fx-background-color: linear-gradient(#ffbc0a, #be6505);"
                        + "    -fx-background-radius: 30;\n" +
                        "    -fx-background-insets: 0;\n" +
                        "    -fx-text-fill: white;");
                if(datas.isEmpty()){
                    return;
                }
                datas.remove(1);
            });
        }
    }

    /**
     * 初始化图标控件
     */
    private void initImage() {
        Tooltip goodstip = new Tooltip("商品列表");
        quotesBt.setImage(new Image(getClass().getResource("../image/list.png").toExternalForm()));
        Tooltip.install(quotesBt, goodstip);

        Tooltip charttip = new Tooltip("图表分析");
        chartAnalysis.setImage(new Image(getClass().getResource("../image/fenxi.png").toExternalForm()));
        Tooltip.install(chartAnalysis, charttip);

        Tooltip filetip = new Tooltip("文件");
        productInformation.setImage(new Image(getClass().getResource("../image/file.png").toExternalForm()));
        Tooltip.install(productInformation, filetip);

        Tooltip detailtip = new Tooltip("商品详情");
        dealDetails.setImage(new Image(getClass().getResource("../image/details.png").toExternalForm()));
        Tooltip.install(dealDetails, detailtip);

        Tooltip settip = new Tooltip("设置");
        systemSet.setImage(new Image(getClass().getResource("../image/seting.png").toExternalForm()));
        Tooltip.install(systemSet, settip);
    }

    private void initBottom() {
        AnchorPane loader = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/main_bottom.fxml"));
        try {
            loader = fxmlLoader.load();
            //这个是我把获取MainBottomController添加到这个Controller的底下布局，你不用管
            bottom_root.getChildren().add(loader);
            //获取MainBottomController
            mainBottomController = fxmlLoader.getController();
            //执行获取MainBottomController更新的方法,以后tableview 点击的时候就可以调用这个方法来更新第二个Controller的数据了
            mainBottomController.initDate(webEngine, isKLine, view_root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        web.setOnMouseDragEntered(event -> System.out.println("不知道这个是什么" + event.getEventType().getName()));
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
    @FXML
    private void initGoodTable() {
        tb_goods.setItems(datas);
        number.setCellValueFactory(data -> data.getValue().numberProperty().asString());
        commNum.setCellValueFactory(data -> data.getValue().commNumProperty());
        commName.setCellValueFactory(data -> data.getValue().commNameProperty());
        openPrice.setCellValueFactory(data -> data.getValue().openPriceProperty().asString());
        newPrice.setCellValueFactory(data -> data.getValue().newPriceProperty().asString());
        count.setCellValueFactory(data -> data.getValue().countProperty().asString());
        upDown.setCellValueFactory(data -> data.getValue().upDownProperty().asString());
        extent.setCellValueFactory(data -> data.getValue().extentProperty().asString());
        maxPrice.setCellValueFactory(data -> data.getValue().maxPriceProperty().asString());
        mixPrice.setCellValueFactory(data -> data.getValue().mixPriceProperty().asString());
        yestedayPrice.setCellValueFactory(data -> data.getValue().yestedayPriceProperty().asString());
        comePrice.setCellValueFactory(data -> data.getValue().comePriceProperty().asString());
        comeNumber.setCellValueFactory(data -> data.getValue().comePriceProperty().asString());
        outPrice.setCellValueFactory(data -> data.getValue().outPriceProperty().asString());
        outNumber.setCellValueFactory(data -> data.getValue().outNumberProperty().asString());
        overNumber.setCellValueFactory(data -> data.getValue().overNumberProperty().asString());
        overMoney.setCellValueFactory(data -> data.getValue().overMoneyProperty().asString());
        avgPrice.setCellValueFactory(data -> data.getValue().avgPriceProperty().asString());
        stockNumber.setCellValueFactory(data -> data.getValue().stockNumberProperty().asString());
        numberScale.setCellValueFactory(data -> data.getValue().numberScaleProperty().asString());
        trustScale.setCellValueFactory(data -> data.getValue().trustScaleProperty().asString());
        exchangeScale.setCellValueFactory(data -> data.getValue().exchangeScaleProperty().asString());

        tb_goods.setRowFactory(tv -> {
            TableRow<Commodity> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Commodity commodity = row.getItem();
                    if (event.getClickCount() == 2) {
                        setRowOnTwoClick(commodity);
                    } else if (event.getClickCount() == 1) {
                        setRowOnOneClick(commodity);
                    }

                }
            });
            return row;
        });

    }


    /**
     * 单击设置数据到买入，卖出中
     *
     * @param commodity
     */
    private void setRowOnOneClick(Commodity commodity) {
        mainBottomController.setTableViewOneClick(commodity);
    }

    /**
     * 双击进入分时图
     *
     * @param commodity
     */
    private void setRowOnTwoClick(Commodity commodity) {
        kView.setVisible(true);
        goods_root.setVisible(false);
        mainBottomController.setIsKLine(true);
        isKLine = true;
        webEngine.load(getClass().getResource("../html/fenshi.html").toExternalForm());
    }


    /**
     * 进入交易
     *
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
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
        goods_root.setVisible(false);
        isKLine = true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/highstockTest.html").toExternalForm());
    }

    /**
     * 列表
     *
     * @param event
     */
    public void homeClick(MouseEvent event) {
        kView.setVisible(false);
        isKLine = false;
        goods_root.setVisible(true);
        mainBottomController.setIsKLine(isKLine);
    }

    /**
     * K线查看
     *
     * @param event
     */
    public void kLineClick(MouseEvent event) {
        goods_root.setVisible(false);
        kView.setVisible(true);
        isKLine = true;
        mainBottomController.setIsKLine(isKLine);
        webEngine.load(getClass().getResource("../html/test.html").toExternalForm());
    }

    /**
     * 商品详情
     *
     * @param event
     */
    public void productInformation(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/product.fxml"));
        try {
            Pane tempPane = loader.load();
            Scene scene = new Scene(tempPane, 900, 700);
            Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setScene(scene);
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 设置
     *
     * @param event
     */
    public void setIng(MouseEvent event) {
        new SystemSetDialog();
    }

    /**
     * 系统设置
     *
     * @param event
     */
    @FXML
    private void systemSet(ActionEvent event) {
        new SystemSetDialog();
    }

    /**
     * @param event
     */
    public void dealDetails(MouseEvent event) {
    }

    /**
     * 历史查询
     *
     * @param event
     */
    @FXML
    private void historyQurey(ActionEvent event) {

    }

    /**
     * 申诉/投诉
     *
     * @param e
     */
    @FXML
    private void complaints(ActionEvent e) {
        new ComplaintsDialog();
    }

    /**
     * 地址管理
     *
     * @param e
     */
    @FXML
    private void addressManege(ActionEvent e) {

    }

    /**
     * 关于
     *
     * @param event
     */
    @FXML
    private void aboutMe(ActionEvent event) {

    }

    /**
     * 签约申请
     *
     * @param event
     */
    @FXML
    private void signed(ActionEvent event) {
        new SignedDialog(Constant.SIGNED);
    }

    /**
     * 解约申请
     *
     * @param event
     */
    @FXML
    private void termination(ActionEvent event) {
        new SignedDialog(Constant.TERMINATION);
    }

    /**
     * 出金
     *
     * @param event
     */
    @FXML
    private void outMoney(ActionEvent event) {
        new OutMoneyDialog();
    }

    /**
     * 客户报表
     *
     * @param event
     */
    @FXML
    private void clientReport(ActionEvent event) {

    }

    /**
     * 计算器
     *
     * @param event
     */
    @FXML
    private void calculator(ActionEvent event) {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("calc");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * 刷新
     *
     * @param e
     */
    @FXML
    private void refresh(ActionEvent e) {

    }

    /**
     * 恢复默认布局
     *
     * @param event
     */
    @FXML
    private void restore(ActionEvent event) {

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
