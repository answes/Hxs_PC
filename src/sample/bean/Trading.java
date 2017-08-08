package sample.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 买卖订单实体
 */
public class Trading {
    private StringProperty goodNum;
    private StringProperty goodName;
    private StringProperty avgPrice;
    private StringProperty nowPrice;
    private StringProperty count;
    private StringProperty loan;
    private StringProperty useNum;
    private StringProperty postionWin;
    private StringProperty winScale;
    private StringProperty marketValue;

    public Trading() {
    }

    public Trading(String goodNum, String goodName, String avgPrice, String nowPrice, String count, String loan, String useNum, String postionWin, String winScale, String marketValue) {
        this.goodNum =new SimpleStringProperty( goodNum);
        this.goodName =new SimpleStringProperty( goodName);
        this.avgPrice = new SimpleStringProperty(avgPrice);
        this.nowPrice =new SimpleStringProperty( nowPrice);
        this.count = new SimpleStringProperty(count);
        this.loan = new SimpleStringProperty(loan);
        this.useNum = new SimpleStringProperty(useNum);
        this.postionWin = new SimpleStringProperty(postionWin);
        this.winScale = new SimpleStringProperty(winScale);
        this.marketValue =new SimpleStringProperty( marketValue);
    }

    public String getGoodNum() {
        return goodNum.get();
    }

    public StringProperty goodNumProperty() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum.set(goodNum);
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

    public String getAvgPrice() {
        return avgPrice.get();
    }

    public StringProperty avgPriceProperty() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice.set(avgPrice);
    }

    public String getNowPrice() {
        return nowPrice.get();
    }

    public StringProperty nowPriceProperty() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice.set(nowPrice);
    }

    public String getCount() {
        return count.get();
    }

    public StringProperty countProperty() {
        return count;
    }

    public void setCount(String count) {
        this.count.set(count);
    }

    public String getLoan() {
        return loan.get();
    }

    public StringProperty loanProperty() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan.set(loan);
    }

    public String getUseNum() {
        return useNum.get();
    }

    public StringProperty useNumProperty() {
        return useNum;
    }

    public void setUseNum(String useNum) {
        this.useNum.set(useNum);
    }

    public String getPostionWin() {
        return postionWin.get();
    }

    public StringProperty postionWinProperty() {
        return postionWin;
    }

    public void setPostionWin(String postionWin) {
        this.postionWin.set(postionWin);
    }

    public String getWinScale() {
        return winScale.get();
    }

    public StringProperty winScaleProperty() {
        return winScale;
    }

    public void setWinScale(String winScale) {
        this.winScale.set(winScale);
    }

    public String getMarketValue() {
        return marketValue.get();
    }

    public StringProperty marketValueProperty() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue.set(marketValue);
    }
}
