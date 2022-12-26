package test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class testBinarySearch {

	// Recursive
	public static int binarySearchRec(int[] arr, int start, int end, int key)
	{
		if(start>end)
		{
			return -1;
		}
		
		int middle=start+(end-start)/2;
		
		if(arr[middle]<key)
		{
			return binarySearchRec(arr,middle+1,end,key);
		}
		else if(key<arr[middle])
		{
			return binarySearchRec(arr,start,middle-1,key);
		}
		else
		{
			return middle;
		}
	}
	
	// Iterative
	public static int binarySearchIt(int[] arr, int start, int end, int key)
	{
		while(start<=end)
		{
			int middle = start + (end-start)/2;
			
			if(arr[middle] < key)
			{
				start = middle + 1;
			}
			else if(arr[middle]>key)
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
	
	// Find Proper Index to place element before/at
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
		int[] arr = new int[] {1,2,3,4,5,6,7,8,100,1000};
		
		System.out.println("Recursive = " + binarySearchRec(arr,0,arr.length-1,1000));
		System.out.println("Iterative = " + binarySearchIt(arr,0,arr.length-1,1000));
		System.out.println("Index = " + binarySearchIndex(arr,0,arr.length-1,99));
		
		
	}

}
