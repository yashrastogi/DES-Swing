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
    
    public static int[][] firstRoundDES(int round, int[] pc1out, int[] ipout) {
        /* /commentable */
        int[] pc1lefthalfbefore = new int[28];
        int[] pc1righthalfbefore = new int[28];
        for (int i=0; i<28; i++) {
            pc1lefthalfbefore[i] = pc1out[i];
            pc1righthalfbefore[i] = pc1out[i+28];
        }
        /* commentable */
        System.out.println("\n\nLeft pc1halfbefore: ");
        for(int i: pc1lefthalfbefore) {
            System.out.print(i);   
        }
        System.out.println("\n\nRight pc1halfbefore: ");
        for(int i: pc1righthalfbefore) {
            System.out.print(i);   
        }
        /* /commentable */
        // left circular shift by 1 bit for 1st round
        for(int i=0; i<round; i++) {
            pc1lefthalfbefore = Functions.shiftCircularLeft(pc1lefthalfbefore);
            pc1righthalfbefore = Functions.shiftCircularLeft(pc1righthalfbefore);
        }
        /* commentable */
        System.out.println("\n\nLeft pc1halfbefore shifted: ");
        for(int i: pc1lefthalfbefore) {
            System.out.print(i);   
        }
        System.out.println("\n\nRight pc1halfbefore shifted: ");
        for(int i: pc1righthalfbefore) {
            System.out.print(i);   
        }
        /* /commentable */
        int[] lefthalfbeforein = new int[32];
        int[] righthalfbeforein = new int[32];
        for(int i=0; i<32; i++) {
            lefthalfbeforein[i] = ipout[i];
            righthalfbeforein[i] = ipout[i+32];
        }
        /* commentable */
        System.out.println("\n\nLeft halfbeforein: ");
        for(int i: lefthalfbeforein) {
            System.out.print(i);   
        }
        System.out.println("\n\nRight halfbeforein: ");
        for(int i: righthalfbeforein) {
            System.out.print(i);   
        }
        /* /commentable */
        
        // perform expansion permutation of right half
        int[] expperm = new int[48];
        for(int i=0; i<48; i++) {
            expperm[i] = righthalfbeforein[E[i]-1]; 
        }
         /* commentable */
        System.out.println("\n\nExpansion permutation output:");
        for(int i: expperm) {
            System.out.print(i);   
        }
        System.out.println();
        /* /commentable */
        // Done till expansion permutation, key part begins
        
        
        // Permuted Choice 2
        int[] pc2out = new int[48];
        for(int i=0; i<48; i++) {
            //System.out.println("PC2["+i+"]: "+PC2[i]);
            if(PC2[i]>28) {
                pc2out[i] = pc1righthalfbefore[PC2[i]-28-1];
            } else {
                pc2out[i] = pc1lefthalfbefore[PC2[i]-1];
            }
        }
         /* commentable */
        System.out.println("\n\nPC2 output (Length: "+pc2out.length+"):");
        for(int i: pc2out) {
            System.out.print(i);   
        }
        /* /commentable */
        
        // Back to input 
        
        // XOR EP output and PC2 output
        int[] xoroutput1 = Functions.XOR(expperm, pc2out);

         /* commentable */
        System.out.println("\n\nXOR1 output (Length: "+xoroutput1.length+"):");
        for(int i: xoroutput1) {
            System.out.print(i);   
        }
        /* /commentable */
        
        // S-Box
        int[] sboxOut = Functions.sBox(xoroutput1);
        /* commentable */
        System.out.println("\n\nSBOX output (Length: "+sboxOut.length+"):");
        for(int i: sboxOut) {
            System.out.print(i);   
        }
        /* /commentable */
        
        // Permutation after S
        int[] pOut = Functions.permutationFunction(sboxOut);
        /* commentable */
        System.out.println("\n\nPermutation output (Length: "+pOut.length+"):");
        for(int i: pOut) {
            System.out.print(i);   
        }
        /* /commentable */
        
        // XOR Permutation2 and Left Half Before/Initial
        int[] xorOutput2 = Functions.XOR(pOut, lefthalfbeforein);
        
        /* commentable */
        System.out.println("\n\nXOR2 output/Right Half After (Length: "+xorOutput2.length+"):");
        for(int i: xorOutput2) {
            System.out.print(i);   
        }
        
        System.out.println("\n\nLeft Half After (Length: "+righthalfbeforein.length+"):");
        for(int i: righthalfbeforein) {
            System.out.print(i); 
        }
        /* /commentable */
 
        // copy right half 32 bits to left half
        int[] lefthalfafterin = righthalfbeforein;
        int[] righthalfafterin = xorOutput2;
        
        int[] lefthalfafterkey = pc1lefthalfbefore;
        int[] righthalfafterkey = pc1righthalfbefore;
        
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
        
        // left circular shift by n bit for nth round
        for(int i=0; i<round; i++) {
            lefthalfbeforekey = Functions.shiftCircularLeft(lefthalfbeforekey);
            righthalfbeforekey = Functions.shiftCircularLeft(righthalfbeforekey);
        }
        
        // perform expansion permutation of right half
        int[] expperm = new int[48];
        for(int i=0; i<48; i++) {
            expperm[i] = righthalfbeforein[E[i]-1]; 
        }
//         /* commentable */
//        System.out.println("\n\nExpansion permutation output:");
//        for(int i: expperm) {
//            System.out.print(i);   
//        }
//        System.out.println();
//        /* /commentable */
        // Done till expansion permutation, key part begins
        
        
        // Permuted Choice 2
        int[] pc2out = new int[48];
        for(int i=0; i<48; i++) {
            //System.out.println("PC2["+i+"]: "+PC2[i]);
            if(PC2[i]>28) {
                pc2out[i] = righthalfbeforekey[PC2[i]-28-1];
            } else {
                pc2out[i] = lefthalfbeforekey[PC2[i]-1];
            }
        }
//         /* commentable */
//        System.out.println("\n\nPC2 output (Length: "+pc2out.length+"):");
//        for(int i: pc2out) {
//            System.out.print(i);   
//        }
//        /* /commentable */
        
        // Back to input 
        
        // XOR EP output and PC2 output
        int[] xoroutput1 = Functions.XOR(expperm, pc2out);

//         /* commentable */
//        System.out.println("\n\nXOR1 output (Length: "+xoroutput1.length+"):");
//        for(int i: xoroutput1) {
//            System.out.print(i);   
//        }
//        /* /commentable */
        
        // S-Box
        int[] sboxOut = Functions.sBox(xoroutput1);
//        /* commentable */
//        System.out.println("\n\nSBOX output (Length: "+sboxOut.length+"):");
//        for(int i: sboxOut) {
//            System.out.print(i);   
//        }
//        /* /commentable */
        
        // Permutation after S
        int[] pOut = Functions.permutationFunction(sboxOut);
//        /* commentable */
//        System.out.println("\n\nPermutation output (Length: "+pOut.length+"):");
//        for(int i: pOut) {
//            System.out.print(i);   
//        }
//        /* /commentable */
//        
        // XOR Permutation2 and Left Half Before/Initial
        int[] xorOutput2 = Functions.XOR(pOut, lefthalfbeforein);
        
//        /* commentable */
//        System.out.println("\n\nXOR2 output/Right Half After (Length: "+xorOutput2.length+"):");
//        for(int i: xorOutput2) {
//            System.out.print(i);   
//        }
//        
//        System.out.println("\n\nLeft Half After (Length: "+righthalfbeforein.length+"):");
//        for(int i: righthalfbeforein) {
//            System.out.print(i); 
//        }
//        /* /commentable */
 
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
    
    public static int[] finalRoundDES(int[][] in) {
        int[] lefthalfbeforein = in[0];
        int[] righthalfbeforein = in[1];
        
        // 32 bit swap
        int[] temp = righthalfbeforein;
        righthalfbeforein = lefthalfbeforein;
        lefthalfbeforein = temp;
        
        
        
        // IP Inverse
        int[] ipInverseOut = new int[64];
        for(int i=0; i<64; i++) {
            if(i>31) {
                ipInverseOut[IP_Inverse[i]-1] = righthalfbeforein[i-32];
            } else {
                ipInverseOut[IP_Inverse[i]-1] = lefthalfbeforein[i];
            }
        }
        
        return ipInverseOut;
    }
}
