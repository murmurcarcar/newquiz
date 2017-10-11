package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	
	public static void main(String[] args) {
		int[] test1 = new int[] {1, 2, 2};
		ArrayList<ArrayList<Integer>> output = subsetsWithDup(test1);
		System.out.println(output);
	}
	
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null) return result;
        
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, 0, nums);
        return result;
    }
    
    private static void helper(ArrayList<ArrayList<Integer>> result, 
                    ArrayList<Integer> list, 
                    int l, 
                    int[] nums) {
        result.add(new ArrayList<Integer>(list));
        System.out.println("result: " + result);
        
        for (int i = l; i < nums.length; i ++) {
        	System.out.println("i: " + i + "; l: " + l);
            if (i != l && nums[i] == nums[i-1]) {
            	System.out.println("continue");
                continue;
            }
            list.add(nums[i]);
            
            System.out.println("add list: " + list);
          
            System.out.println("helper: ");
            
            helper(result, list, i + 1, nums);
            
            System.out.println("helper end");
            list.remove(list.size()-1);
            
            System.out.println("remove list: " + list);
        }
        
    }
}