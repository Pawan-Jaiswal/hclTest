package com.pr;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class Practice 
{ 
	Node node;
	
	static void printLevel(Node root)
	{
		if(root == null)
		{
			return;
		}
		Queue<Node> q = new LinkedList<>();			// Create an empty queue for level order tarversal
		q.add(root);
		while(q.isEmpty() == false)
		{											// Print front of queue and remove it from queue
			root = q.peek();
			System.out.print(root.data + " ");
			Node curr = q.poll();
			
			if(curr.left != null)					//left & right child Enqueue
			{
				q.add(curr.left);
			}
			if(curr.right != null)
			{
				q.add(curr.right);
			}
		}
	}
	
	 public static void main(String args[]) 
	 {
		   Practice tree = new Practice(); 
	       tree.node= new Node(1); 
	       tree.node.right= new Node(2); 
	       tree.node.right.right= new Node(5); 
	       tree.node.right.right.left= new Node(3); 
	       tree.node.right.right.right= new Node(6); 
	       tree.node.right.right.left.right = new Node(4);
	         
	       System.out.println("level order traversal of tree is  "); 
	       printLevel(tree.node); 
	 }
   
} 