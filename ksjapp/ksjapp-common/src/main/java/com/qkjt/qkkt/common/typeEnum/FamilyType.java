package com.qkjt.qkkt.common.typeEnum;


public enum FamilyType {

	ZF("1", "祖父"), ZM("2", "祖母"),FQ("3", "父亲"), MQ("4", "母亲"),PO("5", "配偶"), EZ("6", "儿子"),NE("7", "女儿");
	private String key;

	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private FamilyType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static FamilyType get(int oridal) {
		for (FamilyType dot : FamilyType.values()) {
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
	public static FamilyType getByKey(String key) {
		for (FamilyType dot : FamilyType.values()) {
			if (key.equals(dot.getKey())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static FamilyType getByValue(String value) {
		for (FamilyType dot : FamilyType.values()) {
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
