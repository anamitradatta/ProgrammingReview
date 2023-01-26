package test;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class Knapsack {
	
	// Unbound knapsack Recursive O(2^(n+c))
	public static int knapsackURecursive(int[] w, int[] p, int c, int index) 
	{
		if(index>=w.length || c<=0)
		{
			return 0;
		}
		
		int include=0;
		if(c>=w[index])
		{
			include = p[index] + knapsackURecursive(w,p,c-w[index],index);
		}
		int notinclude = knapsackURecursive(w,p,c,index+1);
		
		return Math.max(include,notinclude);
	}
	
	
	// Top down unbound memoization O(w*c) time, O(w*c) space
	public static int KnapsackUMemoization(int[] w, int[] p, int c, int index, int[][] memo) 
	{
		if(index>=w.length || c<=0)
		{
			return 0;
		}
		
	    if(memo[index][c]==-1) 
	    {
	    	int include = 0;
	        if(w[index]<=c)
	        { 
	    	    include = p[index] + KnapsackUMemoization(w,p,c-w[index],index,memo);
	        }
	      
	        int notinclude = KnapsackUMemoization(w,p,c,index+1,memo);

	        memo[index][c] = Math.max(include,notinclude);
	    }

	    return memo[index][c];
	}
	
	// Efficient knapsack unbound implementation using 2D array O(w*c) time, O(w*c) space
	public static int knapsackUF(int[] values, int[] weights, int capacity)
	{
		int[][] m = new int[values.length][capacity+1];
			
		for(int x=0;x<values.length;x++)
		{
			for(int y=1;y<=capacity;y++)
			{
				int include=0;
				if(weights[x]<=y)
				{
					include= values[x] + m[x][y-weights[x]];
				}
				
				int notinclude=0;
				if(x>0)
				{
					notinclude = m[x-1][y];
				}
				
				m[x][y]=Math.max(include, notinclude);
			}
		}
		
		return m[values.length-1][capacity];
	}
	
	// Efficient knapsack unbound implementation using 1D array O(w*c) time, O(c) space
	public static int knapsackUEF(int[] values, int[] weights, int capacity)
	{
		int[] m = new int[capacity+1];
				
		for(int x=0;x<values.length;x++)
		{
			for(int y=1;y<=capacity;y++)
			{
				if(weights[x]<=y)
				{
					m[y]=Math.max(values[x] + m[y-weights[x]], m[y]);
				}
			}
		}
			
		return m[capacity];
	}
	
	// Recursive O(2^n)
	public static int knapsackRecursive(int[] w, int[] p, int c, int index) 
	{
		if(index>=w.length || c<=0)
		{
			return 0;
		}
		
		int include=0;
		if(c>=w[index])
		{
			include = p[index] + knapsackRecursive(w,p,c-w[index],index+1);
		}
		int notinclude = knapsackRecursive(w,p,c,index+1);
		
		return Math.max(include,notinclude);
	}
	
	// Top down memoization O(w*c) time, O(w*c) space
	public static int KnapsackMemoization(int[] w, int[] p, int c, int index, int[][] memo) 
	{
		if(index >=w.length || c <= 0)
		{
			return 0;
		}
		if(memo[index][c]!=-1)
		{ 
			return memo[index][c];
		}
		
		int include =0;
		if(c>=w[index])
		{
			include = p[index] + KnapsackMemoization(w,p,c-w[index],index+1,memo);
		}
		int notinclude = KnapsackMemoization(w,p,c,index+1,memo);
		
		memo[index][c] = Math.max(include,notinclude);
		
		return memo[index][c];
	}

	// Efficient knapsack implementation using 1D array O(w*c), O(c) space
	public static int knapsackEF(int[] values, int[] weights, int capacity) 
	{
		int[] m = new int [capacity+1];
		for(int x=0;x<values.length;x++)
		{
			for(int y=capacity;y>0;y--)
			{
				if(weights[x]<=y)
				{
					m[y] = Math.max(m[y], m[y-weights[x]]+values[x]);
				}
			}
		}
		
		return m[capacity];
	}
	
	// Efficient knapsack implementation using 2D array O(w*c) time, O(w*c) space
	public static int knapsackF(int[] values, int[] weights, int capacity, int[] maxcapacity, ArrayList<Integer> items)
	{
		int[][] m = new int[values.length+1][capacity+1];
		
		for(int x=1;x<=values.length;x++)
		{
			for(int y=1;y<=capacity;y++)
			{
				if(weights[x-1] > y)
				{
					m[x][y] = m[x-1][y];
				}
				else
				{
					m[x][y] = Math.max(m[x-1][y], m[x-1][y-weights[x-1]] + values[x-1]);
				}
			}
		}
		
		// Return list of items chosen
		int total = m[values.length][capacity];
		
		while(total>0)
		{
			for(int c=m.length-1;c>0;c--)
			{			
				for(int l=0;l<m[c].length;l++)
				{
					if(total==m[c][l])
					{
						if(m[c-1][l]==total)
						{
							break;
						}
						else
						{
							items.add(c-1);
							maxcapacity[0]+= weights[c-1];
							total = total - values[c-1];
							break;
						}
					}
				}
			}
		}
		
		return m[values.length][capacity];
	}
	
	public static void main(String[] args) 
	{
		int[] values = {1,2,4,5};
		int[] weights = {1,2,3,6};
		int capacity = 25;
		
		if(values.length!=weights.length)
		{
			System.out.println("values and weights do not have the same length!");
			System.exit(-1);
		}
		
		System.out.print("Values: ");
		UtilityAlgs.printArray(values);
		
		System.out.print("Weights: ");
		UtilityAlgs.printArray(weights);
		
		System.out.println("Capacity = " + capacity);
		
		System.out.println("\n\t0/1 Knapsack:");
		
		System.out.println("\nKnapsackRecursive:");
		int resRec = knapsackRecursive(weights,values,capacity,0);
		if(resRec==0)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
		    System.out.println("Max value = " + resRec);
		}
		
		System.out.println("\nKnapsackMemoization:");
		int [][] memo = new int[weights.length][capacity+1];
		UtilityAlgs.fillArray(memo, -1);
		int resMemo = KnapsackMemoization(weights,values,capacity,0,memo);
		if(resMemo==0)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
		    System.out.println("Max value = " + resMemo);
		}
		
		int[] maxcapacity = new int[1];
		ArrayList<Integer> items=new ArrayList<Integer>();
		int resF = knapsackF(values,weights,capacity, maxcapacity,items);
		
		Collections.sort(items);
		System.out.println("\nKnapsackF:");
		if(resF!=0 && items.size()!=0 && maxcapacity[0]!=0)
		{
			System.out.println("Max value = " + resF);
			System.out.println("Max capacity = " + maxcapacity[0] + " out of " + capacity);
			System.out.println("Items chosen:");
			for(Integer i: items)
			{
				System.out.println("Index = " + i + " value = " + values[i] + " weight = " + weights[i]);
			}
		}
		else
		{
			System.out.println("Cannot fit any items");
		}
		
		System.out.println("\nKnapsackEF:");
		int resEF = knapsackEF(values,weights,capacity);
		if(0==resEF)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
			System.out.println("Max value = " + resEF);
		}
		
		if(UtilityAlgs.allEqual(resRec,resMemo,resF,resEF))
		{
			System.out.println("\u001B[32m" + "SUCCESS: All results are equal (" + resRec + ")" + " \u001B[0m");
		}
		else
		{
			System.out.println("\u001B[31m"+ "FAIL: Not all results are equal" + "\u001B[0m");
			System.out.println("\u001B[31m"+"resRec=" + resRec + " resMemo="+resMemo + " resF=" + resF + " resEF=" + resEF + "\u001B[0m" );
		}
		
		System.out.println("\n\tUnbound knapsack:");
		
		System.out.println("\nknapsackURecursive:");
		int resURec = knapsackURecursive(weights,values,capacity,0);
		if(resURec==0)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
		    System.out.println("Max value = " + resURec);
		}
		
		System.out.println("\nKnapsackUMemoization:");
		int [][] memoU = new int[weights.length][capacity+1];
		UtilityAlgs.fillArray(memoU, -1);
		int resUMemo = KnapsackUMemoization(weights,values,capacity,0,memoU);
		if(resUMemo==0)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
		    System.out.println("Max value = " + resUMemo);
		}
		
		int resUF = knapsackUF(values,weights,capacity);
		System.out.println("\nKnapsackUF:");
		if(resUF==0)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
			System.out.println("Max value = " + resUF);
		}
		
		System.out.println("\nKnapsackUEF:");
		int resUEF = knapsackUEF(values,weights,capacity);
		if(0==resUEF)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
			System.out.println("Max value = " + resUEF);
		}
		
		if(UtilityAlgs.allEqual(resURec,resUMemo,resUF,resUEF))
		{
			System.out.println("\u001B[32m" + "SUCCESS: All results are equal (" + resURec + ")" + " \u001B[0m");
		}
		else
		{
			System.out.println("\u001B[31m"+ "FAIL: Not all results are equal" + "\u001B[0m");
			System.out.println("\u001B[31m"+"resURec=" + resURec + " resUMemo="+resUMemo + " resUF=" + resUF + " resUEF=" + resUEF + "\u001B[0m" );
		}
		
	}

}
