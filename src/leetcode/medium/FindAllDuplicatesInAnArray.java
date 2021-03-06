package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
========================================================================
https://leetcode.com/problems/find-all-duplicates-in-an-array/
========================================================================
Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        //null and empty checks
        if(nums==null || nums.length==0)
            return result;
        
        int index;
        for(int i=0; i<nums.length; i++)
        {
            index = Math.abs(nums[i])-1;
            
            if(nums[index]<0)
                result.add(index+1);
            else
                nums[index] *= -1;
        }       
        
        return result;
        
    }
}