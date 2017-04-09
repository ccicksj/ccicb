package com.qkjt.qkkt.common.typeEnum;

/**
 * 
 * @author chenfei
 * @date 2014年12月29日 下午5:18:12
 */
public enum YesOrNoType {
    Yes("Y", "是"), No("N", "否");
    private String key;

    private String value;

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    private YesOrNoType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 通过index获取enmu对象
     * 
     * @param oridal
     * @return
     */
    public static YesOrNoType get(int oridal) {
        for (YesOrNoType dot : YesOrNoType.values()) {
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
    public static YesOrNoType getByKey(String key) {
        for (YesOrNoType dot : YesOrNoType.values()) {
            if (key.equals(dot.getKey())) {
                return dot;
            }
        }
        throw new IllegalArgumentException(
                "error:Can't get enum with this key.");
    }

    public static YesOrNoType getByValue(String value) {
        for (YesOrNoType dot : YesOrNoType.values()) {
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
