package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void levelOrder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode t = queue.poll();
                sub.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.add(new ArrayList<>(sub));
        }
        System.out.println(res.toString());
    }

    private static void print(List<Integer> res){
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
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

        levelOrder(t);
        System.out.println();

    }
}
