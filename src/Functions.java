/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashr
 */
public class Functions {
    public static int[] shiftCircularLeft(int[] bits) {
        int bit = bits[0];
        int length = bits.length - 1;
        int[] output = new int[bits.length];

        for (int i = 0; i < length; i++) {
            output[i] = bits[i + 1];
        }

        output[length] = bit;

        return output;
    }
}
