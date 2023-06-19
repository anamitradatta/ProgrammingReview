package test;

public class testBinarySearch {

	// Recursive - binary Search Zero - find index, if key not in array, return -1
	// Zero - finds index if possible (zero indices end con)
	public static int binarySearchZero_Rec(int[] arr, int start, int end, int target)
	{
		if(arr==null || arr.length==0) return -1;
		
		if(start>end)
		{
			return -1;
		}
		
		int middle=start+(end-start)/2;
		
		if(arr[middle]<target)
		{
			return binarySearchZero_Rec(arr,middle+1,end,target);
		}
		else if(target<arr[middle])
		{
			return binarySearchZero_Rec(arr,start,middle-1,target);
		}
		else
		{
			return middle;
		}
	}
	
	// Iterative - binary Search Zero - find index, if key not in array, return -1
	// Zero - finds index if possible (zero indices end con)
	public static int binarySearchZero_It(int[] arr, int start, int end, int target)
	{
		if(arr==null || arr.length==0) return -1;
		
		while(start<=end)
		{
			int middle = start + (end-start)/2;
			
			if(arr[middle] < target)
			{
				start = middle + 1;
			}
			else if(arr[middle]>target)
			{
				end = middle - 1;
			}
			else
			{
				return middle;
			}
		}
		return -1;
	}
	
	// Iterative - binary Search One - find index with one remaining index
	// One - gets one index, if condition not met, returns -1 (one index end con)
	public static int binarySearchOne_It(int[] arr, int start, int end, int target) 
	{
		if(arr==null || arr.length==0) return -1;
		
	    while (start < end) 
	    {
	    	int mid = start + (end - start)/2;
	    	if (arr[mid] > target) 
	    	{
	    		end = mid;
	    	}
	    	else if (arr[mid] < target)
	    	{
	    		start = mid + 1;
	    	}
	    	else
	    	{
	    		return mid;
	    	}
	    }
	    
	    // end==start
	    if(start < arr.length && start>=0 && arr[start]==target)
	    {
	    	return start;
	    }
	    else
	    {
	    	return -1;
	    }
	}
	
	// Iterative - binary Search Two - find index with two remaining indices
	// Two - gets two indices, if condition not met, returns -1 (two index end con)
	public static int binarySearchTwo_It(int[] arr, int start, int end, int target) 
	{
		if(arr==null || arr.length==0) return -1;
			
		while(start+1<end)
		{
			int mid = start + (end - start)/2;
			if(arr[mid] < target)
			{
				start = mid;
			}
			else if(arr[mid] > target)
			{
				end = mid;
			}
			else
			{
				return mid;
			}
		}
		
		if(start < arr.length && start>=0 && arr[start]==target)
	    {
	    	return start;
	    }
		if(end < arr.length && end>=0 && arr[end]==target)
	    {
	    	return end;
	    }
		return -1;
		
	}
	
	// Iterative - binary Search Two - find index with two remaining indices
	// Two - gets two indices, if condition not met, returns -1 (two index end con)
	// can also add 1 to midpoint calc for window sizes of two for normal check
	// if +1 is not added, it will result in infinite loop
	public static int binarySearchTwoAlt_It(int[] arr, int start, int end, int target) 
	{
		if(arr==null || arr.length==0) return -1;
				
		while(start<end)
		{
			int mid = start + (end - start + 1)/2;
			if(arr[mid] < target)
			{
				start = mid;
			}
			else if(arr[mid] > target)
			{
				end = mid;
			}
			else
			{
				return mid;
			}
		}
			
		if(end < arr.length && end>=0 && arr[end]==target)
	    {
	    	return end;
	    }
		return -1;
		
	}
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {-203,-102,-10,1,2,5,18,22,27,100,101,114,700};
		
		int num=101;
		
		if(!UtilityAlgs.arrayIsSorted(arr)) 
		{ 
			System.out.println("array is not sorted");
			System.exit(0);
		}
		
		System.out.println("Recursive binary Search (zero indices end con) = " + binarySearchZero_Rec(arr,0,arr.length-1,num));
		System.out.println("Iterative binary Search (zero indices end con) = " + binarySearchZero_It(arr,0,arr.length-1,num));
		System.out.println("Iterative binary Search (one index end con) = " + binarySearchOne_It(arr,0,arr.length-1,num));
		System.out.println("Iterative binary Search (two indices end con) = " + binarySearchTwo_It(arr,0,arr.length-1,num));
		System.out.println("Iterative binary Search (two indices alt end con) = " + binarySearchTwoAlt_It(arr,0,arr.length-1,num));
	}

}
