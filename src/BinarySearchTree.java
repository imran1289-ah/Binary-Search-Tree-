
public class BinarySearchTree {
	
	public class Node{
		private int key;
		private Node right;
		private Node left;
		
		public Node() {
			key = 0;
			right = null;
			left = null;
		}
		
		public Node(int key, Node right, Node left) {
			this.key = key;
			this.right = right;
			this.left = left;
		}
		
		public void setkey(int key) {
			this.key = key;
		}
		
		public int key() {
			return key;
		}
		
		public void setright (Node right) {
			this.right = right;
		}
		
		public Node getright() {
			return right;
		}
		
		public void setleft (Node left) {
			this.left = left;
		}
		
		public Node getleft() {
			return left;
		}
		
		public String toString() {
			return "The key of this node is "+key;
		}
		
		
	}
	
	private Node rootOfTree;
	
	
	public BinarySearchTree() {
		rootOfTree = null;
	}
	
	public void insertNode(int newKey,Node rootOfTree) {
		
		if (rootOfTree == null) {
			this.rootOfTree = new Node(newKey,null,null);
			return;
		}
		
		if (rootOfTree.key > newKey) {
			
			Node leftChild = rootOfTree.left;
			
			if (leftChild == null) {
				rootOfTree.left = new Node(newKey,null,null);
				return;
			}
			else {
				insertNode(newKey,leftChild);
			}
		}
		
		if (rootOfTree.key < newKey) {
			
			Node rightChild = rootOfTree.right;
			
			if (rightChild == null) {
				rootOfTree.right = new Node(newKey,null,null);
				return;
			}
			else {
				insertNode(newKey,rightChild);
			}
		}
		
	}
	
	public void inOrder(Node rootOfTree) {
		if (rootOfTree.left != null) {
			inOrder(rootOfTree.left);
		}
		System.out.print(rootOfTree.key+" ");
		if (rootOfTree.right != null) {
			inOrder(rootOfTree.right);
		}
		
	}
	public void SetRoot(Node root) {
		rootOfTree = root;
	}
	
	public Node getRoot() {
		return rootOfTree;
	}
	
	public void DisplayRoot() {
		System.out.println(rootOfTree.key);
	}
	
	public boolean isLeaf(Node x) {
		return x.getright() == null && x.getleft() == null;
	}
	
	public boolean OneChild(Node x) {
		return ((x.getright() == null && x.getleft() != null )|| (x.getright() != null && x.getleft() == null));
	}
	
	public boolean TwoChild(Node x) {
		return x.getright() != null && x.getleft() !=null;
	}
	
	public Node Search(int key, Node root) {
		if (root == null) {
			return null;
		}
		
		if (key == root.key) {
			return root;
		}
		else if (key < root.key) {
			return Search(key,root.left);
		}
		else 
			return Search(key,root.right);
		
	}
	
	public Node minimum(Node root) {
		if (root == null) {
			return null;
		}
		
		if (root.left == null) {
			return root;
		}
		
		return minimum(root.left);
	}
	
	public Node max(Node root) {
		if (root == null) {
			return null;
		}
		
		if (root.right == null) {
			return root;
		}
		
		return max(root.right);
	}
	
	public Node Parent(Node root,int ChildKey) {
		
		if (root == null) {
			return null;
		}
		if ( (root.left != null   && root.left.key == ChildKey) || (root.right != null && root.right.key == ChildKey)) {
			return root;
		}
		else if (root.key < ChildKey) {
			return Parent(root.right,ChildKey);
		}
		else if (root.key > ChildKey) {
			return Parent(root.left,ChildKey);
		}
		else
			return null;
		
	}
	
