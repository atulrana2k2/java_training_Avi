/**
 * class to represent a treeNode
 */
class Treenode {
    int val;
    Treenode left;
    Treenode right;
    Treenode next;
    Treenode(int val){
        this.val = val;
        left = right = next = null;
    }
}

/**
 * Main class containing the driver code
 */
class InitializeNextOfTree{
    public static void main(String[] args){

        //Creating a new Tree and Entering nodes in the Tree
        Treenode root = new Treenode(2);
        root.left = new Treenode(3);
        root.right = new Treenode(8);
        root.left.left = new Treenode(4);
        root.right.right = new Treenode(9);
        root.right.left = new Treenode(7);
        root.left.right = new Treenode(4);

        Treenode nextRoot = initializeNext(root);

        //print the tree level by level
        Treenode curr = nextRoot;
        while(curr.left != null){
            nextRoot = curr;
            while(nextRoot.next != null){
                System.out.print(nextRoot.val+"->");
                nextRoot = nextRoot.next;
            }
            System.out.println();
            curr = curr.left;
        }
    }

    public static Treenode initializeNext(Treenode root){

        for(Treenode head = root; head != null;){
            if(head.left == null)
                return root;

            Treenode prev = null;
            Treenode curr = head;

            while(curr != null){
                if(prev != null)
                    prev.right.next = curr.left;
                curr.left = curr.right;

                prev = curr;
                curr = curr.next;
            }
            head = head.left;
        }
        return root;
    }
}