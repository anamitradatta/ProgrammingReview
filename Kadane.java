package test;

public class Kadane 
{
	
	public static int kadane(int[] arr)
	{
		int localmax = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			localmax = Math.max(arr[i], arr[i]+localmax);
			max = Math.max(max, localmax);
		}
		return max;
	}

	public static void main(String[] args) 
	{
		int[] arr= {1,2,-3,4,-5,6,7,8,-9,10,-11};
		
		System.out.println(kadane(arr));

	}

}
