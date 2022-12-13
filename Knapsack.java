package test;

import java.util.ArrayList;
import java.util.Collections;

public class Knapsack {

	public static ArrayList<Integer> knapsack(int[] values, int[] weights, int capacity, int[] maxvalue, int[] maxcapacity)
	{
		int[][] m = new int[values.length+1][capacity+1];
		ArrayList<Integer> items = new ArrayList<Integer>();
		for(int i=0;i<m[0].length;i++)
		{
			m[0][i] = 0;
		}
		
		for(int j=0;j<m.length;j++)
		{
			m[j][0] = 0;
		}
		
		for(int x=1;x<=values.length;x++)
		{
			for(int y=0;y<=capacity;y++)
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
		int[] values = {2,6,5,100};
		int[] weights = {3,5,4,8};
		int capacity = 8;
		int[] maxvalue = new int[1];
		int[] maxcapacity = new int[1];
		ArrayList<Integer> items = knapsack(values,weights,capacity, maxvalue, maxcapacity);
		
		Collections.sort(items);
		
		if(maxvalue[0]!=0 && items.size()!=0 && maxcapacity[0]!=0)
		{
			System.out.println("Max value = " + maxvalue[0]);
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
	}

}
