package test;

import java.util.ArrayList;
import java.util.List;

public class BoyerMoore {

	// Boyer Moore Algorithm to find element with majority > N/2
	public static int boyerMooreHalf(int[] arr)
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
	
	// Boyer Moore Algorithm to find element(s) with majority > N/3
	public static List<Integer> boyerMooreThird(int[] nums) 
    {
        int num1 = Integer.MIN_VALUE;
        int num1c = 0;
        int num2 = Integer.MIN_VALUE;
        int num2c = 0;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==num1)
            {
                num1c++;
            }
            else if(nums[i]==num2)
            {
                num2c++;
            }
            else if(num1c==0)
            {
                num1=nums[i];
                num1c=1;
            }
            else if(num2c==0)
            {
                num2=nums[i];
                num2c=1;
            }
            else
            {
                num1c--;
                num2c--;
            }
        }
        
        int num1cf = 0;
        int num2cf = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==num1)
            {
                num1cf++;
            }
            else if(nums[i]==num2)
            {
                num2cf++;
            }
        }
        
        if((double) num1cf > Math.floor(nums.length/3)) res.add(num1);
        if((double) num2cf > Math.floor(nums.length/3)) res.add(num2);
        
        return res;
    }
	
	public static void main(String[] args) 
	{
		int[] arr = {1,2,2,3,3,2,3,3,3};
		
		System.out.println(boyerMooreHalf(arr));
		
		List<Integer> res = boyerMooreThird(arr);
		
		for(Integer i: res)
		{
			System.out.print(i.intValue() + " ");
		}
		
	}

}
