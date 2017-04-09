package com.qkjt.qkkt.common.typeEnum;

 /**
 * 一体机状态，下拉框
 * @author chenfei
 * @date 2014年12月29日 下午4:07:35
 */
public enum MfpBasicState {
    // Normal("1","正常"),Malfunction("2","故障"),Scrapped("3","报废");
    Normal("1","正常"),Malfunction("2","故障"),Scrapped("3","报废");
    private String key;

    private String value;

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    private MfpBasicState(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 通过index获取enmu对象
     * 
     * @param oridal
     * @return
     */
    public static MfpBasicState get(int oridal) {
        for (MfpBasicState dot : MfpBasicState.values()) {
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
    public static MfpBasicState getByKey(String key) {
        for (MfpBasicState dot : MfpBasicState.values()) {
            if (key.equals(dot.getKey())) {
                return dot;
            }
        }
        throw new IllegalArgumentException(
                "error:Can't get enum with this key.");
    }

    public static MfpBasicState getByValue(String value) {
        for (MfpBasicState dot : MfpBasicState.values()) {
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
