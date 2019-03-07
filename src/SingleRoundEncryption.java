/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashr
 */
public class SingleRoundEncryption {
    static int P[] = {16, 7, 20, 21, 29, 12, 28, 17, 
                    1, 15, 23, 26, 5, 18, 31, 10, 
                    2, 8, 24, 14, 32, 27, 3, 9, 
                   19, 13, 30, 6, 22, 11, 4, 25};
    static int E[] = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 
                    8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 
                   16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 
                   24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32 ,1};
    static int PC2[] = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 
                     23, 19, 12 ,4, 26, 8, 16, 7, 27, 20, 13, 2, 
                     41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 
                     44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
    static int IP_Inverse[] = {40, 8, 48, 16, 56, 24, 64,32, 39, 7, 47, 15, 55, 23, 63, 31,
                            38, 6, 46, 14, 54, 22, 62, 30,37, 5, 45, 13,53, 21, 61, 29,
                            36, 4, 44, 12, 52, 20, 60, 28,35, 3, 43, 11, 51, 19, 59, 27,
                            34, 2, 42, 10, 50, 18, 58, 26,33, 1, 41, 9, 49, 17, 57, 25};
    static int IP[] = {58, 50, 42, 34, 26, 18, 10, 2,60, 52, 44, 36, 28, 20 ,12, 4, 
                    62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8,
                    57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 
                    61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};

    static int PC1[] = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 
                     10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 
                     63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 
                     14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    
    public static int[][] initializeDES(StringBuilder inputbin, StringBuilder keybin) {
        // perform initial permutation
        int[] ipout = new int[64];
        for(int i=0; i<64; i++) {
            ipout[i] = Character.getNumericValue(inputbin.charAt(IP[i]-1));
        }
        
        // PC1
        int[] pc1out = new int[56];
        for(int i=0; i<56; i++) {
            pc1out[i] = Character.getNumericValue(keybin.charAt(PC1[i]-1));
        }
        
        // Split PC1 in 2 parts
        int[] lefthalfafterkey = new int[28];
        int[] righthalfafterkey = new int[28];
        for (int i=0; i<28; i++) {
            lefthalfafterkey[i] = pc1out[i];
            righthalfafterkey[i] = pc1out[i+28];
        }
        
        // Split Input after IP in 2 parts and feed both to nth round function
        int[] lefthalfafterin = new int[32];
        int[] righthalfafterin = new int[32];
        for(int i=0; i<32; i++) {
            lefthalfafterin[i] = ipout[i];
            righthalfafterin[i] = ipout[i+32];
        }
        int[][] out = new int[4][];
        out[0] = lefthalfafterin;
        out[1] = righthalfafterin;
        out[2] = lefthalfafterkey;
        out[3] = righthalfafterkey;
        
        return out;
    }
    
    public static int[][] nRoundDES(int round, int[][] in) {
        int[] lefthalfbeforein = in[0];
        int[] righthalfbeforein = in[1];
        int[] lefthalfbeforekey = in[2];
        int[] righthalfbeforekey = in[3];
        
        // left circular shift according to the schedule
        if(round==1 || round==2 || round==9 || round==16) {
            lefthalfbeforekey = Functions.shiftCircularLeft(lefthalfbeforekey, 1);
            righthalfbeforekey = Functions.shiftCircularLeft(righthalfbeforekey, 1);
        } else {
            lefthalfbeforekey = Functions.shiftCircularLeft(lefthalfbeforekey, 2);
            righthalfbeforekey = Functions.shiftCircularLeft(righthalfbeforekey, 2);
        }
        
        // perform expansion permutation of right half
        int[] expperm = Functions.doPermutation(righthalfbeforein, E);
        
        // Expansion permutation for input done, move to key processing
        
        // Permuted Choice 2
        int[] pc2out = new int[48];
        for(int i=0; i<48; i++) {
            if(PC2[i]>28) {
                pc2out[i] = righthalfbeforekey[PC2[i]-28-1];
            } else {
                pc2out[i] = lefthalfbeforekey[PC2[i]-1];
            }
        }
        
        // Back to processing input 
        
        // XOR EP output and PC2 output
        int[] xorOutput1 = Functions.XOR(pc2out, expperm);

        // S-Box
        int[] sboxOut = Functions.sBox(xorOutput1);

        // Permutation after S
        int[] pOut = Functions.doPermutation(sboxOut, P);

        // XOR Permutation2 and Left Half Before/Initial
        int[] xorOutput2 = Functions.XOR(lefthalfbeforein, pOut);
        
        // copy right half 32 bits to left half
        int[] lefthalfafterin = righthalfbeforein;
        int[] righthalfafterin = xorOutput2;
        int[] lefthalfafterkey = lefthalfbeforekey;
        int[] righthalfafterkey = righthalfbeforekey;
        
        int[][] out = new int[4][];
        out[0] = lefthalfafterin;
        out[1] = righthalfafterin;
        out[2] = lefthalfafterkey;
        out[3] = righthalfafterkey;
        
        return out;
    }
    
    public static int[] finalizeDES(int[][] in) {
        int[] lefthalfbeforein = in[0];
        int[] righthalfbeforein = in[1];
        
        // 32 bit swap
        int[] temp = righthalfbeforein;
        righthalfbeforein = lefthalfbeforein;
        lefthalfbeforein = temp;
        
        int[] tempJoin = new int[64];
        for(int i=0; i<64; i++) {
            if(i>31) {
                tempJoin[i] = righthalfbeforein[i-32];
            } else {
                tempJoin[i] = lefthalfbeforein[i];
            }
        }
        
        // IP Inverse
        int[] ipInverseOut = Functions.doPermutation(tempJoin, IP_Inverse);
        
        return ipInverseOut;
    }
}
