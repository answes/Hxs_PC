package sample.bean;

/**
 * Created by bigshark on 2017/7/17.
 */
public class ComeMsg {
    private int commNum;
    private String commName;
    private double vagPrice;
    private double nowPrice;
    private int haveNum;
    private double loan;//贷款
    private int canUseNumber;//可用数量
    private double chichangyingkui;//
    private double sclae;   //  盈亏比例
    private double maketValue;//市值

    public ComeMsg() {
    }

    public ComeMsg(int commNum, String commName, double vagPrice, double nowPrice, int haveNum, double loan, int canUseNumber, double chichangyingkui, double sclae, double maketValue) {
        this.commNum = commNum;
        this.commName = commName;
        this.vagPrice = vagPrice;
        this.nowPrice = nowPrice;
        this.haveNum = haveNum;
        this.loan = loan;
        this.canUseNumber = canUseNumber;
        this.chichangyingkui = chichangyingkui;
        this.sclae = sclae;
        this.maketValue = maketValue;
    }

    public int getCommNum() {
        return commNum;
    }

    public void setCommNum(int commNum) {
        this.commNum = commNum;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public double getVagPrice() {
        return vagPrice;
    }

    public void setVagPrice(double vagPrice) {
        this.vagPrice = vagPrice;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public int getHaveNum() {
        return haveNum;
    }

    public void setHaveNum(int haveNum) {
        this.haveNum = haveNum;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public int getCanUseNumber() {
        return canUseNumber;
    }

    public void setCanUseNumber(int canUseNumber) {
        this.canUseNumber = canUseNumber;
    }

    public double getChichangyingkui() {
        return chichangyingkui;
    }

    public void setChichangyingkui(double chichangyingkui) {
        this.chichangyingkui = chichangyingkui;
    }

    public double getSclae() {
        return sclae;
    }

    public void setSclae(double sclae) {
        this.sclae = sclae;
    }

    public double getMaketValue() {
        return maketValue;
    }

    public void setMaketValue(double maketValue) {
        this.maketValue = maketValue;
    }

    @Override
    public String toString() {
        return "ComeMsg{" +
                "commNum=" + commNum +
                ", commName='" + commName + '\'' +
                ", vagPrice=" + vagPrice +
                ", nowPrice=" + nowPrice +
                ", haveNum=" + haveNum +
                ", loan=" + loan +
                ", canUseNumber=" + canUseNumber +
                ", chichangyingkui=" + chichangyingkui +
                ", sclae=" + sclae +
                ", maketValue=" + maketValue +
                '}';
    }
}
