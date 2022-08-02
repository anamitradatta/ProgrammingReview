package test;

public class testQueue {
	
	private int size=0;
	private int capacity;
	private int[] array;
	
	public testQueue(int l)
	{
		size=0;
		array = new int[l];
		capacity=l;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public boolean isFull()
	{
		return size==capacity;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public void push(int val)
	{
		if(!isFull())
		{
			array[size++] = val;
		}
		else
		{
			System.out.println("Queue is full");
		}
	}
	
	public int pop()
	{
		if(!isEmpty())
		{
			int val = array[0];
			for(int i=0;i<size;i++)
			{
				if(i!=size)
				{
				    array[i]=array[i+1];
				}
				else
				{
					array[i]=0;
				}
			}
			size--;
			return val;
		}
		else
		{
			System.out.println("Queue is empty");
			return -1;
		}
	}
	
	public int peek()
	{
		if(!isEmpty())
		{
			return array[0];
		}
		else
		{
			System.out.println("Queue is empty");
			return -1;
		}
	}
	
	public void print()
	{
		if(!isEmpty())
		{
			for(int i=0;i<size;i++)
			{
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
		else
		{
			System.out.println("Queue is empty");
		}
	}
	

	public static void main(String[] args) 
	{
		testQueue q = new testQueue(5);
		q.push(4);
		q.print();
		q.push(7);
		q.print();
		q.push(8);
		q.print();
		q.push(70);
		System.out.println(q.pop());
		q.print();


	}

}
