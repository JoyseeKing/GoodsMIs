package tsc.model;

public class GoodsType {
private int id;
private String goodsTypeName;
private String goodsTypeDesc;
private String goodsPrice;
private String oprater;
private String goodsProd;

public GoodsType() {
	super();
	// TODO Auto-generated constructor stub
}
public GoodsType(String goodsTypeName, String goodsTypeDesc, String goodsPrice, String oprater, String goodsProd) {
	super();
	this.goodsTypeName = goodsTypeName;
	this.goodsTypeDesc = goodsTypeDesc;
	this.goodsPrice = goodsPrice;
	this.oprater = oprater;
	this.goodsProd = goodsProd;
}
public GoodsType(int id, String goodsTypeName, String goodsTypeDesc, String goodsPrice, String oprater,
		String goodsProd) {
	super();
	this.id = id;
	this.goodsTypeName = goodsTypeName;
	this.goodsTypeDesc = goodsTypeDesc;
	this.goodsPrice = goodsPrice;
	this.oprater = oprater;
	this.goodsProd = goodsProd;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGoodsTypeName() {
	return goodsTypeName;
}
public void setGoodsTypeName(String goodsTypeName) {
	this.goodsTypeName = goodsTypeName;
}
public String getGoodsTypeDesc() {
	return goodsTypeDesc;
}
public void setGoodsTypeDesc(String goodsTypeDesc) {
	this.goodsTypeDesc = goodsTypeDesc;
}
public String getGoodsPrice() {
	return goodsPrice;
}
public void setGoodsPrice(String goodsPrice) {
	this.goodsPrice = goodsPrice;
}
public String getOprater() {
	return oprater;
}
public void setOprater(String oprater) {
	this.oprater = oprater;
}
public String getGoodsProd() {
	return goodsProd;
}
public void setGoodsProd(String goodsProd) {
	this.goodsProd = goodsProd;
}

}



