package test;

public class testVector 
{
	public int[] array;
	public int size;
	
	public testVector()
	{
		array = new int[1];
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public int capacity()
	{
		return array.length;
	}
	
	public boolean isFull()
	{
		return size==capacity();
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}

	public int at(int index)
	{
		if(index>=capacity())
		{
			throw new IndexOutOfBoundsException("overindexing in at() function");
		}
		else
		{
			return array[index];
		}
	}
	
	public void push(int val)
	{
		if(size<capacity())
		{
		    array[size] = val;
		    size++;
		}
		else
		{
			resize(2*capacity());
			array[size] = val;
			size++;
		}
	}
	
	public void resize(int newCapacity)
	{
		int[] newArray = new int[newCapacity];
		System.arraycopy(array, 0, newArray, 0, capacity());
		array = newArray;
	}
	
	public void insert(int val, int index)
	{
		if(index>=capacity())
		{
			throw new IndexOutOfBoundsException("overindexing in at() function");
		}
		else
		{
			if(isFull())
			{
				resize(2*capacity());
			}
			for (int i = size; i > index; i--)
			{
			    array[i] = array[i-1];
			}
			array[index]=val;
			size++;
		}
	}
	
	public void prepend(int val)
	{
		insert(val,0);
	}
	
	public int pop()
	{
		int val = array[size];
	    array[size]=0;
	    size--;
	    return val;
	}
	
	public void delete(int index)
	{
		if(index>=capacity())
		{
			throw new IndexOutOfBoundsException("overindexing in at() function");
		}
		else
		{
			for (int i = index; i < size; i++)
			{
			    array[i] = array[i+1];
			}
			size--;
		}
	}
	
	public void remove(int val)
	{
		for(int i=0;i<size;i++)
		{
			if(array[i]==val)
			{
		        delete(i);	
			}
		}
	}
	
	public int find(int key)
	{
		for(int i=0;i<size;i++)
		{
			if(key==array[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("List is empty");
		}
		for(int i=0;i<size;i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		testVector a = new testVector();
		a.print();
		a.push(2);
		System.out.println("size:"+a.size);
		a.print();
		a.push(9);
		System.out.println("size:"+a.size);
		a.print();
		System.out.println(a.at(1));
		a.push(10);
		System.out.println("size:"+a.size);
		a.print();
		System.out.println(a.size);
		a.insert(29, 2);
		System.out.println("size:"+a.size);
		System.out.println(a.capacity());
		a.print();
		a.insert(200,3);
		System.out.println("size:"+a.size);
		a.print();
		a.delete(0);
		System.out.println("size:"+a.size);
		a.print();
		a.remove(9);
		System.out.println("size:"+a.size);
		a.print();
		a.prepend(100);
		a.print();
		System.out.println("size:"+a.size);
		System.out.println(a.find(200));
		
	}
}
