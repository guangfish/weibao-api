package com.new4s.weibao.entity;

public class YqOrderVo extends YqOrder {
	private String channelName;
	private String dealerName;
	private String total;
	private String checking;
	private String querying;
	private String success;
	private String fail;
	private String reject;
	private String norecord;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getChecking() {
		return checking;
	}

	public void setChecking(String checking) {
		this.checking = checking;
	}

	public String getQuerying() {
		return querying;
	}

	public void setQuerying(String querying) {
		this.querying = querying;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFail() {
		return fail;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}

	public String getNorecord() {
		return norecord;
	}

	public void setNorecord(String norecord) {
		this.norecord = norecord;
	}

}
