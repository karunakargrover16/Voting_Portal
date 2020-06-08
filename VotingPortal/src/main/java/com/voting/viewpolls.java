package com.voting;

public class viewpolls {
	
	private String pollname;
	private String startdate;
	private String starttime;
	private String enddate;
	private String endtime;
	public String getPollname() {
		return pollname;
	}
	public void setPollname(String pollname) {
		this.pollname = pollname;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "[pollname=" + pollname + ", startdate=" + startdate + ", starttime=" + starttime
				+ ", enddate=" + enddate + ", endtime=" + endtime + "]";
	}
	

}