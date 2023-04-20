package com.stgk.gather.enums;

public enum ModbusOffsetEnum {

    VOLTAGE(0),



    ;


    private int index;


    ModbusOffsetEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
