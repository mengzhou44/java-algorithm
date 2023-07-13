package DFS;

class TreeNode {
	 private int val;
	 TreeNode left;
	  TreeNode right;

	 public TreeNode(int val) {
		 this.val = val;
		 this.left= null;
		 this.right=null;
	 }
}

// Leet code 104
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
         TreeNode root = new TreeNode(3);
		 root.left= new TreeNode(9);
		 root.right= new TreeNode(20);
		 root.right.right=new TreeNode(7);

		 int res = findMaximumDepth(root);

		System.out.println(res);
	}

	private static int findMaximumDepth(TreeNode node) {
		if (node == null) return 0;

		 int left = findMaximumDepth(node.left);
		 int right = findMaximumDepth(node.right);

		 return Math.max(left, right) + 1;

	}
}
