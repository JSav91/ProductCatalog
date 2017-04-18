package com.unitec.catalog.business.intf;

import java.util.ArrayList;

import com.unitec.catalog.beans.BeanModel;

public interface ManagerInterface {
	
	public ArrayList<BeanModel> getAllRows();
	
	public BeanModel saveBean(BeanModel model);
	
	public BeanModel updateBean(BeanModel model);
	
	public boolean deleteBean(BeanModel model);
	
	public ArrayList<BeanModel> searchBeanByName(BeanModel model);

}
