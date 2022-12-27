package test;

import java.util.Random;

public class testSorting {
	
	static Random r = new Random();

	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	public static void bubbleSort(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
				    swap(arr,j,j+1);
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
		    int temp=arr[i];
			int j;
			for(j=i-1;j>=0 && temp<arr[j];j--)
			{
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
	}
	
	public static void selectionSort(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			int minIndex=i;
			
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[minIndex])
				{
					minIndex=j;
				}
			}
			swap(arr,minIndex,i);
		};
	}
	
	public static void shellSort(int arr[]) 
	{

		for (int gap = arr.length/2; gap > 0; gap /= 2) 
		{
		     for (int i = gap; i < arr.length; i++) 
		     {
		         int temp = arr[i];
		         int j;
		         for (j=i; j >= gap && temp<arr[j - gap]; j=j-gap) 
		         {
		             arr[j] = arr[j - gap];
		         }
		         arr[j] = temp;
		     }
		 }
	}
	
	public static void mergeSort(int[] a, int n) 
	{
	    if (n < 2) 
	    {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) 
	    {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) 
	    {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
	}
	
	public static void merge(int[] a, int[] l, int[] r, int left, int right) 
	{
	    int i = 0, j = 0, k = 0;
		while (i < left && j < right) 
		{
		    if (l[i] <= r[j]) 
		    {
		        a[k++] = l[i++];
	    	}
		    else 
		    {
		        a[k++] = r[j++];
	    	}
	    }
		while (i < left) 
		{
		    a[k++] = l[i++];
		}
		while (j < right) 
		{
		    a[k++] = r[j++];
		}
	}
	
	public static void quickSort(int arr[], int begin, int end) 
	{
	    if (begin < end) 
	    {
	        int partitionIndex = partition(arr, begin, end);
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private static int partition(int arr[], int begin, int end)
	{
		// choose end index as the pivot
		//int pivot = arr[end];
		
        // Choose a random pivot
        int rpivot = r.nextInt(end - begin) + begin;
        swap(arr,rpivot,end);
        rpivot =end;
		int pivot = arr[rpivot];
		
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) 
	    {
	        if (arr[j] <= pivot)
	        {
	            i++;
	            swap(arr,i,j);
	        }
	    }
	    swap(arr,i+1,end);
	    
	    return i+1;
	}
	
	public static void heapSort(int arr[])
    {
        // Build heap (rearrange array)
        for (int i = arr.length / 2 - 1; i >= 0; i--)
        {
            heapify(arr, arr.length, i);
        }
        // One by one extract an element from heap
        for (int i=arr.length-1; i>=0; i--)
        {
            // Move current root to end
            swap(arr,0,i);
  
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
  
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
  
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
        {
            largest = l;
        }
        
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
        {
        	largest = r;
        }
        // If largest is not root
        if (largest != i)
        {
            swap(arr,i,largest);
  
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
	public static void print(int[] arr)
	{
		if(arr.length==0)
		{
			System.out.println("Array is empty");
		}
		else
		{
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		
		int[] a = new int[] {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		long s = System.nanoTime();
		quickSort(a,0,a.length-1);
		long e =System.nanoTime();
		System.out.println("Time taken (quick sort): "+ (e-s) +" nanoseconds");
		
		a = new int[]  {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		s = System.nanoTime();
		heapSort(a);
		e =System.nanoTime();
		System.out.println("Time taken (heap sort): "+ (e-s) +" nanoseconds");
		
		a = new int[]  {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		s = System.nanoTime();
		mergeSort(a,a.length);
		e =System.nanoTime();
		System.out.println("Time taken (merge sort): "+ (e-s) +" nanoseconds");
		
		a = new int[]  {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		s = System.nanoTime();
		shellSort(a);
		e =System.nanoTime();
		System.out.println("Time taken (shell sort): "+ (e-s) +" nanoseconds");
		
		a = new int[]  {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		s = System.nanoTime();
		selectionSort(a);
		e =System.nanoTime();
		System.out.println("Time taken (selection sort): "+ (e-s) +" nanoseconds");
		
		a = new int[]  {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		s = System.nanoTime();
		insertionSort(a);
		e =System.nanoTime();
		System.out.println("Time taken (insertion sort): "+ (e-s) +" nanoseconds");
		
		a = new int[]  {3,1,9,2,4,5,6,7,10,200,15,11,12,-1,18,199,99};
		s = System.nanoTime();
		bubbleSort(a);
		e =System.nanoTime();
		System.out.println("Time taken (bubble sort): "+ (e-s) +" nanoseconds");
		
	}

}
