package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class testTree {
	
	static class Node
	{
		private int val;
		private Node left;
		private Node right;
		
		public Node(int v)
		{
			val=v;
			left=null;
			right=null;
		}
		
		public Node(int v, Node l)
		{
			val=v;
			left=l;
			right=null;
		}
		
		public Node(int v, Node l, Node r)
		{
			val=v;
			left=l;
			right=r;
		}
		
		public int getVal()
		{
			return val;
		}
		
		public Node getLeft()
		{
		    return left;
		}
		
		public Node getRight()
		{
			return right;
		}
		
		public void setVal(int v)
		{
			val=v;
		}
		
		public void setLeft(Node l)
		{
			left=l;
		}
		
		public void setRight(Node r)
		{
			right=r;
		}
	}
	
	private Node root;
	
	public testTree()
	{
		root=null;
	}
	
	public testTree(Node n)
	{
		root=n;
	}
	
	public Node getRoot()
	{
	    return root;
	}
	
	public void setRoot(Node n)
	{
		root=n;
	}
	
	public void dfsPreOrder(Node n)
	{
		if(n==null)
		{
			return;
		}
		
		System.out.print(n.getVal()+" ");
		dfsPreOrder(n.getLeft());
		dfsPreOrder(n.getRight());
	}
	
	public void dfsInOrder(Node n)
	{
		if(n==null)
		{
			return;
		}
		
		dfsInOrder(n.getLeft());
		System.out.print(n.getVal()+" ");
		dfsInOrder(n.getRight());
	}
	
	public void dfsPostOrder(Node n)
	{
		if(n==null)
		{
			return;
		}
		
		dfsPostOrder(n.getLeft());
		dfsPostOrder(n.getRight());
		System.out.print(n.getVal()+" ");
	}
	
	public void dfsIterInOrder(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		while(current!=null || !stack.isEmpty())
		{
			if(current!=null)
			{
				stack.push(current);
				current = current.getLeft();
			}
			else
			{
				current = stack.pop();
				System.out.print(current.getVal() + " ");
				current = current.getRight();
			}
		}
		System.out.println();
	}
	
	public void dfsIterPreOrder(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		while(current!=null || !stack.isEmpty())
		{
			if(current!=null)
			{
				System.out.print(current.getVal() + " ");
				stack.push(current);
				current = current.getLeft();
			}
			else
			{
				current = stack.pop();
				current = current.getRight();
			}
		}
		System.out.println();
	}
	
	public void dfsIterPostOrder(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while(current!=null || !stack.isEmpty())
		{
			// go left as much as possible
			if(current!=null)
			{
				stack.push(current);
				current = current.getLeft();
			}
			else
			{
				// check if right exists for last node
				Node temp = stack.peek().getRight();
				
				// if no left or right child, we reached a leaf node
				if(temp==null)
				{
					temp=stack.pop();
					System.out.print(temp.getVal() + " ");
					
					// if we are on a right child, go to parent node if no left node exists
					while(!stack.isEmpty() && temp == stack.peek().getRight())
					{
						temp=stack.pop();
						System.out.print(temp.getVal() + " ");
					}
				}
				// go to right child
				else
				{
					current = temp;
				}
			}
			
		}
		System.out.println();
	}
	
	public void dfsIter(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			Node temp = stack.pop();
			System.out.print(temp.getVal() + " ");
			
			if(temp.getRight()!=null)
			{
				stack.push(temp.getRight());
			}
			
			if(temp.getLeft()!=null)
			{
				stack.push(temp.getLeft());
			}
		}
		System.out.println();
	}
	
	public void bfsIter(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			System.out.print(temp.getVal() + " ");
			
			if(temp.getLeft()!=null)
			{
				queue.offer(temp.getLeft());
			}
			
			if(temp.getRight()!=null)
			{
				queue.offer(temp.getRight());
			}
		}
		System.out.println();
	}
	
	public void bfs(Node root) 
	{
	      Queue<Node> queue = new LinkedList<Node>();
	      queue.offer(root);
	      while (!queue.isEmpty()) 
	      {
	          Node temp = queue.poll();
	          System.out.print(temp.getVal() + " ");
	 
	          //add left child to the queue 
	          if (temp.getLeft() != null) 
	          {
	              queue.offer(temp.getLeft());
	          }
	 
	          //add right right child to the queue 
	          if (temp.getRight() != null) 
	          {
	              queue.offer(temp.getRight());
	          }
	      }
	      System.out.println();
	  }
	
	//converts tree into graph
	public static HashMap<Integer,ArrayList<Integer>> generateGraph(Node root, boolean isUndirected)
    {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	Node current= q.poll();
        	Node left =current.getLeft();
        	Node right = current.getRight();
            
        	// create lists for nodes if not already in graph
            if(!graph.containsKey(current.getVal()))
            {
                ArrayList<Integer> l = new ArrayList<Integer>();
                graph.put(current.getVal(),l);
            }
            
            if(left!=null && !graph.containsKey(left.getVal()))
            {
                ArrayList<Integer> l = new ArrayList<Integer>();
                graph.put(left.getVal(),l);
            }
            
            if(right!=null && !graph.containsKey(right.getVal()))
            {
                ArrayList<Integer> l = new ArrayList<Integer>();
                graph.put(right.getVal(),l);
            }
            
            // add nodes path to current (undirected - both ways)
            if(left!=null)
            {
                q.offer(left);
                
                graph.get(current.getVal()).add(left.getVal());
                
                //omit this for directed graph (no backtracking)
                if(isUndirected) graph.get(left.getVal()).add(current.getVal());
            }
            
            if(right!=null)
            {
                q.offer(right);
                graph.get(current.getVal()).add(right.getVal());
                
                //omit this for directed graph (no backtracking)
                if(isUndirected) graph.get(right.getVal()).add(current.getVal());
            }
            
        }
        
        return graph;
    }    
	
	public static void printTree(Node node, String prefix)
	{
		if(node == null) return;

		printTree(node.getRight() , prefix + "   ");
	    System.out.println(prefix + node.getVal());
	    printTree(node.getLeft() , prefix + "   ");
	   
	} 

	public static void main(String[] args) {
		
		testTree t= new testTree();
		Node r1 = new Node(10);
		Node r2 = new Node(20);
		Node r3 = new Node(30);
		Node r4 = new Node(40);
		Node r5 = new Node(50);
		Node r6 = new Node(60);
		Node r7 = new Node(70);
		Node r8 = new Node(80);
		
		t.setRoot(r1);
		t.getRoot().setLeft(r2);
		t.getRoot().setRight(r3);
		t.getRoot().getLeft().setLeft(r4);
		t.getRoot().getLeft().setRight(r5);
		t.getRoot().getRight().setLeft(r6);
		t.getRoot().getRight().setRight(r7);
	    t.getRoot().getLeft().getLeft().setRight(r8);
	    
	    printTree(r1,"");
	    
	}

}