	public boolean removeOutsideRange(int min,int max,Node root) {
		
		//Finding the minimum of the Tree
		int min_valueofBST = minimum(root).key();
		
		
		//Removing nodes outside of the minimum
		for (int i = min_valueofBST ; i < min ; i++) {
			Node toRemove = Search(i,getRoot());
			
			//Case 1 : If the node is not found
			if (toRemove == null) {
				continue;
			}
			//Case 2 : If the node is a leaf
			else if (isLeaf(toRemove)) {
				//Get the parent of the node to remove
				Node Parent = Parent(getRoot(),i);
				
				//If the child to remove is the right, remove right
				if (Parent != null && Parent.right.key == i) {
					Parent.right = null;
				}
				//if the child to remove is the left, remove left
				else if (Parent != null && Parent.left.key == i) {
					Parent.left = null;
				}
				continue;
			}
			//Case 3 deleting a node with one child
			else if (OneChild(toRemove)) {
				//Get the parent of the node to remove
				Node Parent = Parent(getRoot(),i);
				Node Child = null;
				
				//Child is the "toRemove node"
				
				//Set the child of the parent, which is the node to remove
				if (Parent!= null &&Parent.right.key == i) {
					Child = Parent.right;
				}
				else if (Parent!= null && Parent.left.key == i) {
					Child = Parent.left;
				}
				
				//Have the parent point to the child of the node to remove, different scenarios
				if (Parent!= null && Parent.right == Child && Child.left == null ) {
					Parent.right = Child.right;
					Child.right = null;
				}
				else if (Parent!= null && Parent.right == Child && Child.right == null ) {
					Parent.right = Child.left;
					Child.left = null;
				}
				else if (Parent!= null && Parent.left == Child && Child.left == null) {
					Parent.left = Child.right;
					Child.right = null;
				}
				else if (Parent!= null && Parent.left == Child && Child.right == null) {
					Parent.left = Child.left;
					Child.left = null;
				}
				continue;
			}
			//Case 4 : Deleting a  node with 2 childs 
			else if (TwoChild(toRemove)) {
				//Get the right child of the node to remove
				Node rightChild = toRemove.right;
				
				//Get the minimum child of that right subtree
				Node minimumOfRightSubree = minimum(rightChild);
				
				//Get the node toRemove
				Node toDelete = Search(toRemove.key,getRoot());
				
				//Get the parent of the node to remove
				//Node ParentOfChildToDelete = Parent(getRoot(),minimumOfRightSubree.key);
				
				
				//Remove the minimum node
				int minimum = minimumOfRightSubree.key;
				removeNode(minimum);
				
				
				//Set the key of the node to delete to the minimum of the right subtree
				toDelete.key =  minimum;
				
				/**
				if (ParentOfChildToDelete.left != null && ParentOfChildToDelete.left.key == minimumOfRightSubree.key ) {
					ParentOfChildToDelete.left = null;
				}
				else if (ParentOfChildToDelete.right != null && ParentOfChildToDelete.right.key == minimumOfRightSubree.key ) {
					ParentOfChildToDelete.right = null;
				}
				*/
				
				continue;
				
			}
		}
		
		int max_valueofBST = max(root).key();
		
		//Removing nodes outside of the max
		for (int i = max+1 ; i < max_valueofBST+1 ; i++) {
			Node toRemove = Search(i,getRoot());
					
			if (toRemove == null) {
				continue;
			}//Case 1 deleting a leaf node
			else if (isLeaf(toRemove)) {
				Node Parent = Parent(getRoot(),i);
						
				if (Parent != null && Parent.right.key == i) {
					Parent.right = null;
				}
				else if (Parent != null && Parent.left.key == i) {
					Parent.left = null;
				}
				continue;
			}
			//Case 2 deleting a node with one child
			else if (OneChild(toRemove)) {
				Node Parent = Parent(getRoot(),i);
				Node Child = null;
				if (Parent!= null && Parent.right.key == i) {
					Child = Parent.right;
				}
				else if (Parent!= null && Parent.left.key == i) {
					Child = Parent.left;
				}
				if (Parent!= null && Parent.right == Child && Child.left == null ) {
					Parent.right = Child.right;
					Child.right = null;
				}
				else if (Parent!= null && Parent.right == Child && Child.right == null ) {
					Parent.right = Child.left;
					Child.left = null;
				}
				else if (Parent!= null && Parent.left == Child && Child.left == null) {
					Parent.left = Child.right;
					Child.right = null;
				}
				else if (Parent!= null && Parent.left == Child && Child.right == null) {
					Parent.left = Child.left;
					Child.left = null;
				}
				continue;
			}
			//Case 3 : Node with 2 childs 
			else if (TwoChild(toRemove)) {
				
				Node rightChild = toRemove.right;
				Node minimumOfRightSubree = minimum(rightChild);
				Node toDelete = Search(toRemove.key,getRoot());
				//Node ParentOfChildToDelete = Parent(getRoot(),minimumOfRightSubree.key);
				
				
				
				//Remove the minimum node
				int minimum = minimumOfRightSubree.key;
				removeNode(minimum);
				
				
				//Set the key of the node to delete to the minimum of the right subtree
				toDelete.key =  minimum;
				
				
				
				/**
				if (ParentOfChildToDelete.left != null  && ParentOfChildToDelete.left.key == minimumOfRightSubree.key ) {
					ParentOfChildToDelete.left = null;
				}
				else if (ParentOfChildToDelete.right != null  && ParentOfChildToDelete.right.key == minimumOfRightSubree.key ) {
					ParentOfChildToDelete.right = null;
				}
				*/
				
				continue;
			}
		}
		return true;
		
		
	
	
	}
	
	
	//Remove method
	public boolean removeNode(int key) {
		Node toRemove = Search(key,getRoot());
		
		if (toRemove == null) {
			return false;
		
		}
		//Case 1 deleting a leaf node
		else if (isLeaf(toRemove)) {
			Node Parent = Parent(getRoot(),key);
			
			if (Parent != null && Parent.right.key == key) {
				Parent.right = null;
			}
			else if (Parent != null && Parent.left.key == key) {
				Parent.left = null;
			}
			
		}
		//Case 2 deleting a node with one child
		else if (OneChild(toRemove)) {
			Node Parent = Parent(getRoot(),key);
			Node Child = null;
			if (Parent != null && Parent.right.key == key) {
				Child = Parent.right;
			}
			else if (Parent != null && Parent.left.key == key) {
				Child = Parent.left;
			}
			
			if (Parent != null && Parent.right == Child && Child.left == null ) {
				Parent.right = Child.right;
				Child.right = null;
			}
			else if (Parent != null &&  Parent.right == Child && Child.right == null ) {
				Parent.right = Child.left;
				Child.left = null;
			}
			else if (Parent != null && Parent.left == Child && Child.left == null) {
				Parent.left = Child.right;
				Child.right = null;
			}
			else if (Parent != null && Parent.left == Child && Child.right == null) {
				Parent.left = Child.left;
				Child.left = null;
			}
			
		}
		//Case 3 : Node with 2 childs 
		
		else if (TwoChild(toRemove)) {
			//Get the right child
			Node rightChild = toRemove.right;
			//Get the minimum of the right child
			Node minimumOfRightSubree = minimum(rightChild);
			//get the partent of the child to delete
			//Node ParentOfChildToDelete = Parent(getRoot(),minimumOfRightSubree.key);
			
			//get the node of the one we want to remove
			Node toDelete = Search(toRemove.key,getRoot());
			
			//toRemove.key =  minimumOfRightSubree.key;
			//System.out.println(ParentOfChildToDelete);
			
			//Removing the minimum node of the right subtree
			int min = minimumOfRightSubree.key;
			removeNode(minimumOfRightSubree.key);
			
			//Seting the node to remove to the minimum of the right subtree
			toDelete.key = min;
			
			/**
			if (ParentOfChildToDelete.left != null && ParentOfChildToDelete.left.key == minimumOfRightSubree.key ) {
				ParentOfChildToDelete.left = null;
			}
			else if (ParentOfChildToDelete.right != null && ParentOfChildToDelete.right.key == minimumOfRightSubree.key ) {
				
				ParentOfChildToDelete.right = null;
				
			}
			*/
		}
		return true;
		
	}
	
	
	public int subtreeInRange(Node root,int min, int max) {
		
		int numOfSubtrees = 0;
		
		for (int i = min ; i < max+1 ; i++) {
			Node Search = Search(i,root);
			
			if (Search == null) {
				
			}
			//If it is a leaf 
			else if (Search != null & isLeaf(Search)) {
				numOfSubtrees++;
			}
			//If it it has one child that is in the range
			else if (Search != null && OneChild(Search)) {
				if (Search.right != null && (Search.right.key >= min && Search.right.key <= max) && Search.left == null) {
					numOfSubtrees++;
				}
				else if (Search.left != null && (Search.left.key >= min && Search.left.key <= max) && Search.right == null) {
					numOfSubtrees++;
				}
			}
			
			//if the two child of the nodes are in the range
			else if (Search != null & (Search.right != null && (Search.right.key >= min && Search.right.key <= max)) && (Search.left != null && (Search.left.key >= min && Search.left.key <= max))) {
				numOfSubtrees++;
			}
		}
		
		return numOfSubtrees;
		
	}
	

	
	
	
	
	
	
	
	
	

}
