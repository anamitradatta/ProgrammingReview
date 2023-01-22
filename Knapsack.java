package test;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class Knapsack {
	
	// Recursive O(2^n)
	public static int knapsackRecursive(int[] w, int[] p, int c, int index, int ps) 
	{
		if(index>=w.length || c<=0)
		{
			return ps;
		}
		
		int include=0;
		if(c>=w[index])
		{
			include = knapsackRecursive(w,p,c-w[index],index+1,ps+p[index]);
		}
		int notinclude = knapsackRecursive(w,p,c,index+1,ps);
		
		return Math.max(include,notinclude);
	}
	
	// Top down memoization O(w*c) time, O(w*c) space
	public static int KnapsackMemoization(int[] w, int[] p, int c, int index, int ps, int[][] memo) 
	{
		if(index >=w.length || c <= 0)
		{
			return ps;
		}
		if(memo[index][c]!=0)
		{ 
			return memo[index][c];
		}
		
		int include =0;
		if(c>=w[index])
		{
			include = KnapsackMemoization(w,p,c-w[index],index+1,ps+p[index],memo);
		}
		int notinclude = KnapsackMemoization(w,p,c,index+1,ps,memo);
		
		memo[index][c] = Math.max(include,notinclude);
		
		return memo[index][c];
	}

	// Efficient knapsack implementation using 1D array O(w*c), O(c) space
	public static int knapsackEF(int[] values, int[] weights, int capacity) 
	{
        int maxweight = 0;		
		for(int i: weights)
		{
			maxweight+=i;
		}
	
		int[] m = new int [maxweight+1];
		for(int x=0;x<values.length;x++)
		{
			for(int y=maxweight;y>=0;y--)
			{
				if(weights[x]<=y)
				{
					m[y] = Math.max(m[y], m[y-weights[x]]+values[x]);
				}
			}
		}
		
		
		if(capacity>maxweight)
		{
			return m[maxweight];
		}
		else
		{
			return m[capacity];
		}
	}
	
	// Efficient knapsack implementation using 2D array O(w*c) time, O(w*c) space
	public static ArrayList<Integer> knapsackF(int[] values, int[] weights, int capacity, int[] maxvalue, int[] maxcapacity)
	{
		int[][] m = new int[values.length+1][capacity+1];
		ArrayList<Integer> items = new ArrayList<Integer>();
		
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
		maxvalue[0]=m[values.length][capacity];
		
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
		
		return items;
	}
	
	public static void main(String[] args) 
	{
		int[] values = {1,6,10,16};
		int[] weights = {1,2,3,5};
		int capacity = 7;
		int[] maxvalue = new int[1];
		int[] maxcapacity = new int[1];
		
		if(values.length!=weights.length)
		{
			System.out.println("values and weights do not have the same length!");
			System.exit(-1);
		}
		
		System.out.print("Values: ");
		for(int v: values)
		{
			System.out.print(v + " ");
		}
		
		System.out.print("\nWeights: ");
		for(int w: weights)
		{
			System.out.print(w + " ");
		}
		
		System.out.println("\nCapacity = " + capacity);
		
		System.out.println("\nKnapsackRecursive:");
		int resRec = knapsackRecursive(weights,values,capacity,0,0);
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
		int resMemo = KnapsackMemoization(weights,values,capacity,0,0,memo);
		if(resMemo==0)
		{
			System.out.println("Cannot fit any items");
		}
		else
		{
		    System.out.println("Max value = " + resMemo);
		}
		
		ArrayList<Integer> items = knapsackF(values,weights,capacity, maxvalue, maxcapacity);
		int resF = maxvalue[0];
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
		
		System.out.println();
		if(UtilityAlgs.allEqual(resRec,resMemo,resF,resEF))
		{
			System.out.println("\u001B[32m" + "SUCCESS: All results are equal (" + resRec + ")" + " \u001B[0m");
		}
		else
		{
			System.out.println("\u001B[31m"+ "FAIL: Not all results are equal" + "\u001B[0m");
			System.out.println("\u001B[31m"+"resRec=" + resRec + " resMemo="+resMemo + " resF=" + resF + " resEF=" + resEF + "\u001B[0m" );
		}
	}

}
