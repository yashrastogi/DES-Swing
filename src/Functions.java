
import java.math.BigInteger;

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
    public static int[] sBox(int[] xorIn) {
        int S1[][] = {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, 
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, 
                    {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0}, 
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}}; 
	int S2[][] = {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, 
                      {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, 
                      {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, 
                      {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}}; 
	int S3[][] = {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, 
                    {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, 
                    {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, 
                    {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}}; 
	int S4[][] = {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, 
                    {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, 
                    {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, 
                    {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}}; 
	int S5[][] = {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, 
                    {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, 
                    {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, 
                    {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}}; 
	int S6[][] = {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, 
                    {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, 
                    {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, 
                    {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}}; 
	int S7[][] = {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, 
                    {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, 
                    {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, 
                    {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}}; 
	int S8[][] = {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, 
                    {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, 
                    {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, 
                    {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}}; 
        // xorIn.length = 48;
        int[] sboxOut = new int[32];
        StringBuilder sboxOutTemp = new StringBuilder();
        for(int i=0; i<48; i+=6) {
            String binRow = ""+xorIn[i]+xorIn[i+5];
            String binColumn = ""+xorIn[i+1]+xorIn[i+2]+xorIn[i+3]+xorIn[i+4];
            int row = Integer.parseInt(binRow,2);
            int column = Integer.parseInt(binColumn,2);
            int sOut = 0;
            if(i == 0) {
                // 0-5th bit use S1
                sOut = S1[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 6) {
                // 6-11th bit use S2
                sOut = S2[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 12) {
                // 12-17th bit use S3
                sOut = S3[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 18) {
                // 18-23rd bit use S4
                sOut = S4[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 24) {
                // 24-29th bit use S5
                sOut = S5[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 30) {
                // 30-35th bit use S6
                sOut = S6[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 36) {
                // 36-41st bit use S7
                sOut = S7[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
            if(i == 42) {
                // 42-47th bit use S8
                sOut = S8[row][column];
                sboxOutTemp.append(Integer.toBinaryString(sOut));
            }
        }
        for(int i=0; i<sboxOutTemp.length(); i++) {
            sboxOut[i] = Character.getNumericValue(sboxOutTemp.charAt(i));
        }
        return sboxOut;
    }
    
    public static int[] permutationFunction(int[] sboxIn) {
        int P[] = {16, 7, 20, 21, 29, 12, 28, 17, 
                    1, 15, 23, 26, 5, 18, 31, 10, 
                    2, 8, 24, 14, 32, 27, 3, 9, 
                   19, 13, 30, 6, 22, 11, 4, 25};
        int[] pOut = new int[sboxIn.length];
        for(int i=0; i<sboxIn.length; i++) {
            pOut[P[i]-1] = sboxIn[i]; 
        }
        return pOut;
    }
    
    public static void printHex(int[] arr, String msg) {
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            temp.append(arr[i]);
        }
        BigInteger temp2 = new BigInteger(""+temp, 2);
        System.out.println("\nOutput of "+msg+" (in hex): "+temp2.toString(16));
    }
    
    public static void printHex(StringBuilder temp, String msg) {
        BigInteger temp2 = new BigInteger(""+temp, 2);
        System.out.println("\nOutput of "+msg+" (in hex): "+temp2.toString(16));
    }
    
    public static void printHex(int[][] in, String msg) {
        int len = in[0].length+in[1].length;
        StringBuilder temp = new StringBuilder();
     
        for(int i=0; i<len; i++) {
            if(i<len/2) {
                temp.append(in[0][i]);
            } else {
                temp.append(in[1][i-32]);
            }
        }
        BigInteger temp2 = new BigInteger(""+temp, 2);
        System.out.println("\nOutput of "+msg+" (in hex): "+temp2.toString(16));
    }
    
    public static int[] XOR(int[] bits1, int[] bits2) {
        // XOR same length Binary int arrays
        int[] xorOut = new int[bits1.length];
        if(bits1.length!=bits2.length) {
            return null;
        }
        for(int i=0; i<bits1.length; i++) {
            xorOut[i] = bits1[i] ^ bits2[i];
        }
        return xorOut;
    }
}
