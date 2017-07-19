package sample.bean;

/**
 * 商品
 * Created by bigshark on 2017/7/11.
 */
public class Commodity {

    private int number;
    private String commNum;
    private String commName;
    private double openPrice;
    private double newPrice;
    private int count;
    private double upDown;
    private double extent;  //  幅度
    private double maxPrice;
    private double mixPrice;
    private double yestedayPrice;
    private double comePrice;
    private int comeNumber;
    private double outPrice;
    private int outNumber;
    private int overNumber;
    private double overMoney;
    private double avgPrice;
    private int stockNumber;
    private double numberScale;
    private double trustScale;
    private double exchangeScale;

    public Commodity() {

    }

    public Commodity(int number, String commNum, String commName, double openPrice, double newPrice, int count, double upDown, double extent, double maxPrice, double mixPrice, double yestedayPrice, double comePrice, int comeNumber, double outPrice, int outNumber, int overNumber, double overMoney, double avgPrice, int stockNumber, double numberScale, double trustScale, double exchangeScale) {
        this.number = number;
        this.commNum = commNum;
        this.commName = commName;
        this.openPrice = openPrice;
        this.newPrice = newPrice;
        this.count = count;
        this.upDown = upDown;
        this.extent = extent;
        this.maxPrice = maxPrice;
        this.mixPrice = mixPrice;
        this.yestedayPrice = yestedayPrice;
        this.comePrice = comePrice;
        this.comeNumber = comeNumber;
        this.outPrice = outPrice;
        this.outNumber = outNumber;
        this.overNumber = overNumber;
        this.overMoney = overMoney;
        this.avgPrice = avgPrice;
        this.stockNumber = stockNumber;
        this.numberScale = numberScale;
        this.trustScale = trustScale;
        this.exchangeScale = exchangeScale;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUpDown() {
        return upDown;
    }

    public void setUpDown(double upDown) {
        this.upDown = upDown;
    }

    public double getExtent() {
        return extent;
    }

    public void setExtent(double extent) {
        this.extent = extent;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMixPrice() {
        return mixPrice;
    }

    public void setMixPrice(double mixPrice) {
        this.mixPrice = mixPrice;
    }

    public double getYestedayPrice() {
        return yestedayPrice;
    }

    public void setYestedayPrice(double yestedayPrice) {
        this.yestedayPrice = yestedayPrice;
    }

    public double getComePrice() {
        return comePrice;
    }

    public void setComePrice(double comePrice) {
        this.comePrice = comePrice;
    }

    public int getComeNumber() {
        return comeNumber;
    }

    public void setComeNumber(int comeNumber) {
        this.comeNumber = comeNumber;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public int getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(int outNumber) {
        this.outNumber = outNumber;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public void setOverNumber(int overNumber) {
        this.overNumber = overNumber;
    }

    public double getOverMoney() {
        return overMoney;
    }

    public void setOverMoney(double overMoney) {
        this.overMoney = overMoney;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public double getNumberScale() {
        return numberScale;
    }

    public void setNumberScale(double numberScale) {
        this.numberScale = numberScale;
    }

    public double getTrustScale() {
        return trustScale;
    }

    public void setTrustScale(double trustScale) {
        this.trustScale = trustScale;
    }

    public double getExchangeScale() {
        return exchangeScale;
    }

    public void setExchangeScale(double exchangeScale) {
        this.exchangeScale = exchangeScale;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "number=" + number +
                ", commNum='" + commNum + '\'' +
                ", commName='" + commName + '\'' +
                ", openPrice=" + openPrice +
                ", newPrice=" + newPrice +
                ", count=" + count +
                ", upDown='" + upDown + '\'' +
                ", extent='" + extent + '\'' +
                ", maxPrice=" + maxPrice +
                ", mixPrice=" + mixPrice +
                ", yestedayPrice=" + yestedayPrice +
                ", comePrice=" + comePrice +
                ", comeNumber=" + comeNumber +
                ", outPrice=" + outPrice +
                ", outNumber=" + outNumber +
                ", overNumber=" + overNumber +
                ", overMoney=" + overMoney +
                ", avgPrice=" + avgPrice +
                ", stockNumber=" + stockNumber +
                ", numberScale=" + numberScale +
                ", trustScale=" + trustScale +
                ", exchangeScale=" + exchangeScale +
                '}';
    }
}
