package Tree.BST;

public class BST {
    TreeNode root;
    int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public void add(int val){
        root = add(root, val);
    }
    private TreeNode add(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(root.val == val){
            throw new IllegalArgumentException("Node Exists");
        }
        if(root.val > val){
            root.left = add(root.left, val);
            size++;
        } else {
            root.right = add(root.right, val);
            size++;
        }
        return root;
    }

    public void remove(int val){
        root = remove(root, val);
    }
    private TreeNode remove(TreeNode root, int val){
        if(root == null) return null;

        if(root.val > val){
            root.left = remove(root.left, val);
        } else if (root.val < val){
            root.right = remove(root.right, val);
        } else {
            if(root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            }

            TreeNode min = findMin(root);
            root.val = min.val;
            root.right = remove(root.right, root.val);
            size--;
        }
        return root;
    }
    private TreeNode findMin(TreeNode root){
        while (root != null){
            root = root.left;
        }
        return root;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public boolean contains(int val){
        return contains(root, val);
    }
    private boolean contains(TreeNode root, int val){
        if(root == null) return false;

        if(root.val == val) return true;
        if(root.val > val){
            return contains(root.left, val);
        } else {
            return contains(root.right, val);
        }

    }
}
