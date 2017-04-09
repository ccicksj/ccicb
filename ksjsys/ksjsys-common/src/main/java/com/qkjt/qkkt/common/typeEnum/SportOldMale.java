package com.qkjt.qkkt.common.typeEnum;


public enum SportOldMale {

    JBZ(1, "健步走"),KZ(2,"快走(4~7km/h)")
   ,YZ(3,"远足"),ZXC(4,"慢速骑自行车")
   ,JSC(5,"健身操"),GCW(6,"广场舞"),PPQ(7,"乒乓球")
   ,YY(8,"游泳"),TJQ(9,"太极拳（剑）");
   private Integer key;

   private String value;

   public String getValue() {
       return value;
   }

   public Integer getKey() {
       return key;
   }

   private SportOldMale(Integer key, String value) {
       this.key = key;
       this.value = value;
   }

   /**
    * 通过index获取enmu对象
    * 
    * @param oridal
    * @return
    */
   public static SportOldMale get(int oridal) {
       for (SportOldMale dot : SportOldMale.values()) {
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
   public static SportOldMale getByKey(Integer key) {
       for (SportOldMale dot : SportOldMale.values()) {
           if (key==dot.getKey()) {
               return dot;
           }
       }
       throw new IllegalArgumentException(
               "error:Can't get enum with this key.");
   }

   public static SportOldMale getByValue(String value) {
       for (SportOldMale dot : SportOldMale.values()) {
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
