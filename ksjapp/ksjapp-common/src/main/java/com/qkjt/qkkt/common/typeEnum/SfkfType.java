package com.qkjt.qkkt.common.typeEnum;


public enum SfkfType {
	// F男,M女，U未知
	// Female("F","男"),Male("M","女"),Unknown("U","未知");
	KF("y", "空腹"), BKF("n", "不空腹"),FHLXS("c", "饭后两小时");
	private String key;

	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private SfkfType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static SfkfType get(int oridal) {
		for (SfkfType dot : SfkfType.values()) {
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
	public static SfkfType getByKey(String key) {
		for (SfkfType dot : SfkfType.values()) {
			if (key.equals(dot.getKey())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static SfkfType getByValue(String value) {
		for (SfkfType dot : SfkfType.values()) {
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
