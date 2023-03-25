package test;

import java.util.ArrayList;
import java.util.Arrays;

public class UtilityAlgs 
{
	public static void printArray(int[] arr)
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(double[] arr) 
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void print2DArray(int[][] arr)
	{
		if(arr==null || arr.length==0)
		{
		    System.out.println("Array is empty or null");
		}
		 
	    for(int i=0;i<arr.length;i++)
	    {
	        for(int j=0;j<arr[i].length;j++)
	        {
	            System.out.print(arr[i][j] + " ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
	 
	public static void printIntegerArrayList(ArrayList<Integer> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
        for(int i=0;i<l.size();i++)
		{
		    System.out.print(l.get(i) + " ");
	    }
		System.out.println();
	}
	
	public static void printDoubleArrayList(ArrayList<Double> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
        for(int i=0;i<l.size();i++)
		{
		    System.out.print(l.get(i) + " ");
	    }
		System.out.println();
	}
	 
	public static void print2DIntegerArrayList(ArrayList<ArrayList<Integer>> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
		for(int i=0;i<l.size();i++)
		{
		    printIntegerArrayList(l.get(i));
	    }
		System.out.println();
	}
	
	public static void print2DDoubleArrayList(ArrayList<ArrayList<Double>> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
		for(int i=0;i<l.size();i++)
		{
		    printDoubleArrayList(l.get(i));
	    }
		System.out.println();
	}
	 
	public static void fillArray(int[] arr, int val)
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
		Arrays.fill(arr, val);	
	}
	 
	public static void fillArray(int[][] arr, int val)
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
	    for(int[] a: arr)
		{
			Arrays.fill(a, val);	
		}
	}
	 
	public static boolean allEqual(int checkValue, int... otherValues)
	{
		for (int value : otherValues)
		{
		    if (value != checkValue)
		    {
		        return false;
		    }
	    }
		return true;
	}
	
	public static boolean arrayIsSorted(int[] arr) 
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
		for (int i = 0; i < arr.length-1; i++) 
		{
			if (arr[i] > arr[i + 1]) 
			{
				return false; 
		    }
		}

		return true;
	}
	
	public static boolean arrayIsSorted(double[] arr) 
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
		for (int i = 0; i < arr.length-1; i++) 
		{
			if (Double.compare(arr[i],arr[i+1]) > 0) 
			{
				return false; 
		    }
		}

		return true;
	}
}
