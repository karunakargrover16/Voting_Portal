package com.voting;

public class result {

	private String optionname;
	private int votes;
	
	public String getOptionname() {
		return optionname;
	}
	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "result [optionname=" + optionname + ", votes=" + votes + "]";
	}
	
}