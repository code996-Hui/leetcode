package leetcode.editor.cn;

//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1195 👎 0

public class 对称二叉树{
    public static void main(String[] args){
        Solution solution = new 对称二叉树().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    //传入左右子树，判断是否对称
    public boolean isMirror(TreeNode left,TreeNode right){
        //为空判断是否对称
        if (left==null&&right!=null) return false;
        if (left!=null&&right==null) return false;
        if (left==null&&right==null) return true;
        //判断val

        if (left.val!=right.val){
            return false;
        }
        boolean flag1= isMirror(left.left,right.right);
        boolean flag2= isMirror(left.right,right.left);
        return flag1&&flag2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}