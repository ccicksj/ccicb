package com.qkjt.qkkt.common.typeEnum;


public enum MfpType {
	SJ("0", "双佳一体机"), BT("1", "倍泰一体机");
	private String key;

	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private MfpType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static MfpType get(int oridal) {
		for (MfpType dot : MfpType.values()) {
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
	public static MfpType getByKey(String key) {
		for (MfpType dot : MfpType.values()) {
			if (key.equals(dot.getKey())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static MfpType getByValue(String value) {
		for (MfpType dot : MfpType.values()) {
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
