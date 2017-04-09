package com.qkjt.qkkt.common.typeEnum;


public enum DetailItemType {

	PG("1", "评估"), JY("2", "建议"),FX("3", "风险"), BG("4", "报告"),YS("5", "饮食"), YD("6", "运动"),YY("7", "营养"), BJ("8", "保健"),MB("9", "模板");
	private String key;

	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private DetailItemType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static DetailItemType get(int oridal) {
		for (DetailItemType dot : DetailItemType.values()) {
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
	public static DetailItemType getByKey(String key) {
		for (DetailItemType dot : DetailItemType.values()) {
			if (key.equals(dot.getKey())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static DetailItemType getByValue(String value) {
		for (DetailItemType dot : DetailItemType.values()) {
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
