package com.qkjt.qkkt.common.typeEnum;

 /**
 * 一体机投放状态，下拉框
 * @author chenfei
 * @date 2014年12月29日 下午4:07:35
 */
public enum MfpPlaceState {
    // Ready("1","投放准备"),Already("2","已经投放"),Termination("3","投放终止");
    Ready("1","投放准备"),Already("2","已经投放"),Termination("3","投放终止");
    private String key;

    private String value;

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    private MfpPlaceState(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 通过index获取enmu对象
     * 
     * @param oridal
     * @return
     */
    public static MfpPlaceState get(int oridal) {
        for (MfpPlaceState dot : MfpPlaceState.values()) {
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
    public static MfpPlaceState getByKey(String key) {
        for (MfpPlaceState dot : MfpPlaceState.values()) {
            if (key.equals(dot.getKey())) {
                return dot;
            }
        }
        throw new IllegalArgumentException(
                "error:Can't get enum with this key.");
    }

    public static MfpPlaceState getByValue(String value) {
        for (MfpPlaceState dot : MfpPlaceState.values()) {
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
