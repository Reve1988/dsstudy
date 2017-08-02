package org.geniurd.dsstudy;

import org.geniurd.dsstudy.number.NumberUtils;

public class Main {
    public static void main(String[] args) {
        String result = NumberUtils.toNumberSystem(233, 2);
        System.out.println("result : " + result);
    }
}
