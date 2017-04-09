package com.qkjt.qkkt.common.typeEnum;


public enum ClientType {

	MFP("MFP", "一体机"), APP("APP", "手机"),PC("PC", "电脑");
	private String key;

	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private ClientType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static ClientType get(int oridal) {
		for (ClientType dot : ClientType.values()) {
			if (oridal == dot.ordinal()) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this oridal.");
	}

	/**
	 * 通过值获取enmu对象
	 * 
	 * @param value
	 * @return
	 */
	public static ClientType getByKey(String key) {
		for (ClientType dot : ClientType.values()) {
			if (key.equals(dot.getKey())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static ClientType getByValue(String value) {
		for (ClientType dot : ClientType.values()) {
			if (value.equals(dot.getValue())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get key with this value.");
	}

	@Override
	public String toString() {
		return String.valueOf(this.key);
	}
}
