package com.bdi.mvc.vo;

public class User {
	private int uino;
	private String uiname;
	private String uiid;
	private String uipwd;
	private String uidesc;
	private int uiage;
	public int getUino() {
		return uino;
	}
	@Override
	public String toString() {
		return "User [uino=" + uino + ", uiname=" + uiname + ", uiid=" + uiid + ", uipwd=" + uipwd + ", uidesc="
				+ uidesc + ", uiage=" + uiage + ", dino=" + dino + "]";
	}
	public void setUino(int uino) {
		this.uino = uino;
	}
	public String getUiname() {
		return uiname;
	}
	public void setUiname(String uiname) {
		this.uiname = uiname;
	}
	public String getUiid() {
		return uiid;
	}
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	public String getUipwd() {
		return uipwd;
	}
	public void setUipwd(String uipwd) {
		this.uipwd = uipwd;
	}
	public String getUidesc() {
		return uidesc;
	}
	public void setUidesc(String uidesc) {
		this.uidesc = uidesc;
	}
	public int getUiage() {
		return uiage;
	}
	public void setUiage(int uiage) {
		this.uiage = uiage;
	}
	public int getDino() {
		return dino;
	}
	public void setDino(int dino) {
		this.dino = dino;
	}
	public User(int uino, String uiname, String uiid, String uipwd, String uidesc, int uiage, int dino) {
		super();
		this.uino = uino;
		this.uiname = uiname;
		this.uiid = uiid;
		this.uipwd = uipwd;
		this.uidesc = uidesc;
		this.uiage = uiage;
		this.dino = dino;
	}
	private int dino;
}