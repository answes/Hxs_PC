package sample.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * 预埋单实体类
 */

public class AdvBuy {
    private StringProperty number;
    private StringProperty goodNum;
    private StringProperty goodName;
    private StringProperty business;
    private StringProperty price;
    private StringProperty num;
    private StringProperty date;

    public AdvBuy(String number, String goodNum, String goodName, String business, String price, String num, String date) {
        this.number =new SimpleStringProperty( number);
        this.goodNum = new SimpleStringProperty( goodNum);
        this.goodName = new SimpleStringProperty( goodName);
        this.business = new SimpleStringProperty( business);
        this.price = new SimpleStringProperty( price);
        this.num = new SimpleStringProperty( num);
        this.date = new SimpleStringProperty( date);
    }

    public String getNumber() {
        return number.get();
    }

    public StringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
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

    public String getBusiness() {
        return business.get();
    }

    public StringProperty businessProperty() {
        return business;
    }

    public void setBusiness(String business) {
        this.business.set(business);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getNum() {
        return num.get();
    }

    public StringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        return "AdvBuy{" +
                "number=" + number +
                ", goodNum=" + goodNum +
                ", goodName=" + goodName +
                ", business=" + business +
                ", price=" + price +
                ", num=" + num +
                ", date=" + date +
                '}';
    }
}
