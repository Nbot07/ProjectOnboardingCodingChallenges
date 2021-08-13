import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelTraversal {
	
	static class Node {
		public int data;
		public Node left;
		public Node right;
		public Node(int _data){
			data = _data;
			left = right = null;
		}
	}
	
	static class BinTree {
		public Node root;
		public BinTree(Node node){
			root = node;
		}
		
		public void levelTraversal() {
			Queue<Node> nqueue = new LinkedList<Node>();
			nqueue.add(root);
			
			while(!nqueue.isEmpty()) {
				Node currentN = nqueue.poll();
				System.out.println(currentN.data);
				if(currentN.left != null) {
					nqueue.add(currentN.left);
				}
				if(currentN.right != null) {
					nqueue.add(currentN.right);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinTree myBinTree = new BinTree(new Node(1));
		myBinTree.root.left = new Node(2);
		myBinTree.root.right = new Node(3);
		myBinTree.root.left.left = new Node(4);
		myBinTree.root.left.right = new Node(5);
		myBinTree.levelTraversal();
	}

}
