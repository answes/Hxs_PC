package sample.util;

/**
 * 全部的静态数据都从这个类中获取
 */

public class AppDatas {
    public static final String TAB_TRANSTATION = "transtion";
   public static final String TAB_SEND = "send";
    public static final String TAB_AUTO = "auto";
    public static final String TAB_SETTLEMENT= "settlement";

    public static String[] getTreeViewRootName(String tab_name){
        switch (tab_name){
            case TAB_TRANSTATION:
                return new String[]{"交易","查询"};
            case TAB_SEND:
                return new String[]{"发行","查询"};
            case TAB_AUTO:
                return new String[]{"托管"};
            case TAB_SETTLEMENT:
                return  new String[]{"交收"};
        }
        return new String[1];
    }

    public static String[][] getTreeViewNodesName(String tab_name){

        switch (tab_name){
            case TAB_TRANSTATION:
                return new String[][]{{"买入","卖出","撤单","预埋单"},{"资金信息","委托查询","成交查询","持仓汇总","持仓明细","系统公告"}};
            case TAB_SEND:
                return new String[][]{{"申购","确认配售"},{"申购记录","已成交申购","配售查询"}};
            case TAB_AUTO:
                return new String[][]{{"托管申请","托管申请查询","支付挂牌费"}};
            case TAB_SETTLEMENT:
                return  new String[][]{{"提货申请","自提打印","撤销提货","提货查询"}};
        }
        return new String[1][1];
    }
}
