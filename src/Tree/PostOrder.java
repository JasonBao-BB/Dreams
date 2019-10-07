package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public static void postorder(TreeNode node){
        if(node == null) return;
        List<Integer> res = new ArrayList<>();
        helper(node, res);
        print(res);
    }

    private static void helper(TreeNode root, List<Integer> res){
        if(root == null) return;

        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    private static void print(List<Integer> res){
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
    }

    public static void postorder2(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);

            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        print(res);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);

        t.left = t1;
        t.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;

        postorder(t);
        System.out.println();
        postorder2(t);
    }
}
