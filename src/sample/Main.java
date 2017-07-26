package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.greenrobot.eventbus.EventBus;
import sample.util.Constant;
import sample.util.StageController;

public class Main extends Application {
    private StageController stageController;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stageController = new StageController();
        //将主舞台交给控制器处理
        stageController.setPrimaryStage("primaryStage", primaryStage);
        //注册eventBus
        //加载两个舞台，每个界面一个舞台
        stageController.loadStage(Constant.loginViewID, Constant.loginViewRes, StageStyle.UNDECORATED);
        stageController.loadStage(Constant.rootViewID, Constant.rootViewRes,StageStyle.UNDECORATED);
        //显示MainView舞台
        stageController.setStage(Constant.loginViewID);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
