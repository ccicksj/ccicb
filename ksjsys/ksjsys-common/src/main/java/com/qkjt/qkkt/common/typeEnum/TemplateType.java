package com.qkjt.qkkt.common.typeEnum;


public enum TemplateType {

	Tmp1("1", "测量指标分析综合报告"),Tmp2("2", "调查问卷分析综合报告"),Tmp3("3", "通用干预方案"),
	Tmp4("4", "运动干预方案"),Tmp5("5", "常规饮食干预方案"),Tmp6("6", "尿酸异常饮食干预方案"),
	Tmp7("7", "报告总结有异常模板"),Tmp8("8", "报告总结无对应干预模板"),Tmp9("9", "报告总结各项指标正常模板");
	private String key;

	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private TemplateType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过index获取enmu对象
	 * 
	 * @param oridal
	 * @return
	 */
	public static TemplateType get(int oridal) {
		for (TemplateType dot : TemplateType.values()) {
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
	public static TemplateType getByKey(String key) {
		for (TemplateType dot : TemplateType.values()) {
			if (key.equals(dot.getKey())) {
				return dot;
			}
		}
		throw new IllegalArgumentException(
				"error:Can't get enum with this key.");
	}

	public static TemplateType getByValue(String value) {
		for (TemplateType dot : TemplateType.values()) {
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
