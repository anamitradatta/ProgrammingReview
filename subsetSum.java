package test;
import java.io.*;
public class subsetSum {
	
	// Recursive O(2^n)
	public static void subsetSumR(int[] arr, int index, int sum, int target,int[] count)
	{
		if(sum==target) count[0]+=1;
		
		if(index==arr.length)
		{
			return;
		}
		
		for(int i=index;i<arr.length;i++)
		{
			subsetSumR(arr,i+1,sum+arr[i],target,count);
		}
	}
	
	// Standard Knapsack implementation O(t*n)
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
	
	// Efficient Knapsack implementation O(t*n) using 1D array with max length = target 
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
	
	// Efficient Knapsack implementation O(t*n) using 1D array with max length = max sum
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
		int[] arr = {1,3,3,7,2,3,2,1};
		int max = 0;
		for(int n: arr)
		{
			max+=n;
		}
		
		System.out.println("Array: ");
		UtilityAlgs.printArray(arr);
		
		for(int i=0;i<=max;i++)
		{
			System.out.println("\ntarget = " + i);
			
			int[] resR=new int[1];
			subsetSumR(arr,0,0,i,resR);
			System.out.println("resR= " + resR[0]);
			
			int resEFm=subsetSumEF(arr,i,max);
			System.out.println("resEF (max)= " + resEFm);
			
			int resEF=subsetSumEF(arr,i);
			System.out.println("resEF= " + resEF);
			
			int resF=subsetSumF(arr,i);
			System.out.println("resF= " + resF);
			
			if(UtilityAlgs.allEqual(resR[0],resEFm,resEF,resF))
			{
				System.out.println("\u001B[32m" + "SUCCESS: All results are equal (" + resR[0] + ")" + " \u001B[0m");
			}
			else
			{
				System.out.println("\u001B[31m"+ "FAIL: Not all results are equal" + "\u001B[0m");
				System.out.println("\u001B[31m"+"resR=" + resR[0] + " resEFm="+resEFm + " resEF=" + resEF + " resF=" + resF + "\u001B[0m" );
			}
		}
	
	}

}
