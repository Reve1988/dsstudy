package org.geniurd.dsstudy;

import org.geniurd.dsstudy.decode.Decode;

public class Main {
    public static void main(String[] args) {
		Decode decode = new Decode();
		String string = decode.decode("2 6 010000001001");

		System.out.println(string);
    }
}
