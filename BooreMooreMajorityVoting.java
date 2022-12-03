package test;

public class BooreMooreMajorityVoting 
{
	public static int booremoore(int[] arr)
	{
		int el = 0;
		int count = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(count==0)
			{
				el = arr[i];
				count = 1;
			}
			else if(arr[i] == el)
			{
				count++;
			}
			else
			{
				count--;
			}
		}
		
		return el;
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {1,2,5,3,5,5,5,5,5,5,5,5,5,3,4,4,5,5,5,6,4,4,4,5,5,4,4,3,3,3,3,5,3};
		
		System.out.println(booremoore(arr));
	}

}
