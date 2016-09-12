package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/spiral-matrix/
 *
 */
public class SpiralMatrix {
	
	public static void main(String[] args) {
		int[][] m = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }				
		};
		
		printList(spiralOrder(m));
	}
	
    private static void printList(List<Integer> spiralOrder) {
    	for (Integer i : spiralOrder) {
			System.out.print(i + " ");
		}		
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0; // east
        List<Integer> r = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        int il = 0;
        int ih = matrix.length;
        int jl = 0;
        int jh = matrix[0].length;

        while(il < ih && jl < jh) {
            // east
            if (dir == 0) {
                int k = j;
                while(k < jh) {
                    r.add(matrix[i][k]);
                    k++;
                }
                j = k-1;
                il++;
                i++;
            } 
            // south
            else if (dir == 1) {
                int k = i;
                while(k < ih) {
                    r.add(matrix[k][j]);
                    k++;
                }
                i = k - 1;
                jh--;
                j--;
            }    
            // west
            else if (dir == 2) {
                int k = j;
                while(k >= jl) {
                    r.add(matrix[i][k]);
                    k--;
                }
                j = k + 1;
                ih--;
                i--;
            }    
            // north
            else if (dir == 3) {
                int k = i;
                while(k >= il) {
                    r.add(matrix[k][j]);
                    k--;
                }
                i = k + 1;
                jl++;
                j++;
            }    
        
            dir++;
            dir = dir % 4;
        }
        return r;
    }
}
