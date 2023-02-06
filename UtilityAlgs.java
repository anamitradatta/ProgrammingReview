package test;

import java.util.ArrayList;
import java.util.Arrays;

public class UtilityAlgs 
{
	public static void printArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	 public static void print2DArray(int[][] arr)
	 {
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
	 
	 public static void printArrayList(ArrayList<Integer> l)
	 {
         for(int i=0;i<l.size();i++)
		 {
		     System.out.print(l.get(i) + " ");
	     }
		 System.out.println();
	 }
	 
	 public static void print2DArrayList(ArrayList<ArrayList<Integer>> l)
	 {
		 for(int i=0;i<l.size();i++)
		 {
		     printArrayList(l.get(i));
	     }
		 System.out.println();
	 }
	 
	 public static void fillArray(int[] arr, int val)
	 {
		 Arrays.fill(arr, val);	
	 }
	 
	 public static void fillArray(int[][] arr, int val)
	 {
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
}
