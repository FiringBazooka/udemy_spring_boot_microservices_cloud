package com.spring.api.demo3.pojo;

public class CurrencyConversionVO {

	private Long id;
	private String from;
	private String to;
	private int value;
	private String env;
	private int amount;
	private int convertedAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(int convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

}
