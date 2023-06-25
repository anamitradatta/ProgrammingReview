package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UtilityAlgs 
{
	
	public static void printArray(Object[] arr)
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("Array is empty or null");
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i].toString() + " ");
		}
		System.out.println();
	}
	
	public static void printArray(String[] arr)
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
	
	public static void print2DArray(String[][] arr)
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
	
	public static void print2DArray(double[][] arr)
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
	
	public static void printStringArrayList(ArrayList<String> l)
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
	 
	public static void printIntegerArrayList(ArrayList<Integer> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
        for(int i=0;i<l.size();i++)
		{
		    System.out.print(l.get(i).toString() + " ");
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
		    System.out.print(l.get(i).toString() + " ");
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
	
	public static void print2DStringArrayList(ArrayList<ArrayList<String>> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
		for(int i=0;i<l.size();i++)
		{
		    printStringArrayList(l.get(i));
	    }
		System.out.println();
	}
	
	public static void printIntegerHashSet(HashSet<Integer> hs)
	{
		if(hs==null || hs.size()==0)
		{
		    System.out.println("HashSet is empty or null");
		}
		
		for(Integer i: hs)
		{
			 System.out.print(i.toString() + " ");
		}
	}
	
	public static void printDoubleHashSet(HashSet<Double> hs)
	{
		if(hs==null || hs.size()==0)
		{
		    System.out.println("HashSet is empty or null");
		}
		
		for(Double d: hs)
		{
			 System.out.print(d.toString() + " ");
		}
	}
	
	public static void printStringHashSet(HashSet<String> hs)
	{
		if(hs==null || hs.size()==0)
		{
		    System.out.println("HashSet is empty or null");
		}
		
		for(String s: hs)
		{
			 System.out.print(s + " ");
		}
	}
	
	public static void printArrayList(ArrayList<Object> l)
	{
		if(l==null || l.size()==0)
		{
		    System.out.println("ArrayList is empty or null");
		}
		
		for(Object o: l)
		{
			System.out.print(o.toString() + " ");
		}
	}
	
	public static void printHashSet(HashSet<Object> hs)
	{
		if(hs==null || hs.size()==0)
		{
		    System.out.println("HashSet is empty or null");
		}
		
		for(Object o: hs)
		{
			System.out.print(o.toString() + " ");
		}
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
