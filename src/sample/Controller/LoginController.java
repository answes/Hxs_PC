package sample.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.util.Constant;
import sample.util.ControlledStage;
import sample.util.StageController;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements ControlledStage, Initializable {
    @FXML
    private PasswordField pf_password; //密码
    @FXML
    private ComboBox cb_transaction_type; //项目类型
    @FXML
    private javafx.scene.control.TextField tf_user_name; //用户名称
    @FXML
    private javafx.scene.control.TextField tf_code; //验证码
    @FXML
    private CheckBox cb_save_username; //保存验证码
    @FXML
    private javafx.scene.control.Label lb_image_code; //验证码图片
    @FXML
    private Pane loginTitle;
    @FXML
    private ProgressBar progress;  //  进度条

    private double xOffset = 0;
    private double yOffset = 0;
    private StageController myController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb_transaction_type.setItems(FXCollections.observableArrayList("仿真交易", "实物交易"));
        tf_user_name.setPromptText("用户名");
        pf_password.setPromptText("输入密码6-12位");
        tf_code.setPromptText("输入验证码");
        javafx.scene.image.Image image = new Image(this.getClass().getResource("../image/no.png").toExternalForm());
        lb_image_code.setGraphic(new ImageView(image));


        loginTitle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                event.consume();
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        loginTitle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                event.consume();
                myController.getStage(Constant.loginViewID).setX(event.getScreenX() - xOffset);
                //根据自己的需求，做不同的判断
                if (event.getScreenY() - yOffset < 0) {
                    myController.getStage(Constant.loginViewID).setY(0);
                } else {
                    myController.getStage(Constant.loginViewID).setY(event.getScreenY() - yOffset);
                }
            }
        });

    }


    //独立行情
    public void login1(ActionEvent event) {
    }

    //行情+交易
    public void login2(ActionEvent event) {
        myController.getStage(Constant.rootViewID).setMaximized(true);
        myController.getStage(Constant.rootViewID).setMinHeight(1000.0);
        myController.getStage(Constant.rootViewID).setMinWidth(1200.0);
        myController.setStage(Constant.rootViewID,Constant.loginViewID);
    }

    //进入官网
    public void toOfficialWEB(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("http://www.haixiangsuo.com/"));
        } catch (Exception e) {
            e.printStackTrace();
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
