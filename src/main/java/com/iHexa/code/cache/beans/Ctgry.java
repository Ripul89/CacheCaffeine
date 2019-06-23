package com.iHexa.code.cache.beans;

import java.io.Serializable;

public class Ctgry implements Serializable {
	private Integer ctgry_id;
	private Integer ctgry_typ_id;
	private String from_dt;
	private String thru_dt;
	private String locale_cd;
	private String ctgry_nm;
	private String ctgry_dsc;
	private String mkt_dsc;

	public Ctgry() {
		
	}
	public Ctgry(Integer ctgry_id, Integer ctgry_typ_id, String from_dt, String thru_dt, String locale_cd,
			String ctgry_nm, String ctgry_dsc, String mkt_dsc) {
		super();
		this.ctgry_id = ctgry_id;
		this.ctgry_typ_id = ctgry_typ_id;
		this.from_dt = from_dt;
		this.thru_dt = thru_dt;
		this.locale_cd = locale_cd;
		this.ctgry_nm = ctgry_nm;
		this.ctgry_dsc = ctgry_dsc;
		this.mkt_dsc = mkt_dsc;
	}

	public Integer getCtgry_id() {
		return ctgry_id;
	}

	public void setCtgry_id(Integer ctgry_id) {
		this.ctgry_id = ctgry_id;
	}

	public Integer getCtgry_typ_id() {
		return ctgry_typ_id;
	}

	public void setCtgry_typ_id(Integer ctgry_typ_id) {
		this.ctgry_typ_id = ctgry_typ_id;
	}

	public String getFrom_dt() {
		return from_dt;
	}

	public void setFrom_dt(String from_dt) {
		this.from_dt = from_dt;
	}

	public String getThru_dt() {
		return thru_dt;
	}

	public void setThru_dt(String thru_dt) {
		this.thru_dt = thru_dt;
	}

	public String getLocale_cd() {
		return locale_cd;
	}

	public void setLocale_cd(String locale_cd) {
		this.locale_cd = locale_cd;
	}

	public String getCtgry_nm() {
		return ctgry_nm;
	}

	public void setCtgry_nm(String ctgry_nm) {
		this.ctgry_nm = ctgry_nm;
	}

	public String getCtgry_dsc() {
		return ctgry_dsc;
	}

	public void setCtgry_dsc(String ctgry_dsc) {
		this.ctgry_dsc = ctgry_dsc;
	}

	public String getMkt_dsc() {
		return mkt_dsc;
	}

	public void setMkt_dsc(String mkt_dsc) {
		this.mkt_dsc = mkt_dsc;
	}

}
