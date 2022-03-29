package com.warpit.demoapp.scheduler.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class QRCode {

	@Id
	private String id;

	// check in URL
	// http://localhost:8080/activities/mathematics/checkIn?studentId=1234&qrCodeKey=QAZWSX
	private String qrCodeURL;

	// validation key
	private String qrCodeKey;

	private String activityName;
	private String activityCode;

	protected QRCode() {
	}

	public QRCode(String qrCodeURL, String qrCodeKey, String activityName, String activityCode) {
		super();
		this.qrCodeURL = qrCodeURL;
		this.qrCodeKey = qrCodeKey;
		this.activityName = activityName;
		this.activityCode = activityCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQrCodeURL() {
		return qrCodeURL;
	}

	public void setQrCodeURL(String qrCodeURL) {
		this.qrCodeURL = qrCodeURL;
	}

	public String getQrCodeKey() {
		return qrCodeKey;
	}

	public void setQrCodeKey(String qrCodeKey) {
		this.qrCodeKey = qrCodeKey;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	@Override
	public String toString() {
		return "QRCode [id=" + id + ", qrCodeURL=" + qrCodeURL + ", qrCodeKey=" + qrCodeKey + ", activityName="
				+ activityName + ", activityCode=" + activityCode + "]";
	}

}
