package hzyc.com.hw.model;

public class GoodOnshelfInfo {
	
	
	private String restockId;
	private String barcode;
	private String goodsName;
	private String category;
	private int amount;
	private int count;
	private String boughtPrice;
	private String soldPrice;
	private String picPath;
	private String infoId;

	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getRestockId() {
		return restockId;
	}
	public void setRestockId(String restockId) {
		this.restockId = restockId;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBoughtPrice() {
		return boughtPrice;
	}
	public void setBoughtPrice(String boughtPrice) {
		this.boughtPrice = boughtPrice;
	}
	public String getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(String soldPrice) {
		this.soldPrice = soldPrice;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public void print() {
		System.out.println ("GoodOnshelfInfo [restockId=" + restockId + ", barcode=" + barcode + ", goodsName=" + goodsName
				+ ", category=" + category + ", amount=" + amount + ", count=" + count + ", boughtPrice=" + boughtPrice
				+ ", soldPrice=" + soldPrice + ", picPath=" + picPath + "]");
	}
}
