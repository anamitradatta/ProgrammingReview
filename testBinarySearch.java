package test;

public class testBinarySearch {

	public static int binarySearch(int[] arr, int start, int end, int key)
	{
		if(start>end)
		{
			return -1;
		}
		
		int middle=start+(end-start)/2;
		
		if(arr[middle]<key)
		{
			return binarySearch(arr,middle+1,end,key);
		}
		else if(key<arr[middle])
		{
			return binarySearch(arr,start,middle-1,key);
		}
		else
		{
			return middle;
		}
	}

	public static void main(String[] args) 
	{
		int[] arr = new int[] {1,2,3,4,5,6,7,8,100,1000};
		
		System.out.println(binarySearch(arr,0,arr.length-1,1000));
		
	}

}
