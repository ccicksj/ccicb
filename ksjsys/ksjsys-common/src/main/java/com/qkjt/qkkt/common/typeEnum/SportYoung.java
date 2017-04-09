package com.qkjt.qkkt.common.typeEnum;


public enum SportYoung {

	 JBZ(1, "健步走"),KZ(2,"快走(4~7km/h)")
	,YZ(3,"远足"),ZQ(4,"足球"),PS(5,"爬山"),ZXC(6,"慢速骑自行车"),LH(7,"轮滑")
	,JSC(8,"健身操"),GCW(9,"广场舞"),PPQ(10,"乒乓球"),YMQ(11,"羽毛球"),YJ(12,"瑜伽")
	,YY(13,"游泳"),GLT(14,"爬楼梯"),TJZ(15,"踢毽子"),TJQ(16,"太极拳（剑）"),WQ(17,"网球");
	private Integer key;

	private String value;

	public String getValue() {
		return value;
	}

	public Integer getKey() {
		return key;
	}

	private SportYoung(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static SportYoung get(int oridal) {
		for (SportYoung dot : SportYoung.values()) {
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
	public static SportYoung getByKey(Integer key) {
		for (SportYoung dot : SportYoung.values()) {
			if (key==dot.getKey()) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static SportYoung getByValue(String value) {
		for (SportYoung dot : SportYoung.values()) {
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
