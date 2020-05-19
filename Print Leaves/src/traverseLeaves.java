package com.pr;

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
	
	Node insert(Node root, int key)
	{
		  if(root == null) 						//if tree is empty, create new node
		  {
			  return new Node(key);
		  }
	        if(key < root.data)					//if key is smaller, go to left sub-tree
	        {
	        	root.left  = insert(root.left,key);     //(returns a ref to d newly allocated node)
	        }
	        else if(key > root.data)			//if key is greater, go to right sub-tree
	        {
	        	root.right = insert(root.right,key);
	        }
	        return root;
	}
	
	void insert(int key) 
	{
		node = insert(node, key);
	}
	    
	static void traverseLeaves(Node root)
	{
		 
	    if (root == null)  
	        return;  
	  
	    
	    if (root.left == null && root.right == null)  		// If node is leaf, print  
	    {  
	        System.out.print( root.data +" ");  
	        return;  
	    }  
	  
	     if (root.right != null)  							// check recursively in the left tree 
	    	 traverseLeaves(root.right);  
	  
	     if (root.left != null)  							//  check recursively in the right tree
	    	 traverseLeaves(root.left);  
	}
	
	 public static void main(String args[]) 
	 {
		   Practice tree = new Practice(); 
		   tree.insert(8);
		   tree.insert(3);
		   tree.insert(1); 
		   tree.insert(6);
	       tree.insert(4); 
	       tree.insert(7); 
	       tree.insert(10); 
	       tree.insert(14);
	       tree.insert(13);
		  
	       System.out.println("leaf nodes of tree from right to left "); 
	       
	       traverseLeaves(tree.node); 
	 }
   
} 