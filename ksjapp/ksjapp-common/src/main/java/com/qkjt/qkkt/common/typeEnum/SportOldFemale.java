package com.qkjt.qkkt.common.typeEnum;


public enum SportOldFemale {



    JBZ(1, "健步走"),KZ(2,"快走(4~7km/h)"),JSC(3,"健身操"),GCW(4,"广场舞"),YY(5,"游泳");
   private Integer key;

   private String value;

   public String getValue() {
       return value;
   }

   public Integer getKey() {
       return key;
   }

   private SportOldFemale(Integer key, String value) {
       this.key = key;
       this.value = value;
   }

   /**
    * 通过index获取enmu对象
    * 
    * @param oridal
    * @return
    */
   public static SportOldFemale get(int oridal) {
       for (SportOldFemale dot : SportOldFemale.values()) {
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
   public static SportOldFemale getByKey(Integer key) {
       for (SportOldFemale dot : SportOldFemale.values()) {
           if (key==dot.getKey()) {
               return dot;
           }
       }
       throw new IllegalArgumentException(
               "error:Can't get enum with this key.");
   }

   public static SportOldFemale getByValue(String value) {
       for (SportOldFemale dot : SportOldFemale.values()) {
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
