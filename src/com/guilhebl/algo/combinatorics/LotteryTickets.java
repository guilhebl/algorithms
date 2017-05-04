package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Return all strings that can be used as a lottery ticket from an array of strings.
 * 
 * A lottery ticket is defined as having 7 elements where each element is from 1-60 
 * a lottery number can't start with 0 or have negative or invalid non-number elements.
 * 
 * all numbers from string should be used and in order. Only valid lottery numbers should be returned.
 * 
 * Solution:
 * 
 * Keep track of used numbers to avoid having duplicates and count the final solution with 7 elements
 * 
 * Recursive solution based on backtracking and DFS:
 * 
 * Each lottery ticket is composed of single digit and/or double digit numbers 
 * 
 * a lottery ticket number can have a min. of 7 elements (all single digit numbers such as 1,2,3,4,5,6,7)
 * and a max. of 14 elements (all double digit numbers such as: 10,11,12,13,14,15,16)
 * 
 * a lottery tiket is formed by : D + S 
 * 
 * where D = double digit numbers used and S = single digit numbers used. N = length of lottery ticket string. Since we need to find 7 elements then 
 * 
 *  D + S = 7, so D = N - 7 and S = 7 - D, 
 *  
 *  for example for a string of size 7: D =  7 - 7 = 0 and S = 7 - 0 = 7. So all elements should be single digit elements in that case
 *  for a string of size 12: D = 12 - 7 = 5 and S = 7 - 5 = 2. So it should have 5 double digit elements and 2 single digit elements.
 * 
 * Algorithm approach:
 * 
 * convert input string to an array of numbers and check if any invalid case is found (trailing 0, invalid non-numbers, negative numbers.)
 * 
 * for each number:
 * 
 * if number is higher than 5 (it can't be used as a first digit in case of numbers from 10-59)
 *    add number to used number array and check if a valid ticket can be obtained from index + 1
 * 
 * if number is between 1-5 (it can be used as a first digit in case of numbers from 10-59)
 *    try both possibilites: 
 *    	1. add number to used number array and check if a valid ticket can be obtained from index + 1
 *      2. create double digit number formed by the combination of number and number(index +1) add new number 
 *         to used number array and check if a valid ticket can be obtained from index + 2
 *
 * the algorithm backtracks as soon as it detects an invalid state *(not possible to complete a valid ticket with given index)
 * so it prunes branches that will not lead to a valid result. 
 * 
 * Algorithm prints valid results to standard output. 
 * 
 * 
 * Performance analysis:
 * 
 * the efficiency of this algorithm will be determined by the number of possible "branches" or combinations of possible value elements for a ticket based on the number of single and double digit numbers.  
 * For the total number of single digits for an input we can have:
 * 
 * S = single element numbers
 * D = Double digit element numbers
 * 
 * We have the max. number of possible "branches" to search in our DFS when we have a mix of single and double digit numbers for possible solutions.
 * 
 * Our best case scenario will be when we have S = 7 or D = 7 (all single or all double digit elements), and worst when S or D = 3 or 4. (max. number of mixes of single and double digit elements) 
 * 
 * Best Case: 7 C (0) = 7 C (7) =  1 possible solution. Worst Case: 7 C (3) = 7 or C (4) = 35 possible solutions.
 * 
 * Given h which is the height of our decision tree: O(h) = Best Case: h Worst case: 2^h
 * 
 * The algorithm uses backtracking in order to track invalid states in the DFS traversal and it only proceeds if a possible solution from current node can be achieved. 
 * Due to this mechanism and pruning of invalid branches the algorithm converges to an average case complexity of O(h).
 * 
 * @author gui
 *
 */
public class LotteryTickets {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			isValidLotteryTicket(args[i].toCharArray());
		}  
	}

	private static boolean isValidLotteryTicket(char[] s) {
		
		// string must be between 7 (only single elements) and 14 (all double digit elements)
		if (s.length == 0 || s.length < 7 || s.length > 14 || s[0] == '0') {
			return false;
		}						
		// transform input string into an array of integers - check for any invalid inputs such as negatives or non-numbers
		int[] nums = new int[s.length];
		try {
			for (int i = 0; i < s.length; i++) {
				nums[i] = Integer.parseInt(Character.valueOf(s[i]).toString());
				if (nums[i] < 0) return false;
			}			
		} catch (NumberFormatException nfe) {
			return false; 
		}
				
		int doubleDigitNums = nums.length - 7;
		int singleDigitNums = 7 - doubleDigitNums;
			        
		return isValidLotteryTicket(nums, new ArrayList<>(), 0, singleDigitNums, doubleDigitNums);
	}

	private static boolean isValidLotteryTicket(int[] nums, List<Integer> numsUsed, int i, int singleDigitNums, int doubleDigitNums) {				
		if (i > nums.length || numsUsed.size() > 7) {
			return false;
		}		
		else if (i == nums.length) { 
			if (numsUsed.size() == 7) {
				// stop condition check if all elements were used and lottery ticket has 7 elements.)				
				for (Integer n : numsUsed) {				
					System.out.print(n + " ");
				}				
				System.out.println();
			}
			return true;
		} 
		
		int num = nums[i];
		if (num > 5) { 			// number can only be used as a single digit in ticket, such elements are 6,7,8,9
			if (singleDigitNums <= 0 || numsUsed.contains(num)) {
				return false;
			}
			numsUsed.add(num);
			return isValidLotteryTicket(nums, new ArrayList<>(numsUsed), i + 1, singleDigitNums-1, doubleDigitNums);
		} else {
			// number can be used as a single digit or as a pair for a double digit number 10-59 try both possibilities
			boolean valid = false;
			boolean added = false;
			
			// try it as single digit
			if (singleDigitNums > 0 && !numsUsed.contains(num)) {
				numsUsed.add(num);
				added = true;
				valid = isValidLotteryTicket(nums, new ArrayList<>(numsUsed), i + 1, singleDigitNums-1, doubleDigitNums);
			}

			// try it as double digit
			if (!valid && i + 1 < nums.length && doubleDigitNums > 0) {
				if (added) numsUsed.remove(numsUsed.size() - 1);
				int doubleDigitNum = new Integer(num + "" + nums[i + 1]);
				if (!numsUsed.contains(doubleDigitNum)) {
					numsUsed.add(doubleDigitNum);
					valid = isValidLotteryTicket(nums, new ArrayList<>(numsUsed), i + 2, singleDigitNums, doubleDigitNums-1);
				}
			}
			return valid;
		}
	}

}
