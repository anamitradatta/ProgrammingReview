package test;

public class KnapsackE {
	
	//Efficient implementation of knapsack algorithm using single array
	
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
		
		return m[capacity];
	}

	
	public static void main(String[] args) 
	{
		int[] values = {1,1,1,10};
		int[] weights = {3,5,4,8};
		int capacity = 8;
		
		System.out.println("Result = " + knapsackEF(values,weights,capacity));
	}
}
