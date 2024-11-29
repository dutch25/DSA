package DataStructure;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {       
        this.value = value;
        left = null;
        right = null;
    }
}

public class MyTree {
    public TreeNode root;

    public MyTree() {
        this.root = null;
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);


        //xd cay
        // n1.left = n2;
        // n1.right = n3;
        // n2.left = n4;
        // n2.right = n5;
        // n3.left = n6;
        // n3.right = n7;
        // root = n1;
        //depth
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        n5.right = n8;
        root = n1;
    }


    public void print(TreeNode root) {
        if (root != null) {
            System.out.println(root.value); ///in rootq
            print(root.left);
            print(root.right);
        }
    }
}
