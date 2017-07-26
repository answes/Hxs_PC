package sample.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import sample.bean.Commodity;
import sample.util.AppDatas;
import sample.util.Constant;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainBottomController implements Initializable {

    @FXML
    private Label lb_bottom_title;
    @FXML
    private Label lb_transcation_title;
    @FXML
    private Tab tab_transtion;
    @FXML
    private Tab tab_send;
    @FXML
    private Tab tab_auto;
    @FXML
    private Tab tab_settlement;
    @FXML
    private AnchorPane bottom_details;

    private WebEngine webEngine;
    private BorderPane view_root;
    private boolean isKLine;
    private TranstationController transtationController;//买卖
    private DealQueryController dealQueryController;    //  成交查询
    private FundsMsgController fundsMsgController;  //  资金信息
    private HostedCotroller hostedCotroller;//托管
    private HostedQueryConteroller hostedQueryConteroller;//托管申请查询
    private PayListedController payListedController;//支付挂牌费用
    private PickUpController pickUpController;//提货申请
    private PlacingController placingController;//配售
    private PositionController positionController;//持仓
    private PrintOrderController printOrderController;//自提打印
//    private ProductCotroller productCotroller;//
    private AdvBuyController advBuyController;//预埋单
    private PurchaseController purchaseController;//申购
    private SystemMsgController systemMsgController;//系统公告

    private Map<String ,AnchorPane> rootLayouts = new HashMap<>();


    public void setTableViewOneClick(Commodity commodity){
        transtationController.setTableViewOneClick(commodity);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTabPane();
        init();
        hideController();
        showController(Constant.TRASTATION);
    }

    /**
     * 隐藏全部Controller
     */
    private void hideController() {
        for(Map.Entry<String, AnchorPane> entry : rootLayouts.entrySet()) {
             entry.getValue().setVisible(false);
        }
    }

    /**
     * 显示某个Controller
     * @param name
     */
    private void showController(String name){
        hideController();
        rootLayouts.get(name).setVisible(true);
    }

    private void init() {
        //成交查询
        AnchorPane dealQueryRoot = null;
        FXMLLoader dealQueryLoader = new FXMLLoader(getClass().getResource("../fxml/deal_query.fxml"));
        try {
            dealQueryRoot =  dealQueryLoader.load();
            bottom_details.getChildren().add(dealQueryRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dealQueryController =  dealQueryLoader.getController();
        dealQueryRoot.setId("dealQuery");
        rootLayouts.put(dealQueryRoot.getId(),dealQueryRoot);
        //买入 卖出
        AnchorPane tRoot = null;
        FXMLLoader tLoader = new FXMLLoader(getClass().getResource("../fxml/main_transtation.fxml"));
        try {
            tRoot =  tLoader.load();
            bottom_details.getChildren().add(tRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        transtationController =  tLoader.getController();
        tRoot.setId("trastation");
        rootLayouts.put(tRoot.getId(),tRoot);

        //资金信息
        AnchorPane fundsRoot = null;
        FXMLLoader fundsLoader = new FXMLLoader(getClass().getResource("../fxml/fundsmsg.fxml"));
        try {
            fundsRoot =  fundsLoader.load();
            bottom_details.getChildren().add(fundsRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fundsMsgController =  fundsLoader.getController();
        fundsRoot.setId("funds");
        rootLayouts.put(fundsRoot.getId(),fundsRoot);

        //  托管
        AnchorPane hostedRoot = null;
        FXMLLoader hostedLoader = new FXMLLoader(getClass().getResource("../fxml/hosted.fxml"));
        try {
            hostedRoot =  hostedLoader.load();
            bottom_details.getChildren().add(hostedRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hostedCotroller =  hostedLoader.getController();
        hostedRoot.setId("hosted");
        rootLayouts.put(hostedRoot.getId(),hostedRoot);
        //  托管申请查询
        AnchorPane hostedQueryRoot = null;
        FXMLLoader hostedQueryLoader = new FXMLLoader(getClass().getResource("../fxml/hosted_query.fxml"));
        try {
            hostedQueryRoot =  hostedQueryLoader.load();
            bottom_details.getChildren().add(hostedQueryRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hostedQueryConteroller =  hostedQueryLoader.getController();
        hostedQueryRoot.setId("hostedQuery");
        rootLayouts.put(hostedQueryRoot.getId(),hostedQueryRoot);

        //  支付挂牌费
        AnchorPane payListedRoot = null;
        FXMLLoader payListedLoader = new FXMLLoader(getClass().getResource("../fxml/pay_listed.fxml"));
        try {
            payListedRoot =  payListedLoader.load();
            bottom_details.getChildren().add(payListedRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        payListedController =  payListedLoader.getController();
        payListedRoot.setId("payListed");
        rootLayouts.put(payListedRoot.getId(),payListedRoot);

        // 体现申请
        AnchorPane pickUpdRoot = null;
        FXMLLoader pickUpLoader = new FXMLLoader(getClass().getResource("../fxml/pick_up.fxml"));
        try {
            pickUpdRoot =  pickUpLoader.load();
            bottom_details.getChildren().add(pickUpdRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pickUpController =  pickUpLoader.getController();
        pickUpdRoot.setId("pickUp");
        rootLayouts.put(pickUpdRoot.getId(),pickUpdRoot);


        //配售
        AnchorPane placingdRoot = null;
        FXMLLoader placingLoader = new FXMLLoader(getClass().getResource("../fxml/placing.fxml"));
        try {
            placingdRoot =  placingLoader.load();
            bottom_details.getChildren().add(placingdRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        placingController =  placingLoader.getController();
        placingdRoot.setId("placing");
        rootLayouts.put(placingdRoot.getId(),placingdRoot);


        //positionController
        AnchorPane positionRoot = null;
        FXMLLoader positionLoader = new FXMLLoader(getClass().getResource("../fxml/position.fxml"));
        try {
            positionRoot =  positionLoader.load();
            bottom_details.getChildren().add(positionRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        positionController =  positionLoader.getController();
        positionRoot.setId("position");
        rootLayouts.put(positionRoot.getId(),positionRoot);

        //printOrderController 自提打印
        AnchorPane printOrdernRoot = null;
        FXMLLoader printOrderLoader = new FXMLLoader(getClass().getResource("../fxml/print_order.fxml"));
        try {
            printOrdernRoot =  printOrderLoader.load();
            bottom_details.getChildren().add(printOrdernRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printOrderController =  printOrderLoader.getController();
        printOrdernRoot.setId("printOrder");
        rootLayouts.put(printOrdernRoot.getId(),printOrdernRoot);

//        //productCotroller
//        AnchorPane productRoot = null;
//        FXMLLoader productLoader = new FXMLLoader(getClass().getResource("../fxml/product.fxml"));
//        try {
//            productRoot =  productLoader.load();
//            bottom_details.getChildren().add(productRoot);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        productCotroller =  productLoader.getController();
//        productRoot.setId("product");
//        rootLayouts.put(productRoot.getId(),productRoot);

        //purchaseController 申购
        AnchorPane  purchaseRoot = null;
        FXMLLoader  purchaseLoader = new FXMLLoader(getClass().getResource("../fxml/purchase.fxml"));
        try {
            purchaseRoot =  purchaseLoader.load();
            bottom_details.getChildren().add(purchaseRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        purchaseController =  purchaseLoader.getController();
        purchaseRoot.setId("purchase");
        rootLayouts.put(purchaseRoot.getId(),purchaseRoot);

        //systemMsgController 系统公告
        AnchorPane  systemMsgRoot = null;
        FXMLLoader  systemMsgLoader = new FXMLLoader(getClass().getResource("../fxml/system_msg.fxml"));
        try {
            systemMsgRoot =  systemMsgLoader.load();
            bottom_details.getChildren().add(systemMsgRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        systemMsgController =  systemMsgLoader.getController();
        systemMsgRoot.setId("systemMsg");
        rootLayouts.put(systemMsgRoot.getId(),systemMsgRoot);

        //advBuyController 预埋单
        AnchorPane  advBuyRoot = null;
        FXMLLoader  advBuyLoader = new FXMLLoader(getClass().getResource("../fxml/adv_buy.fxml"));
        try {
            advBuyRoot =  advBuyLoader.load();
            bottom_details.getChildren().add(advBuyRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        advBuyController =  advBuyLoader.getController();
        advBuyRoot.setId("advBuy");
        rootLayouts.put(advBuyRoot.getId(),advBuyRoot);
    }

    public void initDate(WebEngine webEngine,boolean isKLine,BorderPane view_root){
        this.webEngine = webEngine;
        this.isKLine = isKLine;
        this.view_root = view_root;
    }

    /**
     * 初始化选项卡
     */
    private void initTabPane() {
        tab_transtion.setContent(initTreeView(AppDatas.getTreeViewRootName(AppDatas.TAB_TRANSTATION), AppDatas.getTreeViewNodesName(AppDatas.TAB_TRANSTATION)));
        tab_send.setContent(initTreeView(AppDatas.getTreeViewRootName(AppDatas.TAB_SEND), AppDatas.getTreeViewNodesName(AppDatas.TAB_SEND)));
        tab_auto.setContent(initTreeView(AppDatas.getTreeViewRootName(AppDatas.TAB_AUTO), AppDatas.getTreeViewNodesName(AppDatas.TAB_AUTO)));
        tab_settlement.setContent(initTreeView(AppDatas.getTreeViewRootName(AppDatas.TAB_SETTLEMENT), AppDatas.getTreeViewNodesName(AppDatas.TAB_SETTLEMENT)));
    }

    /**
     * 初始化树形控件
     */
    private TreeView initTreeView(String[] roots, String[][] nodes) {
        TreeView<String> treeView = new TreeView<>();
        TreeItem<String> root = new TreeItem<>();
        root.setExpanded(true);
        int i = 0;
        for (String s : roots) {
            TreeItem<String> root1 = new TreeItem<>(s);
            root1.setExpanded(true);
            for (String ns : nodes[i]) {
                root1.getChildren().add(new TreeItem<>(ns));
            }
            i++;
            root.getChildren().add(root1);
        }
        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                if(!newValue.isExpanded()){
                    switch (newValue.getValue()){
                        case "买入":
                            showController(Constant.TRASTATION);
                            transtationController.initData(1,newValue.getValue());
                            break;
                        case "卖出":
                            showController(Constant.TRASTATION);
                            transtationController.initData(2,newValue.getValue());
                            break;
                        case "撤单":
                            showController(Constant.PRINTORDER);
                            printOrderController.init();
                            break;
                        case "预埋单":
                            showController(Constant.ADVBUY);
                            advBuyController.init();
                            break;
                        case "资金信息":
                            showController(Constant.FUNDS);
                            fundsMsgController.init();
                            break;
                        case "委托查询":
                            showController(Constant.DEALQUERY);
                            dealQueryController.init(0);
                            break;
                        case "成交查询":
                            showController(Constant.DEALQUERY);
                            dealQueryController.init(1);
                            break;
                        case "持仓汇总":
                            showController(Constant.POSITION);
                            positionController.init(1);
                            break;
                        case "持仓明细":
                            showController(Constant.POSITION);
                            positionController.init(2);
                            break;
                        case "系统公告":
                            showController(Constant.SYSTEMMSG);
                            systemMsgController.init();
                            break;
                        case "申购":
                            showController(Constant.PURCHASE);
                            purchaseController.init();
                            break;
                        case "确认配售":
                            showController(Constant.PLACING);
                            placingController.init();
                            break;
                        case "申购记录":
                            showController(Constant.DEALQUERY);
                            dealQueryController.init(3);
                            break;
                        case "已成交申购":
                            showController(Constant.POSITION);
                            positionController.init(0);
                            break;
                        case "配售查询":
                            showController(Constant.DEALQUERY);
                            dealQueryController.init(3);
                            break;
                        case "托管申请":
                            showController(Constant.HOSTED);
                            hostedCotroller.init();
                            break;
                        case "托管申请查询":
                            showController(Constant.HOSTEDQUERY);
                            hostedQueryConteroller.init();
                            break;
                        case "支付挂牌费":
                            showController(Constant.PAYLISTED);
                            payListedController.init();
                            break;
                        case "提货申请":
                            showController(Constant.PICKUP);
                            pickUpController.init();
                            break;
                        case "自提打印":
                            showController(Constant.PRINTORDER);
                            printOrderController.init();
                            break;
                        case "撤销提货":
                            break;
                        case "提货查询":
                            break;
                        default:
                            transtationController.initData(1,newValue.getValue());
                            break;
                    }
                    lb_bottom_title.setText(newValue.getValue());
                }
            }
        });
        treeView.setShowRoot(false);
        treeView.setEditable(false);
        treeView.setRoot(root);
        return treeView;
    }

    /**
     * 买入
     *
     * @param event
     */
    public void buyOnClick(ActionEvent event) {
        lb_bottom_title.setText("买入");
    }

    /**
     * 卖出
     *
     * @param event
     */
    public void sellOnClick(ActionEvent event) {
        lb_bottom_title.setText("卖出");
    }

    /**
     * 撤单
     *
     * @param event
     */
    public void cancelOnClick(ActionEvent event) {
        lb_bottom_title.setText("撤单");
    }

    /**
     * 成交
     *
     * @param event
     */
    public void dealOnClick(ActionEvent event) {
        lb_bottom_title.setText("成交查询");
    }

    /**
     * 持仓
     *
     * @param event
     */
    public void haveOnClick(ActionEvent event) {
        lb_bottom_title.setText("持仓汇总");
    }

    /**
     * 刷新
     *
     * @param event
     */
    public void refreshOnClick(ActionEvent event) {
        System.out.println("刷新");
    }

    /**
     * 最小化
     *
     * @param event
     */
    public void mixOnClick(ActionEvent event) {
        view_root.setBottom(null);
        if (isKLine) {
            //webEngine.load(getClass().getResource("../html/kLine.html").toExternalForm());
            webEngine.reload();
        }
        System.out.println("最小化");
    }

    /**
     * 上锁
     *
     * @param event
     */
    public void lockOnClick(ActionEvent event) {
        System.out.println("上锁");
    }
}
