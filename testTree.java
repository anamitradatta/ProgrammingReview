package test;

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
	}
	
	public void dfsIterPostOrder(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> rightstack = new Stack<Node>();
		Node current = root;
		
		while(current!=null || !stack.isEmpty())
		{
			if(current!=null)
			{
				if(current.getRight()!=null)
				{
					rightstack.push(current.getRight());
				}
				stack.push(current);
				current = current.getLeft();
			}
			else
			{
				current = stack.peek();
				if(!rightstack.isEmpty() && current.getRight() == rightstack.peek())
				{
					current = rightstack.pop();
				}
				else
				{
					System.out.print(current.getVal() + " ");
					stack.pop();
					current=null;
				}
			}
		}
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
		t.setRoot(r1);
		t.getRoot().setLeft(r2);
		t.getRoot().setRight(r3);
		t.getRoot().getLeft().setLeft(r4);
		t.getRoot().getLeft().setRight(r5);
		t.getRoot().getRight().setLeft(r6);
		t.getRoot().getRight().setRight(r7);
		t.dfsIterPostOrder(r1);
		System.out.println();
		t.dfsPostOrder(r1);
		//System.out.println();
		//t.dfsPostOrder(r1);
		//System.out.println();
		//t.bfs(r1);
	}

}
