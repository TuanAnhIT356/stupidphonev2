package com.dhl.blahblah.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_detail")
public class ProductDetail {
	private int id;
	private String _3G;
	private String _4G;
	private String sim;
	private String size;
	private String screen;
	private String screenSize;
	private String internalMemory;
	private String os;
	private String chipset;
	private String cpu;
	private String pin;
	private String primaryCamera;
	private String secondaryCamera;
	private Date insertDate;

	
	public ProductDetail() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="3G")
	public String get_3G() {
		return _3G;
	}

	public void set_3G(String _3g) {
		_3G = _3g;
	}

	@Column(name="4G")
	public String get_4G() {
		return _4G;
	}

	public void set_4G(String _4g) {
		_4G = _4g;
	}

	@Column(name="sim")
	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	@Column(name="size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name="screen")
	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	@Column(name="screen_size")
	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	@Column(name="internal_memory")
	public String getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(String internalMemory) {
		this.internalMemory = internalMemory;
	}

	@Column(name="os")
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Column(name="chipset")
	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	@Column(name="cpu")
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Column(name="pin")
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Column(name="primary_camera")
	public String getPrimaryCamera() {
		return primaryCamera;
	}

	public void setPrimaryCamera(String primaryCamera) {
		this.primaryCamera = primaryCamera;
	}

	@Column(name="secondary_camera")
	public String getSecondaryCamera() {
		return secondaryCamera;
	}

	public void setSecondaryCamera(String secondaryCamera) {
		this.secondaryCamera = secondaryCamera;
	}

	@Column(name="insert_date", insertable=false, updatable=false)
	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", _3G=" + _3G + ", _4G=" + _4G + ", sim=" + sim + ", size=" + size
				+ ", screen=" + screen + ", screenSize=" + screenSize + ", internalMemory=" + internalMemory + ", os="
				+ os + ", chipset=" + chipset + ", cpu=" + cpu + ", pin=" + pin + ", primaryCamera=" + primaryCamera
				+ ", secondaryCamera=" + secondaryCamera + ", insertDate=" + insertDate + "]";
	}
}