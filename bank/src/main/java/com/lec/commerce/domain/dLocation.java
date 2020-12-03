package com.lec.commerce.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter

@Table(name = "locations")
public class dLocation {
	
	@Id
	private int id;
	private int userid;
	private String office;
	private String date;
	private String tin;
	private String tout;
	private int status = 0;
	
	
	@Override
	public String toString() {
		return "dLocation [id=" + id + ", userid=" + userid + ", office=" + office + ", date=" + date + ", tin=" + tin
				+ ", tout=" + tout + ", status=" + status + "]";
	}
}
