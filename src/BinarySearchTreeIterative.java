

public class BinarySearchTreeIterative {
	
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
	
	
	public BinarySearchTreeIterative() {
		rootOfTree = null;
	}
	
	public void insertNodeIterative(int newKey,Node rootOfTree) {
		
		if (rootOfTree == null) {
			this.rootOfTree = new Node(newKey,null,null);
			return;
		}
		
		Node PositionToAdd = null;
		Node Iterator = rootOfTree;
		PositionToAdd = rootOfTree;
		
		while (Iterator != null) {
			
			PositionToAdd = Iterator;
			
			if (Iterator.key > newKey && Iterator.left != null) {
				Iterator = Iterator.left;
				continue;
			}
			if (Iterator.key > newKey && Iterator.left == null ) {
				Iterator.left = new Node(newKey,null,null);
				break;
			}
			if (Iterator.key < newKey && Iterator.right != null  ) {
				Iterator = Iterator.right;
				continue;
			}
			if (Iterator.key < newKey && Iterator.right == null ) {
				Iterator.right = new Node(newKey,null,null);
				break;
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
	
	

}
