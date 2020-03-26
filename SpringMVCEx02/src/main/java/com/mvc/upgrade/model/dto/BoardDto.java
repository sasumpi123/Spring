package com.mvc.upgrade.model.dto;

import java.sql.Date;

/*
 	myno number primary key,
	myname varchar2(1000) not null,
	mytitle varchar2(2000) not null,
	mycontent varchar2(4000) not null,
	mydate date not null
 */
public class BoardDto {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	private int mynov;
	
	
	public int getMyno() {
		return myno;
	}


	public void setMyno(int myno) {
		this.myno = myno;
	}


	public String getMyname() {
		return myname;
	}


	public void setMyname(String myname) {
		this.myname = myname;
	}


	public String getMytitle() {
		return mytitle;
	}


	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}


	public String getMycontent() {
		return mycontent;
	}


	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}


	public Date getMydate() {
		return mydate;
	}


	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}


	public int getMynov() {
		return mynov;
	}


	public void setMynov(int mynov) {
		this.mynov = mynov;
	}


	
	public BoardDto(int myno, String myname, String mytitle, String mycontent, Date mydate, int mynov) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
		this.mynov = mynov;
	}


	public BoardDto() {
		
	}

}
