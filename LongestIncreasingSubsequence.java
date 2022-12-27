package test;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public static int recursiveLIS(int[] nums, int i, int prev) 
    {   
        if(i >= nums.length) 
        {
            return 0; // cant pick any more elements
        }
        
        int take = 0;
        int dontTake = recursiveLIS(nums, i + 1, prev); // try skipping the current element
        
        if(nums[i] > prev) 
        {
            take = 1 + recursiveLIS(nums, i + 1, nums[i]); // or pick it if it is greater than previous picked element
        }
        
        return Math.max(take, dontTake); // return whichever choice gives max LIS   
    }
	
	public static int dpLISTopDown(int[] nums)
	{
		if(nums.length==1)
        {
            return 1;
        }
        
        int[] arr = new int[nums.length];
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int j=nums.length-2;j>=0;j--)
        {
            for(int k=j+1;k<nums.length;k++)
            {
                if(nums[j]<nums[k])
                {
                    arr[j]=Math.max(arr[j],1+arr[k]);
                }
                max = Math.max(max,arr[j]);
            }
        }
        
        return max;
	}
	
	public static int dpLISBottomUp(int[] nums)
	{
		if(nums.length==1)
        {
            return 1;
        }
        
        int[] arr = new int[nums.length];
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int j=1;j<nums.length;j++)
        {
            for(int k=0;k<j;k++)
            {
                if(nums[j]>nums[k])
                {
                    arr[j]=Math.max(arr[j],1+arr[k]);
                }
                max = Math.max(max,arr[j]);
            }
        }
        
        return max;
	}
	
	 public static int binarySearchLIS(int[] nums) 
	 {   
		 int[] arr = new int[nums.length];
	     int size = 0;
	        
	     for(int i=0;i<nums.length;i++)
	     {
	         if(size==0)
	         {
	             arr[0] = nums[i];
	             size++;
	             continue;
	         }
	            
	         if(nums[i]>arr[size-1])
	         {
	             arr[size] = nums[i];
	             size++;
	             continue;
	         }
	         else
	         {
	        	 // Using API Binary Search:
	             //int index = Arrays.binarySearch(arr,0,size,nums[i]);
	        	 //if(index<0) index = (index+1)*-1;
	        	 
	             int index = binarySearchIndex(arr,0,size-1,nums[i]);
	             arr[index] = nums[i];
	             continue;
	         }
	     }
	        
	     return size;
	}
	 
	public static int binarySearchIndex(int[] arr, int start, int end, int target) 
	{
	    while (start < end) 
	    {
	    	int mid = start + (end - start)/2;
	    	if (arr[mid] >= target) 
	    	{
	    		end = mid;
	    	}
	    	else 
	    	{
	    		start = mid + 1;
	    	}
	    }
	    return end;
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {1,4,7,8,9,10,2,5};
		System.out.println("recursive = " + recursiveLIS(arr, 0, Integer.MIN_VALUE));
		System.out.println("top down = " + dpLISTopDown(arr));
		System.out.println("bottom up = " + dpLISBottomUp(arr));
		System.out.println("binary search = " + binarySearchLIS(arr));

	}

}
