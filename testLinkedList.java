package test;

public class testLinkedList {
	
	public class Node
    {
        private int val;
        private Node next;
       
        public Node()
        {
            val=0;
            next=null;
        }
       
        public Node(int v)
        {
            val=v;
            next=null;
        }
       
        public Node(int v, Node n)
        {
            val=v;
            next=n;
        }
       
        public void setVal(int v)
        {
            val=v;
        }
       
        public int getVal()
        {
            return val;
        }
       
        public Node getNext()
        {
            return next;
        }
        
        public void setNext(Node n)
        {
            next=n;
        }
        
        public void setNext(int v)
        {
            next=new Node(v);
        }
    }
    
    int size;
    Node head;
    
    public testLinkedList()
    {
        size=0;
        head=null;
    }
    
    public testLinkedList(int val)
    {
        size=1;
        head=new Node(val);
    }
    
    public testLinkedList(Node n)
    {
        size=1;
        head=n;
    }
    
    public testLinkedList(int v1, int v2)
    {
        size=2;
        head=new Node(v1,new Node(v2));
    }
    
    public testLinkedList(Node n1, int v2)
    {
        size=2;
        head=n1;
        head.next = new Node(v2);
    }
    
    public testLinkedList(int v1, Node n2)
    {
        size=2;
        head=new Node(v1,n2);
    }
    
    public testLinkedList(Node n1, Node n2)
    {
        size=2;
        head=n1;
        head.next = n2;
    }
    
    public int getSize()
    {
    	return size;
    }
    
    public boolean isEmpty()
    {
    	return size==0;
    }
    
    public Node getHead()
    {
    	return head;
    }
    
 public int get(int index) {
        
        if(index>=size || head==null)
        {
            return -1;
        }
        
        Node n = head;
        for(int i=0;i<size;i++)
        {
            if(i==index)
            {
                return n.getVal();
            }
            else
            {
                n = n.getNext();
            }
        }
        return -1;
    }
 
 public void addAtHead(int val) {
     if(size==0)
     {
         head = new Node(val,null);
         size = size+1;
         return;
     }
     
    Node n = new Node(val,head);
    head = n;
    size = size+1;
 }

 public void addAtTail(int val) {
    Node n = new Node(val,null);
     
     if(size==0)
     {
         head=n;
         size=size+1;
         return;
     }
     
     Node x=head;
    for(int i=0;i<size;i++)
    {
        if(i==size-1)
        {
            x.next=n;
            size=size+1;
            return;
        }
        else
        {
            x=x.getNext();
        }
    }
 }

 public void addAtIndex(int index, int val)
 {
	   if ((head==null || size==0) && index > 0)
       {
    	   System.out.println("list is empty, cannot add element at index=" + index);
           return;
       }
	 
       if(index>size)
       {
    	   System.out.println("cannot add at index=" + index + "; index is greater than size of list=" + getSize());
           return;
       }
       else if(index==size)
       {
           addAtTail(val);
       }
       else if(index==0)
       {
           addAtHead(val);
       }
       else
       {
           Node x = head;
           Node prev=null;
           for(int i=0;i<size;i++)
           {
               if(i==index)
               {
                   Node n = new Node(val,x);
                   prev.next = n;
                   size=size+1;
               }
               else
               {
                   prev=x;
                   x = x.getNext();
               }
           }
       }
 }


 public void deleteAtIndex(int index) {
	 
	 if (head==null || size==0)
     {
    	 System.out.println("list is empty, cannot delete element at index=" + index);
         return;
     }
	 
     if(index >= size)
     {
    	 System.out.println("cannot delete at index=" + index + "; index is greater than size of list=" + getSize());
    	 return;
     }
     
     if(index==0)
     {
         head = head.getNext();
         size=size-1;
     }
     else if(index==size-1)
     {
         Node x=head;
         Node prev=null;
         for(int i=0;i<size-1;i++)
         {
        	 prev =x;
             x = x.getNext();
         }
         prev.setNext(null);
         x = null;
         size=size-1;
     }
     else
     {
         Node x=head;
         Node prev=null;
         for(int i=0;i<size;i++)
         {
             if(i==index)
             {
                 prev.next=x.getNext();
                 x=null;
                 size=size-1;
                 return;
             }
             else
             {
                 prev=x;
                 x = x.getNext();
             }
         }
     }
     
     
 }
 

public Node popFront()
{
	if(head==null || size==0)
	{
		System.out.println("cannot pop front; list is empty");
		return null;
	}
	
	Node n = head;
	Node next = head.next;
	head = next;
	size--;
	return n;
}

public Node popEnd()
{
	
	if(head==null || size==0)
	{
		System.out.println("cannot pop end; list is empty");
		return null;
	}
	
	if(size==1)
	{
		return popFront();
	}
	
	Node n=head;
	Node prev=null;
	for(int i=0;i<size;i++)
	{
		if(i==size-1)
		{
			Node t = n;
			n=null;
			prev.setNext(null);
			size--;
			return t;
		}
		else
		{
			prev=n;
			n=n.getNext();
		}
	}
	return null;
}

public void reverse()
{
	if(head==null || size==0)
	{
		System.out.println("cannot reverse list; list is empty");
	}
	
	 Node n =head;
	 Node prev=null;
	 while(n!=null)
	 {
		 Node next=n.next;
		 n.next=prev;
		 prev=n;
		 n=next;
	 }
	 head=prev;
}

public void reverser()
{
	if(head==null || size==0)
	{
		System.out.println("cannot reverse list; list is empty");
	}
	reverserh(head,null);
}

public Node reverserh(Node curr, Node prev)
{
	 if(curr==null)
	 {
		 head=prev;
		 return prev;
	 }
	 Node next=curr.next;
	 curr.next=prev;
	 return reverserh(next,curr);
}

public void printList()
{
	if(head==null || size==0) 
	{
		System.out.println("Cannot print list; list is empty");
		return;
	}
	Node n=head;
	while(n!=null)
	{
		System.out.print(n.getVal() + " ");
		n=n.getNext();
	}
	System.out.println();
}

	public static void main(String[] args) 
	{
		testLinkedList l = new testLinkedList();
		l.addAtIndex(0,19);
		l.addAtHead(5);
		l.addAtHead(7);
		l.addAtHead(4);
		l.addAtTail(9);
		l.addAtIndex(3, 8);
		l.addAtTail(11);
		l.addAtIndex(7, 75);
		l.printList();
		
		System.out.println("reversed");
		l.reverser();
		l.printList();

	}

}
