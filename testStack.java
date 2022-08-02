package test;

public class testStack {

	private int top;
	private int[] s;
	private int size;
	
	public testStack(int l)
	{
		top=-1;
		s= new int[l];
		l=size;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void push(int val)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
			return;
		}
		s[top++]=val;
		
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		return s[top--];
	}
	
	public int peek()
	{
		return s[top];
	}
	
	public boolean isFull()
	{
		return top==size-1;
	}
	
	public boolean isEmpty()
	{
		return top==-1;
	}
	
	public static void main(String[] args) 
	{
		

	}

}
