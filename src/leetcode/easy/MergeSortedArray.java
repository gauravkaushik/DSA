package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/merge-sorted-array/
========================================================================

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums2==null || nums2.length==0 || n==0)
            return;
        
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        
        while(k>=0 && i>=0 && j>=0)
        {
            if(nums1[i] > nums2[j])
            {
                nums1[k--] = nums1[i--];                
            }
            else
            {
                nums1[k--] = nums2[j--];
            }
        }
        
        if(k<0)
        {
            return;
        }
        if(i<0)
        {
            while(j>=0)
                nums1[k--] = nums2[j--];
        }
        else
        {
            while(i>=0)
                nums1[k--] = nums1[i--];
        }
        
    }
    
    /** Concise version : 
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }*/
}