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

import java.io.IOException;
import java.net.URL;
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
    private AnchorPane main_bottom_root;

    private WebEngine webEngine;
    private BorderPane view_root;
    private boolean isKLine;
    private TranstationController transtationController;


    public void setTableViewOneClick(Commodity commodity){
        transtationController.setTableViewOneClick(commodity);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTabPane();
        init();
    }

    private void init() {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/main_transtation.fxml"));
        try {
           root =  loader.load();
            main_bottom_root.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        transtationController =  loader.getController();
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
                    transtationController.initData(newValue.getValue());
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
