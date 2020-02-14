package com.eziosoft.plastic.util;

public class configUtil {

    public static Integer[] getControllerConfig(int sync, int selection){
        if (selection == 0){
            return new Integer[]{sync, 0, 0, 0};
        } else if (selection == 1){
            return new Integer[]{sync, 150, 100, 9};
        }
        return new Integer[]{2};
    }
}
