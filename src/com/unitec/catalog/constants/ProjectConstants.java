package com.unitec.catalog.constants;

public interface ProjectConstants {
	
	public static final String GET_ALL_PRODUCTS= "Select * from product";
	public static final String INSERT_PRODUCT="Insert into product (PRD_NAME,PRD_PRICE,PRD_STOCK,PRD_COMMENTS) values (?,?,?,?)";
	public static final String UPDATE_PRODUCT="Update product set PRD_NAME=?,PRD_PRICE=?,PRD_STOCK=?,PRD_COMMENTS=? WHERE PRD_ID=?";
	public static final String DELETE_PRODUCT="Delete from product where PRD_ID=?";
	public static final String SEARCH_PRODUCT="Select * from product where PRD_NAME= ";
	
	public static final String GET_ALL_ATTENDANTS="Select * from attendant";
	public static final String INSERT_ATTENDANT="Insert into attendant (ATT_NAME,ATT_ADDRESS,ATT_MOBILENUM,ATT_COMMENTS) values (?,?,?,?)";
	public static final String UPDATE_ATTENDANT="Update attendant set ATT_NAME=?,ATT_ADDRESS=?,ATT_MOBILENUM=?,ATT_COMMENTS=? where ATT_ID=?";
	public static final String DELETE_ATTENDANT="Delete from attendant where ATT_ID=?";
	public static final String SEARCH_ATTENDANT="Select * from attendant where ATT_NAME =";
}
