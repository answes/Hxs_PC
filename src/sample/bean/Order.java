package sample.bean;

import javafx.beans.property.*;

public class Order {
    private StringProperty orderNo;
    private StringProperty goodCode;
    private StringProperty goodName;
    private StringProperty inOrOut;
    private DoubleProperty money;
    private IntegerProperty num;
    private IntegerProperty noDeal;
    private IntegerProperty state;
    private StringProperty createTime;

    public Order() {
    }

    public Order(String orderNo, String goodCode, String goodName, String inOrOut, double money, int num, int noDeal, int state, String createTime) {
        this.orderNo = new SimpleStringProperty(orderNo);
        this.goodCode = new SimpleStringProperty(goodCode);
        this.goodName = new SimpleStringProperty(goodName);
        this.inOrOut = new SimpleStringProperty(inOrOut);
        this.money = new SimpleDoubleProperty(money);
        this.num = new SimpleIntegerProperty(num);
        this.noDeal = new SimpleIntegerProperty(noDeal);
        this.state = new SimpleIntegerProperty(state);
        this.createTime = new SimpleStringProperty(createTime);
    }

    public String getOrderNo() {
        return orderNo.get();
    }

    public StringProperty orderNoProperty() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo.set(orderNo);
    }

    public String getGoodCode() {
        return goodCode.get();
    }

    public StringProperty goodCodeProperty() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode.set(goodCode);
    }

    public String getGoodName() {
        return goodName.get();
    }

    public StringProperty goodNameProperty() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName.set(goodName);
    }

    public String getInOrOut() {
        return inOrOut.get();
    }

    public StringProperty inOrOutProperty() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut.set(inOrOut);
    }

    public double getMoney() {
        return money.get();
    }

    public DoubleProperty moneyProperty() {
        return money;
    }

    public void setMoney(double money) {
        this.money.set(money);
    }

    public int getNum() {
        return num.get();
    }

    public IntegerProperty numProperty() {
        return num;
    }

    public void setNum(int num) {
        this.num.set(num);
    }

    public int getNoDeal() {
        return noDeal.get();
    }

    public IntegerProperty noDealProperty() {
        return noDeal;
    }

    public void setNoDeal(int noDeal) {
        this.noDeal.set(noDeal);
    }

    public int getState() {
        return state.get();
    }

    public IntegerProperty stateProperty() {
        return state;
    }

    public void setState(int state) {
        this.state.set(state);
    }

    public String getCreateTime() {
        return createTime.get();
    }

    public StringProperty createTimeProperty() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime.set(createTime);
    }
}
