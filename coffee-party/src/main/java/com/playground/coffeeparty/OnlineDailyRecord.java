package com.playground.coffeeparty;

public class OnlineDailyRecord {

	private String date;
	private String sDay;
	private boolean isWorkDay;
	private boolean isOBT;
	private boolean isHoliday;
	private boolean isVL;
	private boolean isSL;
	private String timeIn;
	private String timeOut;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getsDay() {
		return sDay;
	}
	public void setsDay(String sDay) {
		this.sDay = sDay;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public boolean isWorkDay() {
		return isWorkDay;
	}
	public void setWorkDay(boolean isWorkDay) {
		this.isWorkDay = isWorkDay;
	}
	public boolean isVL() {
		return isVL;
	}
	public void setVL(boolean isVL) {
		this.isVL = isVL;
	}
	public boolean isSL() {
		return isSL;
	}
	public void setSL(boolean isSL) {
		this.isSL = isSL;
	}
	public boolean isOBT() {
		return isOBT;
	}
	public void setOBT(boolean isOBT) {
		this.isOBT = isOBT;
	}
	
}
