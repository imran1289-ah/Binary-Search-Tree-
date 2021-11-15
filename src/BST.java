
public class BST {

	public static void main(String[] args) {
		
	
		System.out.println("-------------------------");
		System.out.println("Question 1");
		System.out.println("-------------------------");
	
		
		System.out.println("Inserting the keys : 9 4 11 2 6 5 7 15 17 12, using the recursive method");
		BinarySearchTree BST1 = new BinarySearchTree();
		BinarySearchTree.Node RootOfBST1 = BST1.new Node(9,null,null);
		BST1.insertNode(9,null);
		BST1.insertNode(4, BST1.getRoot());
		BST1.insertNode(11, BST1.getRoot());
		BST1.insertNode(2, BST1.getRoot());
		BST1.insertNode(6, BST1.getRoot());
		BST1.insertNode(5, BST1.getRoot());
		BST1.insertNode(7, BST1.getRoot());
		BST1.insertNode(15, BST1.getRoot());
		BST1.insertNode(17, BST1.getRoot());
		BST1.insertNode(12, BST1.getRoot());
		
		System.out.print ("Inorder traversal is : ");
		BST1.inOrder(BST1.getRoot());
		System.out.println();
		
		System.out.println("Inserting the keys : 9 4 11 2 6 5 7 15 17 12, using the iteratively method");
		BinarySearchTreeIterative BST2 = new BinarySearchTreeIterative();
		BinarySearchTreeIterative.Node RootOfBST2 = BST2.new Node(9,null,null);
		BST2.insertNodeIterative(9,null);
		BST2.insertNodeIterative(4, BST2.getRoot());
		BST2.insertNodeIterative(11, BST2.getRoot());
		BST2.insertNodeIterative(2, BST2.getRoot());
		BST2.insertNodeIterative(6, BST2.getRoot());
		BST2.insertNodeIterative(5, BST2.getRoot());
		BST2.insertNodeIterative(7, BST2.getRoot());
		BST2.insertNodeIterative(15, BST2.getRoot());
		BST2.insertNodeIterative(17, BST2.getRoot());
		BST2.insertNodeIterative(12, BST2.getRoot());
		System.out.print ("Inorder traversal is : ");
		BST2.inOrder(BST2.getRoot());
		System.out.println();
		
		
		System.out.println("-------------------------");
		System.out.println("Question 2");
		System.out.println("-------------------------");
		
		System.out.println("For the tree : 9 4 11 2 6 5 7 15 17 12, The total number of subtrees From 2 to 8");
		System.out.println("The total numbers of subtrees are "+BST1.subtreeInRange(BST1.getRoot(), 1, 40)+" subtrees");  //RootOfBST2 2 8
		System.out.println();
		
		System.out.println("-------------------------");
		System.out.println("Question 3");
		System.out.println("-------------------------");
		
		
		
		System.out.print ("Before removing,The Inorder traversal of this tree is: ");
		BST1.inOrder(BST1.getRoot());
		System.out.println();
		System.out.println("Removing nodes outside 6 to 12");
		BST1.removeOutsideRange(20,75, BST1.getRoot() );// 6 12 RootOfBST1
		
		System.out.print ("The key within the valid range are : ");
		BST1.inOrder(BST1.getRoot());
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
