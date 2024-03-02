

/**
 * class representing a treeNode
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

/**
 * class containing the driver code
 */
class FlattenTree{
    static TreeNode prev;
    public static void main(String[] args){


        // create a new tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        //flattens the tree
        flattenTree(root);
        // prints the flattened tree
        printFlattenedTree(root);
    }
    public static void flattenTree(TreeNode root){
        if(root == null)
            return;
        //call recursively for right and then left side
        flattenTree(root.right);
        flattenTree(root.left);

        root.left = null;   // assign root's left as null
        root.right = prev;   // assign root's right as prev that tracks the previous visited node'
        prev = root;   //change previous node to keep track of it
    }

    //method to print the flattened tree
    public static void printFlattenedTree(TreeNode root){
        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }

}