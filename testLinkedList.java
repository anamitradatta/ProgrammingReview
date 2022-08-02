package test;

public class testLinkedList {
	
	public class Node
    {
        int val;
        Node next;
       
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
       
        public void setNext(Node n)
        {
            next=n;
        }
       
        public Node getNext()
        {
            return next;
        }
    }
    
    int size;
    Node head;
    
    public testLinkedList()
    {
        size=0;
        head=null;
    }
    
    public int getSize()
    {
    	return size;
    }
    
    public boolean isEmpty()
    {
    	return size==0;
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
            x.setNext(n);
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
       if(index>size)
       {
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
                   prev.setNext(n);
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
     if(index >= size || head==null)
     {
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
         for(int i=0;i<size-1;i++)
         {
             x = x.getNext();
         }
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
                 prev.setNext(x.getNext());
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
	Node n = head;
	head = head.getNext();
	return n;
}

public Node popEnd()
{
	
	if(head==null)
	{
		return null;
	}
	
	if(size==1)
	{
		Node t = head;
		head=null;
		return t;
	}
	
	Node n=head;
	for(int i=0;i<size;i++)
	{
		if(i==size-1)
		{
			Node t = n;
			n=null;
			return t;
		}
		else
		{
			n=n.getNext();
		}
	}
	return null;
}

public void reverse()
{
	 Node n =head;
	 Node prev=null;
	 while(n!=null)
	 {
		 Node next=n.next;
		 n.next=prev;
		 prev=head;
		 head=next;
	 }
}

public void reverser()
{
	reverserh(head,null);
}

public Node reverserh(Node curr, Node prev)
{
	 if(curr==null)
	 {
		 return prev;
	 }
	 Node next = curr.next;
	 curr.next=prev;
	 return reverserh(curr,prev);
	 
}

	public static void main(String[] args) {
		

	}

}
