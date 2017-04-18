package com.unitec.catalog.beans;

/**
 * @author JOEL
 *
 */
public class AttendantBean implements BeanModel{
	
	private Integer attendantId;
	private String attendantName;
	private String attendantAddress;
	private String attendantPhone;
	private String attendantComments;
	
	public Integer getAttendantId() {
		return attendantId;
	}
	public void setAttendantId(Integer attendantId) {
		this.attendantId = attendantId;
	}
	public String getAttendantName() {
		return attendantName;
	}
	public void setAttendantName(String attendantName) {
		this.attendantName = attendantName;
	}
	public String getAttendantAddress() {
		return attendantAddress;
	}
	public void setAttendantAddress(String attendantAddress) {
		this.attendantAddress = attendantAddress;
	}
	public String getAttendantPhone() {
		return attendantPhone;
	}
	public void setAttendantPhone(String attendantPhone) {
		this.attendantPhone = attendantPhone;
	}
	public String getAttendantComments() {
		return attendantComments;
	}
	public void setAttendantComments(String attendantComments) {
		this.attendantComments = attendantComments;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		AttendantBean compareBean=(AttendantBean)obj;
		if(this.getAttendantId()==compareBean.getAttendantId()
				&& this.getAttendantName().equalsIgnoreCase(compareBean.getAttendantName())
				&& this.getAttendantAddress().equalsIgnoreCase(compareBean.getAttendantAddress())
				&& this.getAttendantPhone().equalsIgnoreCase(compareBean.getAttendantPhone())
				&& this.getAttendantComments().equalsIgnoreCase(compareBean.getAttendantPhone()))
		return true;
		else
		return false;
	}
}
