package test;

public class subsetSum {
	
	// Standard Knapsack implementation
	public static int subsetSumF(int[] arr, int target)
	{
		int[][] m = new int[arr.length+1][target+1];
		m[0][0] = 1;
		
		for(int i=1;i<=target;i++)
		{
			m[0][i]=0;
		}
		
		for(int j=1;j<=arr.length;j++)
		{
			m[j][0]=0;
		}
		
		for(int x=1;x<=arr.length;x++)
		{
			for(int y=0;y<=target;y++)
			{
				if(arr[x-1]<=y)
				{
					m[x][y] = m[x-1][y] + m[x-1][y-arr[x-1]];
				}
				else
				{
					m[x][y] = m[x-1][y];
				}
			}
		}
		
		return m[arr.length][target];
	}
	
	// Efficient Knapsack implementation using 1D array with max length = target
	public static int subsetSumEF(int[] arr, int target)
	{
		int[] m = new int [target+1];
		m[0]=1;
		for(int x=0;x<arr.length;x++)
		{
			for(int y=target;y>=0;y--)
			{
				if(arr[x]<=y)
				{
					m[y] += m[y-arr[x]];
				}
			}
		}
		
		return m[target];
	}
	
	// Efficient Knapsack implementation using 1D array with max length = max sum
	public static int subsetSumEF(int[] arr, int target,int max)
	{
		int[] m = new int [max+1];
		m[0]=1;
		int maxv = 0;
		for(int x=0;x<arr.length;x++)
		{
			for(int y=maxv;y>=0;y--)
			{
				m[arr[x]+y] += m[y];
			}
			maxv += arr[x];
		}
		
		return m[target];
	}

	public static void main(String[] args) 
	{
		int[] arr = {1,3,3,4,8,1};
		int max = 0;
		for(int n: arr)
		{
			max+=n;
		}
		
		for(int i=0;i<=max;i++)
		{
			System.out.println("target = " + i);
			System.out.println("res1= " + subsetSumEF(arr,i,max));
			System.out.println("res2= " + subsetSumEF(arr,i));
			System.out.println("res3= " + subsetSumF(arr,i));
		}
	}

}
