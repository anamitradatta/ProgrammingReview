package test;

public class testHashTable {

	int[] array;
	int size;
	int capacity;
	int hash;
	
	public testHashTable(int l, int h)
	{
		size=0;
		array = new int[l];
		capacity=l;
		hash=h;
		
		for(int i=0;i<capacity;i++)
		{
			array[i]=-1;
		}
	}
	
	public static void main(String[] args) 
	{
		

	}

}
