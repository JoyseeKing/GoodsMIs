package tsc.model;

public class GoodsNum2 {
private int id;
private String goodsName;
private int goodsNum;
private float goodsPrice;
private int in_Num;
private int out_Num;
private  String manager;
private float totalPrice;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public int getGoodsNum() {
	return goodsNum;
}
public void setGoodsNum(int goodsNum) {
	this.goodsNum = goodsNum;
}
public float getGoodsPrice() {
	return goodsPrice;
}
public void setGoodsPrice(float goodsPrice) {
	this.goodsPrice = goodsPrice;
}
public int getIn_Num() {
	return in_Num;
}
public void setIn_Num(int in_Num) {
	this.in_Num = in_Num;
}
public int getOut_Num() {
	return out_Num;
}
public void setOut_Num(int out_Num) {
	this.out_Num = out_Num;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public float getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(float totalPrice) {
	this.totalPrice = totalPrice;
}
public GoodsNum2(int id, String goodsName, int goodsNum, float goodsPrice, int in_Num, int out_Num, String manager,
		float totalPrice) {
	super();
	this.id = id;
	this.goodsName = goodsName;
	this.goodsNum = goodsNum;
	this.goodsPrice = goodsPrice;
	this.in_Num = in_Num;
	this.out_Num = out_Num;
	this.manager = manager;
	this.totalPrice = totalPrice;
}


public GoodsNum2(String goodsName, int goodsNum, float goodsPrice, int in_Num, int out_Num, String manager,
		float totalPrice) {
	super();
	this.goodsName = goodsName;
	this.goodsNum = goodsNum;
	this.goodsPrice = goodsPrice;
	this.in_Num = in_Num;
	this.out_Num = out_Num;
	this.manager = manager;
	this.totalPrice = totalPrice;
}
public GoodsNum2() {
	super();
	// TODO Auto-generated constructor stub
}




}



