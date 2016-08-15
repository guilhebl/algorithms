package com.guilhebl.algo.sort;

/**
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 */
public class FindKthLargest {

    public static void main(String args[])
    {
    	//3,2,1,5,6,4] and k = 2, return 5.
    	int[] a = {3,2,1,5,6,4};
    	FindKthLargest  ob = new FindKthLargest();    	
    	System.out.println(ob.findKthLargest(a, 2));
    }
    
    public int findKthLargest(int[] nums, int k) {
    	int kR = nums.length - k + 1;
    	return kthLargest(nums, 0, nums.length-1, kR); 
    }
  
	int kthLargest(int arr[], int l, int r, int k)
	    {
	        // If k is smaller than number of elements in array
	        if (k > 0 && k <= r - l + 1)
	        {
	            // Partition the array around a random element and
	            // get position of pivot element in sorted array
	            int pos = randomPartition(arr, l, r);
	 
	            // If position is same as k
	            if (pos-l == k-1)
	                return arr[pos];
	 
	            // If position is higher, recur for left subarray
	            if (pos-l > k-1)
	            	return kthLargest(arr, l, pos-1, k);	                	            		            
	 
	            // Else recur for right subarray
	            return kthLargest(arr, pos+1, r, k-pos+l-1);
	        }
	 
	        // If k is less than number of elements in array
	        return Integer.MIN_VALUE;
	    }

	 // Utility method to swap arr[i] and arr[j]
    void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Standard partition process of QuickSort().  It considers
    // the last element as pivot and moves all smaller element 
    // to left of it and greater elements to right. This function
    // is used by randomPartition()
    int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
 
    // Picks a random pivot element between l and r and 
    // partitions arr[l..r] arount the randomly picked 
    // element using partition()
    int randomPartition(int arr[], int l, int r)
    {
        int n = r-l+1;
        int pivot = (int)(Math.random()) % n;
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }
 
}
