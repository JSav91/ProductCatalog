package com.unitec.catalog.beans;

/**
 * @author JOEL
 *
 */
public class ProductBean implements BeanModel{
	
	private Integer productId;
	private String productName;
	private Double productPrice;
	private Integer productStock;
	private String productComments;
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public String getProductComments() {
		return productComments;
	}
	public void setProductComments(String productComments) {
		this.productComments = productComments;
	}
	
	@Override
	public boolean equals(Object obj) {
		ProductBean compareBean=(ProductBean)obj;
		if(this.getProductId()==compareBean.getProductId()
				&& this.getProductName().equalsIgnoreCase(compareBean.getProductName())
				&& this.getProductComments().equalsIgnoreCase(compareBean.getProductComments())
				&& this.getProductPrice()==compareBean.getProductPrice()
				&& this.getProductStock()==compareBean.getProductStock())
		return true;
		else
			return false;
	}
	

}
